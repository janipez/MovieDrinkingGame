package com.jadi.moviedrinkinggame;

/**
 * Created by JaNi on 1. 06. 2016.
 */

public class Film {
    int idFilm;
    String tip;
    String naslov;
    String zvrst;
    int ocena;
    String citat;
    int casTrajanja;

    //Konstruktorji
    public Film() {
    }

    public Film(int idFilm, String tip, String naslov, String zvrst, int ocena, String citat, int casTrajanja) {
        this.idFilm = idFilm;
        this.tip = tip;
        this.naslov = naslov;
        this.zvrst = zvrst;
        this.ocena = ocena;
        this.citat = citat;
        this.casTrajanja = casTrajanja;
    }

    //GET metode
    public int getIdFilm() {
        return idFilm;
    }

    public String getTip() {
        return tip;
    }

    public String getNaslov() {
        return naslov;
    }

    public String getZvrst() {
        return zvrst;
    }

    public int getOcena() {
        return ocena;
    }

    public String getCitat() {
        return citat;
    }

    public int getCasTrajanja() {
        return casTrajanja;
    }

    //SET metode
    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public void setZvrst(String zvrst) {
        this.zvrst = zvrst;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public void setCitat(String citat) {
        this.citat = citat;
    }

    public void setCasTrajanja(int casTrajanja) {
        this.casTrajanja = casTrajanja;
    }

}
