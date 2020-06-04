/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.academus.kod;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;






public final class BazaPodataka {
    

 private final String DRIVER = "com.mysql.jdbc.Driver";
 private final String URL = "jdbc:mysql://localhost:3306/academus";
 private final String USER = "root";
 private final String PASSWORD = "emanuel77";

 private Connection dbCon;
 private PreparedStatement dbStmnt;
 private ResultSet rs;
 private String sql;


 public int connectDatabase() {
  int status = 0;
  try {
  Class.forName(DRIVER);
  dbCon = DriverManager.getConnection(URL, USER, PASSWORD);
  dbCon.setAutoCommit(false);
  status = 1;
 
  } 
  catch (ClassNotFoundException ex){
   ex.printStackTrace(System.out);
   System.out.println(" *** Driver class not found! ***");
   status = -1;
  }
  catch (SQLException ex) {
   ex.printStackTrace(System.out);
   System.out.println(" *** Problem establishing connection to a database! ***");
   status = -1;
  }
  return status;
 }
 
 
  public int getUsersAndPasswords(String u,String p)
  {
      int status = 0;
      boolean admin=false;
      
      try {
          
      
     sql = "SELECT DISTINCT(korisnickoIme),lozinka,admin FROM korisnik WHERE korisnickoIme = '"+u+"' ";
     
     try {
      dbStmnt = dbCon.prepareStatement(sql);

     } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println(" *** Problem with creating a database statement object! ***");
      this.connectDatabase();
     }

     rs = dbStmnt.executeQuery(sql);
     if (rs.next()) {
     
         System.out.println("Korisničko ime postoji.");
         status = 1;
         
         String pass = rs.getString("lozinka");
         admin = rs.getString("admin").equals("DA");
         
         
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
     System.out.println("*** Problem with reading data from a category table! ***");
    }
    
    if(status == 1)
    {
        Main.korisnik.setKorisnickoIme(u);
        Main.korisnik.setLozinka(p);
        Main.korisnik.setAdmin(admin);
        
        if(admin == true)
        {
            System.out.print("ADMINISTRATOR");    
        }
        
    }
        
    return status;
  }
}


