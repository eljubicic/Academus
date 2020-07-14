/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.academus.tablice;

/**
 *
 * @author Emanuel
 */
public class Djelatnik {
    
    private String oib;
    private String ime;
    private String prezime;
    private String titula;
    private String email;
    private String mobitel;
    private String telefon;
    
    
    public Djelatnik ()
    {
        //Default ctr
    }
    
    public Djelatnik(String oib)
    {
       this.oib = oib;
    }
    
    public Djelatnik(String ime,String prezime,String titula,String email,String mobitel,String telefon)
    {
        this.ime = ime;
        this.prezime = prezime;
        this.titula = titula;
        this.email = email;
        this.mobitel = mobitel;
        this.telefon = telefon;
    }
    
    

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }
    

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobitel() {
        return mobitel;
    }

    public void setMobitel(String mobitel) {
        this.mobitel = mobitel;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    
 
    
    
}
