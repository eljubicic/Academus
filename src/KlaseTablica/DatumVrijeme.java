/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlaseTablica;

import java.util.Date;
import java.sql.Time;


/**
 *
 * @author Emanuel
 */
public class DatumVrijeme {
    
    private Date datum1;
    private Date datum2;
    private Time vrijeme1;
    private Time vrijeme2;
    
    public DatumVrijeme(Date datum1,Time vrijeme1,Time vrijeme2)
    {
        this.datum1 = datum1;
        this.vrijeme1=vrijeme1;
        this.vrijeme2=vrijeme2;
    }

    public Date getDatum1() {
        return datum1;
    }

    public void setDatum1(Date datum1) {
        this.datum1 = datum1;
    }

    public Date getDatum2() {
        return datum2;
    }

    public void setDatum2(Date datum2) {
        this.datum2 = datum2;
    }

    public Time getVrijeme1() {
        return vrijeme1;
    }

    public void setVrijeme1(Time vrijeme1) {
        this.vrijeme1 = vrijeme1;
    }

    public Time getVrijeme2() {
        return vrijeme2;
    }

    public void setVrijeme2(Time vrijeme2) {
        this.vrijeme2 = vrijeme2;
    }
    
    
    
    
}
