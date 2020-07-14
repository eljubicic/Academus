/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.academus.kod;




import com.academus.tablice.DatumVrijeme;
import com.academus.tablice.Smjer;
import com.academus.tablice.Kolegij;
import com.academus.tablice.KolegijSmjerOdjel;
import com.academus.tablice.Djelatnik;
import com.academus.tablice.Student;
import com.academus.tablice.Korisnik;
import com.academus.tablice.Odjel;
import com.academus.tablice.Nastava;
import com.academus.tablice.TipNastava;
import com.academus.tablice.Ocjena;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.Time;






public final class BazaPodataka {
    

 private final String DRIVER = "com.mysql.jdbc.Driver";
 private final String URL = "jdbc:mysql://localhost:3306/academus";
 private final String USER = "root";
 private final String PASSWORD = "emanuel77";

 private Connection dbCon;
 private PreparedStatement dbStmnt;
 private ResultSet rs = null;
 private String sql;


 public int konekcijaBaze() {
  int status = 0;
  try {
  Class.forName(DRIVER);
  dbCon = DriverManager.getConnection(URL, USER, PASSWORD);
  dbCon.setAutoCommit(false);
  status = 1;
 
  } 
  catch (ClassNotFoundException ex){
   ex.printStackTrace(System.out);
   System.out.println("Driver klasa nije pronađena!");
   status = -1;
  }
  catch (SQLException ex) {
   ex.printStackTrace(System.out);
   System.out.println("Problem s uspostavljanjem konekcije baze podataka!");
   status = -1;
  }
  return status;
 }
 
 public  void zatvaranjeKonekcije()
 {
     try{
     dbCon.close();
     System.out.println("Konekcija s bazom podataka uspješno zatvorena.");
     }
     catch(SQLException ex)
     {
        System.out.println("Problem sa zatvaranjem konekcije baze podataka."); 
     }
    
     
 }
 
 
  public int dohvatiKorisnik(String u,String p)
  {
      int status = 0;
      String oib = "oib";
      boolean admin=false;
      
      try {  
     sql = "SELECT DISTINCT(korisnickoIme),lozinka,admin,oibDjelatnik FROM korisnik WHERE korisnickoIme = '"+u+"' ";
     
     try {
      dbStmnt = dbCon.prepareStatement(sql);

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }

     rs = dbStmnt.executeQuery(sql);
     if (rs.next()) {
     
       
         status = 1;
         
         String pass = rs.getString("lozinka");
         admin = rs.getString("admin").equals("DA");
         
         oib = rs.getString("oibDjelatnik");
         
         
            if (!p.equals(pass))
            {
                System.out.println("Lozinka je netočna!");
                status = -1;
            }
     }
     
     else 
     {
        System.out.println("Korisničko ime ne postoji!"); 
     }

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s čitanjem iz tablice.");
    }
    
    if(status == 1)
    {
      
        Djelatnik dj = dohvatiDjelatnik(oib);
        Main.setKorisnik(new Korisnik(u,p,admin,dj));
        
        System.out.println("-----------------------------------------------");
        System.out.println("KORISNIK: "+Main.getKorisnik().getKorisnickoIme());
        System.out.println("OIB: "+oib);
        
         if(admin == true)
        {
            System.out.println("KORISNIK JE ADMINISTRATOR");    
        }
         
        System.out.println("-----------------------------------------------");
        System.out.println();
      
        
       
        
    }
        
    return status;
  }
  
  public Djelatnik dohvatiDjelatnik(String oib)
  {
    
      Djelatnik djelatnik = new Djelatnik();
      
      try { 
     sql = "SELECT * FROM djelatnik WHERE oib = '"+oib+"' ";
     
     try {
      dbStmnt = dbCon.prepareStatement(sql);

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }
     rs = dbStmnt.executeQuery(sql);
     
     
       boolean records = false;
       while (rs.next()) {
           
         records = true;
         String ime = rs.getString("ime");
         String prezime = rs.getString("prezime");
         String titula = rs.getString("titula");
         String email = rs.getString("email");
         String mobitel = rs.getString("mobitel");
         String telefon = rs.getString("telefon");
         
          djelatnik = new Djelatnik(ime, prezime, titula,email,mobitel, telefon);
    
            
     }
     
     if(records != true) 
     {
        System.out.println("Djelatnik s navednim OIB-om ne postoji!"); 
     }

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s čitanjem iz tablice.");
    }
      return djelatnik;
  }
  
  
  public ArrayList <Djelatnik> dohvatiImenikDjelatnike()
  {
      ArrayList <Djelatnik> djelatnici = new ArrayList();
      
      try { 
     sql = "SELECT ime,prezime,titula,email,mobitel,telefon FROM djelatnik ORDER BY 2,1,3,4,5,6 asc";
     
     try {
      dbStmnt = dbCon.prepareStatement(sql);

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }
     rs = dbStmnt.executeQuery(sql);
     
     
       boolean records = false;
       while (rs.next()) {
           
         records = true;
         String ime = rs.getString("ime");
         String prezime = rs.getString("prezime");
         String titula = rs.getString("titula");
         String email = rs.getString("email");
         String telefon = rs.getString("telefon");
         String mobitel = rs.getString("mobitel");
         
         Djelatnik djelatnik = new Djelatnik(ime, prezime, titula, email, mobitel, telefon);
         djelatnici.add(djelatnik);
    
            
     }
     
     if(records != true) 
     {
        System.out.println("Nije u tablicu upisan niti jedan djelatnik!"); 
     }

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s čitanjem iz tablice.");
    }
      return djelatnici;
  }
  
  public ArrayList <Student> dohvatiImenikStudente()
  {
      ArrayList <Student> studenti = new ArrayList();
      
      try { 
     sql = "SELECT ime,prezime,jmbag,email,mobitel,telefon FROM student ORDER BY 2,1,3,4,5,6 asc";
     
     try {
      dbStmnt = dbCon.prepareStatement(sql);

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }
     rs = dbStmnt.executeQuery(sql);
     
     
       boolean records = false;
       while (rs.next()) {
           
         records = true;
         String jmbag = rs.getString("jmbag");
         String ime = rs.getString("ime");
         String prezime = rs.getString("prezime");
         String email = rs.getString("email");
         String telefon = rs.getString("telefon");
         String mobitel = rs.getString("mobitel");
         
         Student student = new Student(jmbag, ime, prezime, email, mobitel, telefon);
       
         studenti.add(student);
    
            
     }
     
     if(records != true) 
     {
        System.out.println("Nije u tablicu upisan niti jedan student!"); 
     }

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s čitanjem iz tablice.");
    }
      return studenti;
  }
  
    public ArrayList <Student> dohvatiKolegijStudente(int vrstaStudenta,String idKolegij)
  {
      ArrayList <Student> studenti = new ArrayList();
      
      
      if(vrstaStudenta != 4)
      {
          
      
      try { 
          
          switch (vrstaStudenta) {
              case 1:
                 sql = "SELECT ime,prezime,jmbag,vrsta,email,mobitel FROM student "+
                       " inner join ocjena on ocjena.jmbagStudent = student.jmbag "+
                       " inner join kolegij on kolegij.idKolegij = ocjena.idKolegij "+
                       " WHERE ocjena.idKolegij = "+idKolegij+" and student.vrsta = 'R'  ORDER BY 2,1,3,4,5,6 asc  ";
                  break;
              case 2:
                 sql = "SELECT ime,prezime,jmbag,vrsta,email,mobitel FROM student "+
                       " inner join ocjena on ocjena.jmbagStudent = student.jmbag "+
                       " inner join kolegij on kolegij.idKolegij = ocjena.idKolegij "+
                       " WHERE ocjena.idKolegij = "+idKolegij+" and student.vrsta = 'I'  ORDER BY 2,1,3,4,5,6 asc  ";
                  break;
              case 3:
                 sql = "SELECT ime,prezime,jmbag,vrsta,email,mobitel FROM student "+
                       " inner join ocjena on ocjena.jmbagStudent = student.jmbag "+
                       " inner join kolegij on kolegij.idKolegij = ocjena.idKolegij "+
                       " WHERE ocjena.idKolegij = "+idKolegij+"   ORDER BY 2,1,3,4,5,6 asc  ";
                  break;
  
                 
          }
     
     
     try {
      dbStmnt = dbCon.prepareStatement(sql);

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }
     rs = dbStmnt.executeQuery(sql);
     
     
       boolean records = false;
       while (rs.next()) {
           
         records = true;
         String jmbag = rs.getString("jmbag");
         String ime = rs.getString("ime");
         String prezime = rs.getString("prezime");
         String vrsta = rs.getString("vrsta");
         String email = rs.getString("email");
         String mobitel = rs.getString("mobitel");
         
         char vrstaChar = vrsta.charAt(0);
         
         Student student = new Student(jmbag, ime, prezime, email, mobitel, vrstaChar);
       
         studenti.add(student);
    
            
     }
     
     if(records != true) 
     {
        System.out.println("Nije u tablicu upisan niti jedan student!"); 
     }

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s čitanjem iz tablice.");
    }
      }
      
      return studenti;
  }
  
  public ArrayList <Student> dohvatiKolegijOcjene(int vrstaOcjene,String idKolegij)
  {
      ArrayList <Student> studenti = new ArrayList();
      
      String konacnaOcjena = " ";
      
   
      
      if(vrstaOcjene != 4)
      {
          
      
      try { 
          
          switch (vrstaOcjene) {
              case 1:
                  konacnaOcjena = " and ocjena.konacnaOcjena IS NULL ";
                  break;
              case 2:
                  konacnaOcjena = " and ocjena.konacnaOcjena IS NOT NULL ";
                  break;
              case 3:
                  konacnaOcjena = " ";
                  break;
  
                 
          }
          
             sql = "SELECT student.ime,student.prezime,student.jmbag,student.vrsta,ocjena.ocjenaUsmeni,ocjena.ocjenaPismeni, "
                         + " ocjena.konacnaOcjena, ocjena.datumPolaganja, ocjena. datumUnosa, ocjena. biljeska FROM student "+
                       " inner join ocjena on ocjena.jmbagStudent = student.jmbag "+
                       " inner join kolegij on kolegij.idKolegij = ocjena.idKolegij "+
                       " WHERE ocjena.idKolegij = "+idKolegij+ konacnaOcjena +" ORDER BY 2,1,3,4,5,6,7,8,9,10 asc  ";
     
     
     try {
      dbStmnt = dbCon.prepareStatement(sql);

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }
     rs = dbStmnt.executeQuery(sql);
     
     
       boolean records = false;
       while (rs.next()) {
           
         records = true;
         String jmbag = rs.getString("jmbag");
         String ime = rs.getString("ime");
         String prezime = rs.getString("prezime");
         String vrsta = rs.getString("vrsta");
         
        
         int ocjenaUsmeni= rs.getInt("ocjena.ocjenaUsmeni");
         int ocjenaPismeni= rs.getInt("ocjena.ocjenaPismeni");
         int  ocjenaKonacna=  rs.getInt("ocjena.konacnaOcjena");
         
         Date datumPolaganja = rs.getDate("ocjena.datumPolaganja");
         Date datumUnosa = rs.getDate("ocjena.datumUnosa");
        
         
         
         
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");  
        
        String polaganje = " ";
        String unos = " ";
        
        if(datumPolaganja != null)
        {
            polaganje = dateFormat.format(datumPolaganja); 
        }
       
        if(datumUnosa != null)
        {
            unos = dateFormat.format(datumUnosa);  
        }
         
         
         char vrstaChar = vrsta.charAt(0);
         
         Ocjena ocjena = new Ocjena(ocjenaUsmeni,ocjenaPismeni,ocjenaKonacna,polaganje,unos);
         
         Student student = new Student(jmbag, ime, prezime, vrstaChar,ocjena);
       
         studenti.add(student);
    
            
     }
     
     if(records != true) 
     {
        System.out.println("Nije u tablicu upisana niti jedna ocjena!"); 
     }

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s čitanjem iz tablice.");
    }
      }
      
      return studenti;
  }
  
  
  public ArrayList <TipNastava> dohvatiTipNastave()
  {
        ArrayList <TipNastava> nastavaTipovi = new ArrayList();
  
      
      try { 
          
 
             sql = " SELECT * from tipNastava  order by 2,3";
     
     
     try {
      dbStmnt = dbCon.prepareStatement(sql);

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }
     rs = dbStmnt.executeQuery(sql);
     
     
       boolean records = false;
       while (rs.next()) {
           
         records = true;
        
         int idTip= rs.getInt("idTip");
         String naziv = rs.getString("naziv");
         
         boolean obavezno = rs.getInt("obaveznoPohadjanje") == 1;
      
         TipNastava tipNastava = new TipNastava(idTip,naziv,obavezno);
         
         nastavaTipovi.add(tipNastava);
            
     }
     
     if(records != true) 
     {
        System.out.println("Nije u tablicu upisan niti jedan tip nastave!"); 
     }

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s čitanjem iz tablice.");
    }
      
      
      return nastavaTipovi;
  }
  
      
  public ArrayList <Nastava> dohvatiKolegijNastava(String tipNastave,String idKolegij)
  {
      ArrayList <Nastava> nastave = new ArrayList();
System.out.println(tipNastave+" "+idKolegij);
      try { 
          
          int indexZareza = tipNastave.indexOf('-');
          String tipNastaveNaziv =tipNastave.substring(0,indexZareza);
          tipNastaveNaziv = tipNastaveNaziv.trim();
 
          sql = "select nastava.*, lokacija.naziv as prostorija, CONCAT(lokacija.adresa,', ',mjesto.naziv) as lokacija," 
          + " CONCAT(djelatnik.prezime,' ',djelatnik.ime) as djelatnik from nastava inner join tipNastava on tipnastava.idTip = nastava.idTip "
          + " inner join lokacija on lokacija.idLokacija = nastava.idLokacija inner join mjesto on lokacija.pbrMjesto = mjesto.pbr inner join djelatnik on "
          + " nastava.oibDjelatnik = djelatnik.oib "
          + " where tipNastava.naziv = '"+ tipNastaveNaziv +"' and nastava.idKolegij = "+idKolegij
          + " order by nastava.opis, datumOdrzavanja,vrijemeOdrzavanja,vrijemeOdrzavanjaDo,djelatnik,prostorija,lokacija ";

     
     
     try {
      dbStmnt = dbCon.prepareStatement(sql); }
     catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }
     
     rs = dbStmnt.executeQuery(sql); 
     
       boolean records = false;
       while (rs.next()) {
           
        
         String opis = rs.getString("nastava.opis");
         Date datumOdr = rs.getDate("nastava.datumOdrzavanja");
         
         Time vrijemeOdr = rs.getTime("nastava.vrijemeOdrzavanja");
         Time vrijemeOdrDo = rs.getTime("nastava.vrijemeOdrzavanjaDo");
         
         String prostorija = rs.getString("prostorija");
         String lokacija = rs.getString("lokacija");
         String djelatnik = rs.getString("djelatnik");
         
         int brPrisutnih = rs.getInt("nastava.brojPrisutnih");
                
          DatumVrijeme datumVrijeme = new DatumVrijeme(datumOdr,vrijemeOdr,vrijemeOdrDo);
          
          Nastava nastava = new Nastava(opis, datumVrijeme, prostorija, lokacija, djelatnik, brPrisutnih);      
        nastave.add(nastava);
        
        }
     
     if(records != true) 
     {
        System.out.println("Nije u tablicu upisana niti jedna nastava!"); 
     }

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s čitanjem iz tablice.");
    }
      
      
      return nastave;
  }
  
  
  
  
  
   
   
    public ArrayList <KolegijSmjerOdjel> dohvatiKolegijSmjerOdjel(String username)
  {
      ArrayList <KolegijSmjerOdjel> podaci = new ArrayList();
      
      
       try { 
      sql = " SELECT  odjel.idOdjel,odjel.naziv,smjer.idSmjer,smjer.naziv,kolegij.idKolegij,kolegij.naziv,uloga.naziv FROM odjel "
      + " inner join smjer on smjer.idOdjel = odjel.idOdjel "
      + " inner join kolegij on kolegij.idSmjer = smjer.idSmjer "
      + " inner join izvrsitelj on izvrsitelj.idKolegij = kolegij.idKolegij "
      + " inner join uloga on izvrsitelj.idUloga = uloga.idUloga "
      + " inner join djelatnik on djelatnik.oib = izvrsitelj.oibdjelatnik "
      + " inner join korisnik on korisnik.oibDjelatnik = djelatnik.oib "
      + " where korisnik.korisnickoIme = '"+username+"' and izvrsitelj.aktivan = 1 "
      + " group by odjel.naziv, smjer.naziv,kolegij.naziv "
      + " order by odjel.naziv,smjer.naziv,kolegij.naziv";
      

        
     try {
      dbStmnt = dbCon.prepareStatement(sql);

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }
     rs = dbStmnt.executeQuery(sql);
    
     
     
       boolean records = false;
       
        while(rs.next()) {
         
         records = true;
         
         int idKolegij = rs.getInt("kolegij.idKolegij");
         String nazivKolegij= rs.getString("kolegij.naziv");
         String uloga= rs.getString("uloga.naziv");
         
         int idSmjer = rs.getInt("smjer.idSmjer");
         String nazivSmjer = rs.getString("smjer.naziv");
         
         int idOdjel = rs.getInt("odjel.idOdjel");
         String nazivOdjel = rs.getString("odjel.naziv");
         
         Kolegij k = new Kolegij(idKolegij,nazivKolegij,uloga);
         Smjer s = new Smjer(idSmjer,nazivSmjer);
         Odjel o = new Odjel(idOdjel,nazivOdjel);
         
         KolegijSmjerOdjel kso = new KolegijSmjerOdjel(k,s,o);
         podaci.add(kso);
         
        }
        
       
        if(records == false)
        {
          System.out.println("Ne postoje upisani kolegiji za ovog korisnika!");  
        }
    

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s čitanjem iz tablice.");
    }
      
      
      return podaci;
  }
   
    
      public void unosOcjena(String jmbag,String idKolegij,String p,String u,String k,Date polaganje)
  {

      
       try { 
      sql = " UPDATE  ocjena SET ocjenaUsmeni = ? , ocjenaPismeni = ? , konacnaOcjena = ? , datumPolaganja = ? , datumUnosa = ? "
          + " WHERE jmbagStudent = ? AND idKolegij = ? ";
        
     try {
      dbStmnt = dbCon.prepareStatement(sql);
      
      java.sql.Date datumPolaganja;
      
      
    
       
      java.sql.Date datumUnosa= new java.sql.Date(Calendar.getInstance().getTime().getTime());
      
      dbStmnt.setString (1,u);
      dbStmnt.setString (2,p);
      dbStmnt.setString (3,k);
      
      if(polaganje != null)
       {
                  datumPolaganja= new java.sql.Date(polaganje.getTime());
                  dbStmnt.setDate(4, datumPolaganja);             
       }
      else
      {
                  dbStmnt.setNull(4,java.sql.Types.NULL);
      }
      
      
      dbStmnt.setDate(5,datumUnosa);
      
      
      dbStmnt.setString (6,jmbag);
      dbStmnt.setString (7,idKolegij);
     

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }
     
     
    dbStmnt.execute();
    dbCon.commit();
            

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s unosom u tablicu");
    }
 
  }
   
   
   
   
  


}




