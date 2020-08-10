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
public class Korisnik {
    private String korisnickoIme;
    private String lozinka;
    private boolean admin;

    private Djelatnik djelatnik = new Djelatnik();
    
    
    public Korisnik()
    {
        //Default ctor
    }


    
    public Korisnik(String korisnickoIme,String lozinka,boolean admin,Djelatnik dj)
    {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.admin = admin;
        this.djelatnik = dj;
        
        
    }
    public Djelatnik getDjelatnik() {
        return djelatnik;
    }

    public void setDjelatnik(Djelatnik djelatnik) {
        this.djelatnik = djelatnik;
    }



    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public boolean isAdmin() {
        return admin;
    }
}
