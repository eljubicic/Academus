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
public class Lokacija {

    public Lokacija(int lokacijaId,String lokacijaNaziv, String lokacijaAdresa, String mjestoNaziv) {
        this.lokacijaId = lokacijaId;
        this.lokacijaNaziv = lokacijaNaziv;
        this.lokacijaAdresa = lokacijaAdresa;
        this.mjestoNaziv = mjestoNaziv;
    }
    
      public Lokacija(String lokacijaNaziv, String lokacijaAdresa, String mjestoNaziv) {
        this.lokacijaNaziv = lokacijaNaziv;
        this.lokacijaAdresa = lokacijaAdresa;
        this.mjestoNaziv = mjestoNaziv;
    }
    
    
    String lokacijaNaziv;
    String lokacijaAdresa;
    String mjestoNaziv;
    int lokacijaId;

    public String getLokacijaNaziv() {
        return lokacijaNaziv;
    }

    public void setLokacijaNaziv(String lokacijaNaziv) {
        this.lokacijaNaziv = lokacijaNaziv;
    }

    public String getLokacijaAdresa() {
        return lokacijaAdresa;
    }

    public void setLokacijaAdresa(String lokacijaAdresa) {
        this.lokacijaAdresa = lokacijaAdresa;
    }

    public String getMjestoNaziv() {
        return mjestoNaziv;
    }

    public void setMjestoNaziv(String mjestoNaziv) {
        this.mjestoNaziv = mjestoNaziv;
    }

    public int getLokacijaId() {
        return lokacijaId;
    }

    public void setLokacijaId(int lokacijaId) {
        this.lokacijaId = lokacijaId;
    }
    
    
    
    
}
