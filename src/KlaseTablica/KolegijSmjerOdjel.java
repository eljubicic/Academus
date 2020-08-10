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
public class KolegijSmjerOdjel {
    
    Kolegij kolegij;
    Smjer smjer;
    Odjel odjel;
    
    public KolegijSmjerOdjel(Kolegij k,Smjer s,Odjel o)
    {
        this.kolegij = k;
        this.smjer = s;
        this.odjel = o;
    }

    public Kolegij getKolegij() {
        return kolegij;
    }

    public void setKolegij(Kolegij kolegij) {
        this.kolegij = kolegij;
    }

    public Smjer getSmjer() {
        return smjer;
    }

    public void setSmjer(Smjer smjer) {
        this.smjer = smjer;
    }

    public Odjel getOdjel() {
        return odjel;
    }

    public void setOdjel(Odjel odjel) {
        this.odjel = odjel;
    }
   

  
    
}

