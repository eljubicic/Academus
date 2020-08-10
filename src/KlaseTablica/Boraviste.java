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
public class Boraviste {
    
    String adresa;
    String mjesto;
    
    public Boraviste(String adresa,String mjesto)
    {
        this.adresa=adresa;
        this.mjesto=mjesto;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMjesto() {
        return mjesto;
    }

    public void setMjesto(String mjesto) {
        this.mjesto = mjesto;
    }
    
    
}
