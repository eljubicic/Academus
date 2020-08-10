/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlaseTablica;


public class Kolegij {
  
    private int id;
    private String naziv;
    private String uloga;
    
     public Kolegij(int id,String naziv,String uloga)
    {
        this.id = id;
        this.naziv=naziv;
        this.uloga = uloga;
    }
      public Kolegij(int id,String naziv)
    {
        this.id = id;
        this.naziv=naziv;
       
    }
     

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
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
    
}

