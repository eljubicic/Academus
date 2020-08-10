/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kod;

import KlaseTablica.Korisnik;
import Forme.FormaPrijava;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JFrame;


/**
 *
 * @author Emanuel
 */

public class Main {

    private static Korisnik korisnik = new Korisnik();
    
    public static BazaPodataka db = new BazaPodataka();
    public static FormaPrijava formaPrijava;
    
    
    
  
     public static void main(String args[]) {
       
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaPrijava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    

        
        java.awt.EventQueue.invokeLater(() -> {
            
           
            pokretanjePrijave();
                
       });    
        
    } 
     
     public static void pokretanjePrijave()
     {
          // Uspostava konekcije s bazom podataka
           int dbStatus =  Main.db.konekcijaBaze(); 
         
            
            //Započni formu FormaPrijava
            formaPrijava =  new FormaPrijava();
            formaPrijava.setVisible(true);
            formaPrijava.setLocationRelativeTo(null);  
            if(dbStatus == 1){
               formaPrijava.getjLabel2().setText("Baza podataka uspješno povezana.");
            }
            else{
               formaPrijava.getjLabel2().setText("BAZA PODATAKA NIJE POVEZANA!");
            }
     }
     
     
     public static void zatvaranjeDijalog(JDialog frame){ 
         
         if (JOptionPane.showConfirmDialog(frame, 
            "Jeste li sigurni da želite napustiti Academus?", "Izlaz", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            Main.db.zatvaranjeKonekcije();
            System.exit(0);
            }
         else{
             // Ne učini ništa
         }     
         
         
    }
        public static void zatvaranjeDijalog(JFrame frame){ 
         
         if (JOptionPane.showConfirmDialog(frame, 
            "Jeste li sigurni da želite napustiti Academus?", "Izlaz", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            Main.db.zatvaranjeKonekcije();
            System.exit(0);
            }
         else{
             // Ne učini ništa
         }     
         
         
    }
     

    public static Korisnik getKorisnik() {
        return korisnik;
    }

    public static void setKorisnik(Korisnik korisnik) {
        Main.korisnik = korisnik;
    }

    public static BazaPodataka getDb() {
        return db;
    }

    public static void setDb(BazaPodataka db) {
        Main.db = db;
    }
     
     
     
     
      
}
