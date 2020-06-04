/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.academus.kod;

import com.academus.forme.FormaPrijava;


/**
 *
 * @author Emanuel
 */

public class Main {

    public static Korisnik korisnik = new Korisnik();
    public static BazaPodataka db = new BazaPodataka();
    
  
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
            
            // Uspostava konekcije s bazom podataka
           int dbStatus =  Main.db.connectDatabase(); 
         
            
            //Započni formu FormaPrijava
            final FormaPrijava formaPrijava =  new FormaPrijava();
            formaPrijava.setVisible(true);
            formaPrijava.setLocationRelativeTo(null);  
            if(dbStatus == 1)
            {
               formaPrijava.getjLabel2().setText("Baza podataka uspješno povezana.");
           }
            
       });
        
        
    }
     
     
      
}
