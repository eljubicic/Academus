/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.academus.tablice;

import java.util.Date;
import java.sql.Time;

/**
 *
 * @author Emanuel
 */
public class Nastava {
    
    private String opis;
    private String prostorija;
    private String lokacija;
    private String djelatnik;
    private int brPrisutnih;
    private DatumVrijeme datumVrijeme;
   
   public Nastava(String opis,DatumVrijeme datumVrijeme,String prostorija,String lokacija,String djelatnik,int brPrisutnih)
    {
        this.opis = opis;
        this.datumVrijeme=datumVrijeme;
        this.prostorija=prostorija;
        this.lokacija=lokacija;
        this.djelatnik=djelatnik;
        this.brPrisutnih=brPrisutnih;
        
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getProstorija() {
        return prostorija;
    }

    public void setProstorija(String prostorija) {
        this.prostorija = prostorija;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public String getDjelatnik() {
        return djelatnik;
    }

    public void setDjelatnik(String djelatnik) {
        this.djelatnik = djelatnik;
    }

    public int getBrPrisutnih() {
        return brPrisutnih;
    }

    public void setBrPrisutnih(int brPrisutnih) {
        this.brPrisutnih = brPrisutnih;
    }

    public DatumVrijeme getDatumVrijeme() {
        return datumVrijeme;
    }

    public void setDatumVrijeme(DatumVrijeme datumVrijeme) {
        this.datumVrijeme = datumVrijeme;
    }
   

    
    
   
         
        
         
                
}
