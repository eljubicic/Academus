/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme;

import KlaseTablica.Djelatnik;
import Kod.Main;
import KlaseTablica.Student;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Emanuel
 */
public class FormaAdresarStudenti extends javax.swing.JDialog {

    /**
     * Creates new form FormaImenikDjelatnici
     */
    public FormaAdresarStudenti() {
        initComponents();
        this.setTitle("Adresar studenata");
         this.setLocationRelativeTo(null);
        this.setModal(true);
        
        ArrayList <Student> studenti = Main.db.dohvatiAdresarStudente();
        DefaultTableModel model = (DefaultTableModel) this.tablica.getModel();
        
        Object [] row = new Object [7];
        
        for(int i=0;i<studenti.size();i++)
        {
            row[0]=studenti.get(i).getJmbag();
            row[1]=studenti.get(i).getPrezime();
            row[2]=studenti.get(i).getIme();
            row[3]=studenti.get(i).getPreb().getAdresa();
            row[4]=studenti.get(i).getPreb().getMjesto();
            row[5]=studenti.get(i).getBor().getAdresa();
            row[6]=studenti.get(i).getBor().getMjesto();
            
            model.addRow(row);
        }
    }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablica = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        tablica.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tablica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jmbag", "Prezime", "Ime", "Adresa preb.", "Mjesto preb.", "Adresa bor.", "Mjesto bor."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablica.setGridColor(new java.awt.Color(0, 0, 0));
        tablica.setRowHeight(22);
        jScrollPane2.setViewportView(tablica);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormaAdresarStudenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaAdresarStudenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaAdresarStudenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaAdresarStudenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
             
               
                
      
            }
        });
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable getTablica() {
        return tablica;
    }

    public void setTablica(JTable tablica) {
        this.tablica = tablica;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablica;
    // End of variables declaration//GEN-END:variables
}
