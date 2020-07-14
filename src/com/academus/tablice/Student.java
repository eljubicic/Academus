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
public class Student {
    
    private String jmbag;
    private String ime;
    private String prezime;
    private String email;
    private String mobitel;
    private String telefon;
    private char vrsta;
    private Ocjena ocjena;
    
    public Student()
    {
       //Default ctor.
    }
  
     public Student(String jmbag,String ime,String prezime,String email,String mobitel,String telefon)
    {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbag = jmbag;
        this.email = email;
        this.mobitel = mobitel;
        this.telefon = telefon;
    }
     
     public Student(String jmbag,String ime,String prezime,String email,String mobitel,char vrsta)
    {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbag = jmbag;
        this.email = email;
        this.mobitel = mobitel;
        this.vrsta = vrsta;
    }
     
     public Student(String jmbag,String ime,String prezime,char vrsta,Ocjena ocjena)
    {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbag = jmbag;
        this.vrsta = vrsta;
        this.ocjena = ocjena;
    }

    public Ocjena getOcjena() {
        return ocjena;
    }

    public void setOcjena(Ocjena ocjena) {
        this.ocjena = ocjena;
    }

        
    
    public char getVrsta() {
        return vrsta;
    }

    public void setVrsta(char vrsta) {
        this.vrsta = vrsta;
    }
    

  

    public String getJmbag() {
        return jmbag;
    }

    public void setJmbag(String jmbag) {
        this.jmbag = jmbag;
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
