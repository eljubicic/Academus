/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme;

import Kod.Main;
import LimitiranjeTeksta.JTextFieldLimit;
import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Emanuel
 */
public class FormaUnosNastava extends javax.swing.JDialog {

    /**
     * Creates new form FormaUnosOcjene
     */
    

    
    public FormaUnosNastava() {
        
        this.setTitle("Unos nastave");
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
    }



    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox<String> jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }


    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
    }


    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

 

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }



    public JLabel getjLabelKolegij() {
        return jLabelKolegij;
    }

    public void setjLabelKolegij(JLabel jLabelKolegij) {
        this.jLabelKolegij = jLabelKolegij;
    }


    public JLabel getjLabelTipNastave() {
        return jLabelTipNastave;
    }

    public void setjLabelTipNastave(JLabel jLabelTipNastave) {
        this.jLabelTipNastave = jLabelTipNastave;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JSpinner getjSpinner1() {
        return spinerMinDo;
    }

    public void setjSpinner1(JSpinner jSpinner1) {
        this.spinerMinDo = jSpinner1;
    }

    public JSpinner getjSpinner2() {
        return spinerSatiOd;
    }

    public void setjSpinner2(JSpinner jSpinner2) {
        this.spinerSatiOd = jSpinner2;
    }

    public JSpinner getjSpinner3() {
        return spinerSatiDo;
    }

    public void setjSpinner3(JSpinner jSpinner3) {
        this.spinerSatiDo = jSpinner3;
    }

   

    public JFormattedTextField getjFormattedTextField1() {
        return jFormattedTextField1;
    }

    public void setjFormattedTextField1(JFormattedTextField jFormattedTextField1) {
        this.jFormattedTextField1 = jFormattedTextField1;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JSpinner getjSpinner5() {
        return spinerMinOd;
    }

    public void setjSpinner5(JSpinner jSpinner5) {
        this.spinerMinOd = jSpinner5;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }


  
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabelKolegij = new javax.swing.JLabel();
        jLabelTipNastave = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        spinerMinDo = new javax.swing.JSpinner();
        spinerSatiOd = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        spinerSatiDo = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        spinerMinOd = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText(":");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Datum održavanja");

        jDateChooser1.setDateFormatString("dd.MM.yyyy");
        jDateChooser1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jDateChooser1.setMaxSelectableDate(new java.util.Date(32503680098000L));
        jDateChooser1.setMinSelectableDate(new java.util.Date(946684898000L));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(141, 0, 51), 3));
        jPanel2.setForeground(new java.awt.Color(141, 0, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(670, 179));

        jLabelKolegij.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelKolegij.setForeground(new java.awt.Color(141, 0, 51));
        jLabelKolegij.setText("Kolegij");

        jLabelTipNastave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTipNastave.setForeground(new java.awt.Color(141, 0, 51));
        jLabelTipNastave.setText("TipNastave");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTipNastave, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKolegij, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelKolegij, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTipNastave, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Opis");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(141, 0, 51));
        jButton1.setText("UNOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        spinerMinDo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spinerMinDo.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 5));

        spinerSatiOd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spinerSatiOd.setModel(new javax.swing.SpinnerNumberModel(7, 7, 23, 1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Vrijeme od");

        spinerSatiDo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spinerSatiDo.setModel(new javax.swing.SpinnerNumberModel(7, 7, 23, 1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText(":");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setPreferredSize(new java.awt.Dimension(32, 28));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Vrijeme do");

        spinerMinOd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spinerMinOd.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 5));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Lokacija");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(31, 31));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(spinerSatiOd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(spinerMinOd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 441, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spinerSatiDo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(spinerMinDo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinerSatiOd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinerMinOd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spinerMinDo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinerSatiDo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        //UNOS
        
        
        //DOHVATI UNESENE VRIJEDNOSTI
        
        
       int satiOd = (int) spinerSatiOd.getValue();
       int satiDo = (int) spinerSatiDo.getValue();
       
       int minOd = (int) spinerMinOd.getValue();
       int minDo = (int) spinerMinDo.getValue();
       
       long vrijemeOd = prebaciMilisekunde(satiOd-1, minOd);
       long vrijemeDo = prebaciMilisekunde(satiDo-1, minDo);
               
       Time vOd = new Time(vrijemeOd);
       Time vDo = new Time(vrijemeDo);
               
       
       Date datumOdrz = jDateChooser1.getDate(); 
       
       String opis = jTextField1.getText();
       
       
       String comboVrijednostLokacija = jComboBox1.getSelectedItem().toString();
       
       int crtica = comboVrijednostLokacija.indexOf('-');
       String prostorija=comboVrijednostLokacija.substring(0,crtica).trim();
       String lokacija = comboVrijednostLokacija.substring(crtica,comboVrijednostLokacija.length());
       String adresaMjesto = lokacija.replace('-',' ').trim();
       
       int zarez = adresaMjesto.indexOf(',');
       String adresa = adresaMjesto.substring(0,zarez).trim();
       String mjesto = adresaMjesto.substring(zarez+1).trim();
       
       int idLokacija = 0;
       
       for(int i=0; i<Main.formaPrijava.glavnaforma.nastava.lokacije.size();i++)
        {
               
          
            String arrayProstorija = Main.formaPrijava.glavnaforma.nastava.lokacije.get(i).getLokacijaNaziv().trim();
            String arrayAdresa = Main.formaPrijava.glavnaforma.nastava.lokacije.get(i).getLokacijaAdresa().trim();
            String arrayMjesto = Main.formaPrijava.glavnaforma.nastava.lokacije.get(i).getMjestoNaziv().trim();
            
            if(arrayProstorija.equals(prostorija) && arrayAdresa.equals(adresa) && arrayMjesto.equals(mjesto))
            {
                idLokacija = Main.formaPrijava.glavnaforma.nastava.lokacije.get(i).getLokacijaId();
                break;
            }
            
        }
       
       String idKolegij = Main.formaPrijava.glavnaforma.odabraniKolegijID;
       String oibDjelatnik = Main.getKorisnik().getDjelatnik().getOib();
       
       int idTipNastave= 0;
       
       String odabraniTipNastaveObavezno = jLabelTipNastave.getText();
       crtica = odabraniTipNastaveObavezno.indexOf("-");
       String odabraniTipNastave = odabraniTipNastaveObavezno.substring(0,crtica).trim();
        
        String sufiks = odabraniTipNastaveObavezno.substring(crtica+1).trim();
      
        boolean obavezno = !sufiks.equals("neobavez.");
        
        for(int i=0; i<Main.formaPrijava.glavnaforma.nastava.tipoviNastave.size();i++)
        {
           String arrayTipNastaveNaziv = Main.formaPrijava.glavnaforma.nastava.tipoviNastave.get(i).getNaziv();
           boolean arrayObavezno = Main.formaPrijava.glavnaforma.nastava.tipoviNastave.get(i).isObavezno();
            if( arrayTipNastaveNaziv.equals(odabraniTipNastave) && arrayObavezno == obavezno)     
            {
                idTipNastave = Main.formaPrijava.glavnaforma.nastava.tipoviNastave.get(i).getId();
                break;
            }
        }
       

       
       //VALIDACIJA UNESENIH VRIJEDNOSTI
       
       boolean error = true;
       String errorString = " ";
       
       while(error == true)
       {
            
            if(datumOdrz == null)
            {
                errorString = "Nije unesen datum!";
                error = true;
                
            try
            {
            String strDate= null;
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");  
            strDate = dateFormat.format(datumOdrz);
            }
            catch(Exception e)
            {      
                    System.out.println("Datum nije prošao validaciju!");
                    errorString = "Unesena je kriva vrijednost datuma!";
                    error = true;
                   
            }
            break;
            }
                     
            
            if(jTextField1.getText() == null || jTextField1.getText().isBlank())
            {
                 errorString = "Nije unesen opis. Opis nastave je obavezan za unos!";
                 error = true;
                 break;
            }
            
            if(jTextField1.getText().length() > 40)
            {
                 errorString = "Uneseno je previše znakova u opis. Dozvoljeno je do 40 znakova!";
                 error = true;
                 break;
            } 
            
           if(satiDo < satiOd)
           {
               errorString = "Unesen krivi interval sati!";
               error = true;
               break;
           }
           
           if(jComboBox1.getItemCount() == 0)
           {
               errorString = "Nema unesenih lokacija u tablicu baze podataka!";
               error = true;
               break;
           }
           
           error = false;
           
       }
       
       if(error == true)
       {
            JOptionPane.showMessageDialog(this,errorString,"Greška pri unosu", JOptionPane.ERROR_MESSAGE);
       }
       else 
       {
           opis = opis.substring(0,1).toUpperCase() + opis.substring(1);
           
               System.out.println("=============UNOS=============");
               System.out.println("Datum: "+datumOdrz);
               System.out.println("Opis: "+opis);
               System.out.println("ID lokacija: "+idLokacija);
               System.out.println("ID kolegij: "+idKolegij);
               System.out.println("ID tip nastave : "+idTipNastave);
               System.out.println("Vrijeme od: "+satiOd+" : "+minOd);
               System.out.println("Vrijeme do: "+satiDo+" : "+minDo);
               System.out.println("Djelatnik: "+oibDjelatnik);
               System.out.println("==============================");
               
            Main.db.unosNastave(datumOdrz, vOd, vDo, opis,idTipNastave,idLokacija,oibDjelatnik,idKolegij);
            
            
            
            this.dispose();
            Main.formaPrijava.glavnaforma.nastava.getjButton4().setEnabled(true);
                    
  
       }
       
       
       

       
           
    }//GEN-LAST:event_jButton1ActionPerformed

    
      long prebaciMilisekunde(Integer h,Integer min)
            {
               long hours = TimeUnit.HOURS.toMillis(h);
               long minutes = TimeUnit.MINUTES.toMillis(min);
               return hours+minutes;
                       
            }
      
      
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormaUnosNastava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaUnosNastava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaUnosNastava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaUnosNastava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormaUnosNastava().setVisible(true);
                
            }
        });
        
        
    }

  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelKolegij;
    private javax.swing.JLabel jLabelTipNastave;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner spinerMinDo;
    private javax.swing.JSpinner spinerMinOd;
    private javax.swing.JSpinner spinerSatiDo;
    private javax.swing.JSpinner spinerSatiOd;
    // End of variables declaration//GEN-END:variables
}
