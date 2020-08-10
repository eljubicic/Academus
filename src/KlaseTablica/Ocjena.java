/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlaseTablica;

import java.util.Date;

/**
 *
 * @author Emanuel
 */
public class Ocjena {
   
int usmeni = 0;
int pismeni = 0;
int konacna = 0;
String polaganje = null;
String unos = null;

public Ocjena(int usmeni,int pismeni,int konacna,String polaganje,String unos)
{
    this.usmeni = usmeni;
    this.pismeni = pismeni;
    this.konacna = konacna;
    this.polaganje = polaganje;
    this.unos = unos;
    
}

    public int getUsmeni() {
        return usmeni;
    }

    public void setUsmeni(int usmeni) {
        this.usmeni = usmeni;
    }

    public int getPismeni() {
        return pismeni;
    }

    public void setPismeni(int pismeni) {
        this.pismeni = pismeni;
    }

    public int getKonacna() {
        return konacna;
    }

    public void setKonacna(int konacna) {
        this.konacna = konacna;
    }

    public String getPolaganje() {
        return polaganje;
    }

    public void setPolaganje(String polaganje) {
        this.polaganje = polaganje;
    }

    public String getUnos() {
        return unos;
    }

    public void setUnos(String unos) {
        this.unos = unos;
    }
    
}
