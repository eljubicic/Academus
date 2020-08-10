/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlaseTablica;

/**
 *
 * @author Emanuel
 */
public class TipNastava {
    private int id;
    private String naziv;
    private boolean obavezno;
    
    public TipNastava(int id,String naziv,boolean obavezno)
    {
        this.id = id;
        this.naziv = naziv;
        this.obavezno = obavezno;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isObavezno() {
        return obavezno;
    }

    public void setObavezno(boolean obavezno) {
        this.obavezno = obavezno;
    }
    
}
