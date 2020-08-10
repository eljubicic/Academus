/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlaseTablica;

import java.util.Date;

/**
 *
 * @author Emanuel
 */
public class Dolazak {
   
    
    private String prisutan;
    private String opis;
    private Date datumOdrz;
    private String tipNastava;
    private String obavezno;

    public Dolazak(String prisutan, String opis, Date datumOdrz, String tipNastava, String obavezno) {
        this.prisutan = prisutan;
        this.opis = opis;
        this.datumOdrz = datumOdrz;
        this.tipNastava = tipNastava;
        this.obavezno = obavezno;
    }
    
    

    public String getPrisutan() {
        return prisutan;
    }

    public void setPrisutan(String prisutan) {
        this.prisutan = prisutan;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatumOdrz() {
        return datumOdrz;
    }

    public void setDatumOdrz(Date datumOdrz) {
        this.datumOdrz = datumOdrz;
    }

    public String getTipNastava() {
        return tipNastava;
    }

    public void setTipNastava(String tipNastava) {
        this.tipNastava = tipNastava;
    }

    public String getObavezno() {
        return obavezno;
    }

    public void setObavezno(String obavezno) {
        this.obavezno = obavezno;
    }
    

 
        
    

 
    
}
