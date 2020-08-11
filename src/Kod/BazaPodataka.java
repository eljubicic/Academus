/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kod;




import KlaseTablica.Boraviste;
import KlaseTablica.DatumVrijeme;
import KlaseTablica.Smjer;
import KlaseTablica.Kolegij;
import KlaseTablica.KolegijSmjerOdjel;
import KlaseTablica.Djelatnik;
import KlaseTablica.Dolazak;
import KlaseTablica.Student;
import KlaseTablica.Korisnik;
import KlaseTablica.Lokacija;
import KlaseTablica.Odjel;
import KlaseTablica.Nastava;
import KlaseTablica.TipNastava;
import KlaseTablica.Ocjena;
import KlaseTablica.Prebivaliste;
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
 private final String USER = "korisnikbaze";
 private final String PASSWORD = "academus2020";

 private Connection dbCon;
 private PreparedStatement dbStmnt;
 private ResultSet rs = null;
 private String sql;


 public int konekcijaBaze() {
  int status = 0;
  try {
  Class.forName(DRIVER);

  dbCon = DriverManager.getConnection(URL,USER,PASSWORD);
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
   
   status = -2;
  }
  return status;
 }
 
 public  void zatvaranjeKonekcije()
 {
     try{
         try{
     dbCon.close();
     System.out.println("Konekcija s bazom podataka uspješno zatvorena.");
     }
         catch(Exception e)
         {
             Main.formaPrijava.dispose();
             System.exit(1);
         }
     
     }
     catch(Exception ex)
     {
        System.out.println("Problem sa zatvaranjem konekcije baze podataka."); 
     }
    
     
 }
 
 
  public int dohvatiKorisnika(String u,String p)
  {
      int status = 0;
      String oib = "oib";
      boolean admin=false;
      
      try {  
     sql = "SELECT DISTINCT(korisnickoIme),lozinka,admin,oibDjelatnik "
             + "FROM korisnik WHERE korisnickoIme = '"+u+"' ";
     
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
      
        Djelatnik dj = dohvatiDjelatnika(oib);
        Main.setKorisnik(new Korisnik(u,p,admin,dj));
        
        System.out.println("-----------------------------------------------");
        System.out.println("KORISNIK: "+Main.getKorisnik().getKorisnickoIme());
        System.out.println("OIB: "+oib);
        Main.getKorisnik().getDjelatnik().setOib(oib);
        
         if(admin == true)
        {
            System.out.println("KORISNIK JE ADMINISTRATOR");    
        }
         
        System.out.println("-----------------------------------------------");
        System.out.println();
      
        
       
        
    }
        
    return status;
  }
  
    public Djelatnik dohvatiDjelatnika(String oib)
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
  
  public ArrayList <String> dohvatiPrijave()
           
  {
    
     ArrayList <String> imena = new ArrayList();
      
      try { 
     sql = "select korisnik.korisnickoIme from prijava "
            +" inner join korisnik on prijava.idKorisnik = korisnik.idKorisnik "
            +" order by datumPrijave desc "
            +" limit 20 " ;
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
         String kime = rs.getString("korisnik.korisnickoIme");
         
         imena.add(kime);
              
     }
     
     if(records != true) 
     {
        System.out.println("Nema prijava!"); 
     }

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s čitanjem iz tablice.");
    }
      return imena;
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
  
  
  public ArrayList <Djelatnik> dohvatiAdresarDjelatnike()
  {
      ArrayList <Djelatnik> djelatnici = new ArrayList();
      
      try { 
     sql =  "select djelatnik.prezime,djelatnik.ime,djelatnik.titula,djelatnik.adresaPreb,djelatnik.adresaBor,CONCAT(mjesto_p.pbr,' ',mjesto_p.naziv) as preb,"
             + " CONCAT(mjesto_b.pbr,' ',mjesto_b.naziv) as bor from djelatnik inner join mjesto mjesto_p on djelatnik.pbrMjestoPreb = mjesto_p.pbr "
             + " inner join mjesto mjesto_b on djelatnik.pbrMjestoBor = mjesto_b.pbr  ORDER BY 1,2,6,7,4,5,3";
     
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
         String ime = rs.getString("djelatnik.ime");
         String prezime = rs.getString("djelatnik.prezime");
         String titula = rs.getString("djelatnik.titula");
         String preb = rs.getString("preb");
         String bor = rs.getString("bor");
         String adresaPreb = rs.getString("djelatnik.adresaPreb");
         String adresaBor = rs.getString("djelatnik.adresaBor");
         
        
         
         Prebivaliste p = new Prebivaliste(adresaPreb,preb);
         Boraviste b = new Boraviste(adresaBor,bor);
        
         Djelatnik dj = new Djelatnik(ime,prezime,titula,p,b);
       
         djelatnici.add(dj);
    
            
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
  
  public ArrayList <Student> dohvatiAdresarStudente()
  {
      ArrayList <Student> studenti = new ArrayList();
      
      try { 
     sql =  "select student.prezime,student.ime,student.jmbag,student.adresaPreb,student.adresaBor,CONCAT(mjesto_p.pbr,' ',mjesto_p.naziv) as preb,"
             + " CONCAT(mjesto_b.pbr,' ',mjesto_b.naziv) as bor from student inner join mjesto mjesto_p on student.pbrMjestoPreb = mjesto_p.pbr "
             + " inner join mjesto mjesto_b on student.pbrMjestoBor = mjesto_b.pbr  ORDER BY 1,2,6,7,4,5,3";
     
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
         String ime = rs.getString("student.ime");
         String prezime = rs.getString("student.prezime");
         String jmbag = rs.getString("student.jmbag");
         String preb = rs.getString("preb");
         String bor = rs.getString("bor");
         String adresaPreb = rs.getString("student.adresaPreb");
         String adresaBor = rs.getString("student.adresaBor");
         
        
         
         Prebivaliste p = new Prebivaliste(adresaPreb,preb);
         Boraviste b = new Boraviste(adresaBor,bor);
        
         Student st = new Student(jmbag, ime, prezime, p, b);
       
         studenti.add(st);
    
            
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
    
     public ArrayList <Dolazak> dohvatiStudentDolaske(String jmbag, String idKolegij)
  {
      ArrayList <Dolazak> dolasci = new ArrayList();
      
      
      try { 

        sql = " select dolazak.prisutan,nastava.opis,nastava.datumOdrzavanja,tipnastava.naziv, "
        + "IF(tipnastava.obaveznoPohadjanje=1,'DA','NE') as obavezno "
        + " from dolazak inner join nastava on nastava.idNastava = dolazak.idNastava "       
        + " inner join tipnastava on tipnastava.idTip = nastava.idTip "
        + " where jmbagStudent = '"+jmbag+"' "
        + " and nastava.idKolegij = "+idKolegij
        + " order by tipnastava.naziv,nastava.opis,datumOdrzavanja ";

  
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
         
         String prisutan = rs.getString("dolazak.prisutan");
         String opis = rs.getString("nastava.opis");
         Date datumOdrz = rs.getDate("nastava.datumOdrzavanja");
         String tipNastava = rs.getString("tipnastava.naziv");
         String obavezno = rs.getString("obavezno");
         
         System.out.println(prisutan +" "+opis+" "+datumOdrz+" "+tipNastava+" "+obavezno);
         
             
         Dolazak dolazak = new Dolazak(prisutan, opis, datumOdrz, tipNastava, obavezno);
        
       
         dolasci.add(dolazak);
    
            
     }
     
     if(records != true) 
     {
        System.out.println("Nije u tablicu upisan niti jedan student!"); 
     }

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s čitanjem iz tablice.");
    }
     
      
      return dolasci;
  }
  
        public ArrayList <Student> dohvatiKolegijStudente(String idKolegij)
  {
      ArrayList <Student> studenti = new ArrayList();
      
      
   
      
      try { 
          

    
                 sql = "SELECT ime,prezime,jmbag,vrsta FROM student "+
                       " inner join ocjena on ocjena.jmbagStudent = student.jmbag "+
                       " inner join kolegij on kolegij.idKolegij = ocjena.idKolegij "+
                       " WHERE ocjena.idKolegij = "+idKolegij+"   ORDER BY 2,1,3 asc  ";
                 
  
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
     
         
         char vrstaChar = vrsta.charAt(0);
         
         Student student = new Student(jmbag, ime, prezime, vrstaChar);
       
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
  
  public ArrayList <Lokacija> dohvatiLokacije()
  {
        ArrayList <Lokacija> lokacije = new ArrayList();
  
      
      try { 
          
             sql = " SELECT lokacija.idLokacija,lokacija.naziv,lokacija.adresa,mjesto.naziv from lokacija inner join  mjesto on mjesto.pbr = lokacija.pbrMjesto  "
                     + "order by lokacija.naziv,lokacija.adresa,mjesto.naziv,lokacija.idLokacija ";
     
     
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
        
         String lokacijaNaziv= rs.getString("lokacija.naziv").trim();
         String lokacijaAdresa= rs.getString("lokacija.adresa").trim();
         String mjestoNaziv= rs.getString("mjesto.naziv").trim();
         int lokacijaId = rs.getInt("lokacija.idLokacija");
         
      
         Lokacija lokacija = new Lokacija(lokacijaId,lokacijaNaziv,lokacijaAdresa,mjestoNaziv);
      
         lokacije.add(lokacija);
            
     }
     
     if(records != true) 
     {
        System.out.println("Nije u tablicu upisan niti jedna lokacija!"); 
     }

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s čitanjem iz tablice.");
    }
      
      
      return lokacije;
  }
  
      
  public ArrayList <Nastava> dohvatiKolegijNastave(String tipNastave,String idKolegij)
  {
      ArrayList <Nastava> nastave = new ArrayList();

      try { 
          
       
          int indexZareza = tipNastave.indexOf('-');
          String tipNastaveNaziv =tipNastave.substring(0,indexZareza).trim();
      
          String sufiks = tipNastave.substring(indexZareza+1).trim();
    
         
      
           boolean obavezno = !sufiks.equals("neobavez.");
           
           int obaveznoInt = obavezno ? 1 : 0 ;
     
 
          sql = "select nastava.*, lokacija.naziv as prostorija, CONCAT(lokacija.adresa,', ',mjesto.naziv) as lokacija," 
          + " CONCAT(djelatnik.prezime,' ',djelatnik.ime) as djelatnik from nastava inner join tipNastava on tipnastava.idTip = nastava.idTip "
          + " inner join lokacija on lokacija.idLokacija = nastava.idLokacija inner join mjesto on lokacija.pbrMjesto = mjesto.pbr inner join djelatnik on "
          + " nastava.oibDjelatnik = djelatnik.oib "
          + " where tipNastava.naziv = '"+ tipNastaveNaziv +"' and nastava.idKolegij = "+idKolegij +"  and tipNastava.obaveznoPohadjanje = "+obaveznoInt
          + "  order by datumOdrzavanja,vrijemeOdrzavanja,vrijemeOdrzavanjaDo,nastava.opis,djelatnik,prostorija,lokacija ";

     
     
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
         int idNastava = rs.getInt("nastava.idNastava");
                
          DatumVrijeme datumVrijeme = new DatumVrijeme(datumOdr,vrijemeOdr,vrijemeOdrDo);
          
          Nastava nastava = new Nastava(opis, datumVrijeme, prostorija, lokacija, djelatnik, brPrisutnih,idNastava);      
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
  
  
  
      
  public ArrayList <Nastava> dohvatiDolaske(String tipNastave,String idKolegij)
  {
      ArrayList <Nastava> nastave = new ArrayList();

      try { 
          
       
          int indexZareza = tipNastave.indexOf('-');
          String tipNastaveNaziv =tipNastave.substring(0,indexZareza).trim();
      
          String sufiks = tipNastave.substring(indexZareza+1).trim();
    
         
      
           boolean obavezno = !sufiks.equals("neobavez.");
           
           int obaveznoInt = obavezno ? 1 : 0 ;
     
 
          sql = "select nastava.*, lokacija.naziv as prostorija, CONCAT(lokacija.adresa,', ',mjesto.naziv) as lokacija," 
          + " CONCAT(djelatnik.prezime,' ',djelatnik.ime) as djelatnik from nastava inner join tipNastava on tipnastava.idTip = nastava.idTip "
          + " inner join lokacija on lokacija.idLokacija = nastava.idLokacija inner join mjesto on lokacija.pbrMjesto = mjesto.pbr inner join djelatnik on "
          + " nastava.oibDjelatnik = djelatnik.oib "
          + " where tipNastava.naziv = '"+ tipNastaveNaziv +"' and nastava.idKolegij = "+idKolegij +"  and tipNastava.obaveznoPohadjanje = "+obaveznoInt
          + "  order by datumOdrzavanja,vrijemeOdrzavanja,vrijemeOdrzavanjaDo,nastava.opis,djelatnik,prostorija,lokacija ";

     
     
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
         int idNastava = rs.getInt("nastava.idNastava");
                
          DatumVrijeme datumVrijeme = new DatumVrijeme(datumOdr,vrijemeOdr,vrijemeOdrDo);
          
          Nastava nastava = new Nastava(opis, datumVrijeme, prostorija, lokacija, djelatnik, brPrisutnih,idNastava);      
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
  
   
  
   
   
    public ArrayList <KolegijSmjerOdjel> dohvatiKolegijSmjerOdjele(String username)
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
   
    
      public void unosOcjena(String jmbag,String idKolegij,String p,
              String u,String k,Date polaganje)
  {
       try { 
      sql = " UPDATE  ocjena SET ocjenaUsmeni = ? , ocjenaPismeni = ? ,"
              + " konacnaOcjena = ? , datumPolaganja = ? , datumUnosa = ? "
              + " WHERE jmbagStudent = ? AND idKolegij = ? ";
        
     try {
      dbStmnt = dbCon.prepareStatement(sql);
      
      java.sql.Date datumPolaganja;
      java.sql.Date datumUnosa= new java.sql.Date(Calendar.getInstance().
              getTime().getTime());      
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
      
      public void unosNastave(Date datumOdrz,Time vrijemeOd,Time vrijemeDo,
              String opis,int idTip,int idLokacija,
              String oibDjelatnik,String idKolegij)
  {

      
       try { 
      sql = " INSERT into nastava(datumOdrzavanja,vrijemeOdrzavanja,opis,idTip,"
              + "idLokacija,oibDjelatnik,idKolegij,vrijemeOdrzavanjaDo)"
              + " VALUES(?,?,?,?,?,?,?,?) ";
      
        
     try {
      dbStmnt = dbCon.prepareStatement(sql);
      
      java.sql.Date datumOdrzavanja;
      
       datumOdrzavanja= new java.sql.Date(datumOdrz.getTime());
       
       dbStmnt.setDate(1, datumOdrzavanja); 
       dbStmnt.setTime(2, vrijemeOd);
       dbStmnt.setString(3, opis);
       dbStmnt.setInt(4, idTip);
       dbStmnt.setInt(5, idLokacija);
       dbStmnt.setString(6, oibDjelatnik);
       dbStmnt.setString(7, idKolegij);
       dbStmnt.setTime(8, vrijemeOd);
       
       

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }
     
     
    dbStmnt.execute();
    dbCon.commit();
    this.unosDolaska(idKolegij);

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s unosom u tablicu");
    }
       
     
 
  }
   
      
        public void unosPrijave(String kime)
  {

      
       try { 
      sql = " INSERT INTO prijava(idKorisnik,datumPrijave) "
          + " SELECT idKorisnik,NOW() from korisnik"
          + " where korisnickoIme = '" +kime+"' ";
      
       
    dbStmnt.execute();
    dbCon.commit();


    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s unosom u tablicu");
    }
       
     
 
  }
   
        
      
       public void unosPrisutnosti(String jmbag,String idNastava,String prisutan)
  {

      
       try { 
      sql = " UPDATE dolazak SET prisutan = ? where jmbagStudent = ? and idNastava = ?";
  
     try {
      dbStmnt = dbCon.prepareStatement(sql);
      
       Integer id = Integer.valueOf(idNastava);
       
       dbStmnt.setString(1, prisutan); 
       dbStmnt.setString(2, jmbag);
       dbStmnt.setInt(3,id);
       
       
       
       

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
   
       
       public void unosDolaska(String idKolegij)
  {

      
       try { 
      sql = "INSERT INTO dolazak (idNastava,jmbagStudent, prisutan) "+
            " SELECT (SELECT MAX(idNastava) FROM nastava),jmbag, 'NE' "+
            " FROM   student inner join ocjena on student.jmbag = ocjena.jmbagStudent "+
            " where ocjena.idKolegij = "+idKolegij+" ";

  
     try {
      dbStmnt = dbCon.prepareStatement(sql);
      
        
            

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
   
   
   public void brisanjeNastave(String idNastava)
  {

      
       try { 
      sql = " DELETE from nastava where idNastava = ?";
      
        
     try {
      dbStmnt = dbCon.prepareStatement(sql);
      
       Integer id = Integer.parseInt(idNastava);
       dbStmnt.setInt(1, id); 
       

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }
     
     
    dbStmnt.execute();
    dbCon.commit();
            

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s brisanjem zapisa");
    }
 
  }
   
   
      
    
   
   
   public void izvediProcPostaviBrPrisut(String idNastava,String idKolegij)
  {

      
       try { 
      sql = " {CALL postaviBrPrisutnih(?,?)} ";
      
        
     try {
      dbStmnt = dbCon.prepareStatement(sql);
      
       Integer idN = Integer.parseInt(idNastava);
       Integer idK = Integer.parseInt(idKolegij);
       
       dbStmnt.setInt(1, idN);
       dbStmnt.setInt(2, idK);
       

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }
     
     
    dbStmnt.executeQuery();
    dbCon.commit();
            

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s izvršavanjem procedure");
    }
 
  }
   
    public void brisanjeDolazaka(String idNastava)
  {

      
       try { 
      sql = " DELETE from dolazak where idNastava = ?";
      
        
     try {
      dbStmnt = dbCon.prepareStatement(sql);
      
     
       Integer id = Integer.parseInt(idNastava);
       dbStmnt.setInt(1, id); 
    
       

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Problem s kreiranjem Statement objekta");
      this.konekcijaBaze();
     }
     
     
    dbStmnt.execute();
    dbCon.commit();
            

    } catch (SQLException ex) {
     ex.printStackTrace();
     System.out.println("Problem s brisanjem zapisa");
    }
 
  }
    
    
  public ArrayList <Student> dohvatiImenikStudente()
  {
      ArrayList <Student> studenti = new ArrayList();
      
      try { 
     sql = "SELECT ime,prezime,jmbag,email,mobitel,telefon "
             + "FROM student ORDER BY 2,1,3,4,5,6 asc";
     
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
         
         Student student = new Student(jmbag, ime, prezime, 
                                        email, mobitel, telefon);
       
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
  
   public ArrayList <Student> dohvatiStudenteDolaske(String idNastava,String idKolegij)
  {
      ArrayList <Student> studenti = new ArrayList();
      
      try { 
     sql = "SELECT student.ime,student.prezime,student.jmbag,student.vrsta,dolazak.prisutan FROM student" 
            + " inner join dolazak on student.jmbag = dolazak.jmbagStudent " 
            + " inner join nastava on nastava.idNastava = dolazak.idNastava " 
            + " where dolazak.idNastava = "+idNastava+" and nastava.idKolegij = "+idKolegij+" "
             +" ORDER BY 2,1,3,4,5 ";
     
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
         String jmbag = rs.getString("student.jmbag");
         String ime = rs.getString("student.ime");
         String prezime = rs.getString("student.prezime");
         String vrsta = rs.getString("student.vrsta");
         String prisutan = rs.getString("dolazak.prisutan");
         char vrstaChar = vrsta.charAt(0);
         
         
         boolean prisutan_;
         
         if(prisutan.equals("DA"))
         {
             prisutan_ = true;
         }
         else
         {
             prisutan_ = false;
         }
     
         
         Student student = new Student(jmbag, ime, prezime, vrstaChar,prisutan_);
       
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
   
   
   
   
   


}




