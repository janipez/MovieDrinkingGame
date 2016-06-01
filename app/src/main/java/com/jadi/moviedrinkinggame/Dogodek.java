package com.jadi.moviedrinkinggame;

/**
 * Created by JaNi on 1. 06. 2016.
 */

public class Dogodek {
    int idDogodek;
    String naziv;
    String naloga;
    int vrednost;
    int casProzitve;
    int tkIdFilm;

    //Konstruktorji
    public Dogodek() {
    }

    public Dogodek(int idDogodek, String naziv, String naloga, int vrednost, int casProzitve, int tkIdFilm) {
        this.idDogodek = idDogodek;
        this.naziv = naziv;
        this.naloga = naloga;
        this.vrednost = vrednost;
        this.casProzitve = casProzitve;
        this.tkIdFilm = tkIdFilm;
    }

    //GET metode
    public int getIdDogodek() {
        return idDogodek;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getNaloga() {
        return naloga;
    }

    public int getVrednost() {
        return vrednost;
    }

    public int getCasProzitve() {
        return casProzitve;
    }

    public int getTkIdFilm() {
        return tkIdFilm;
    }

    //SET metode
    public void setIdDogodek(int idDogodek) {
        this.idDogodek = idDogodek;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setNaloga(String naloga) {
        this.naloga = naloga;
    }

    public void setVrednost(int vrednost) {
        this.vrednost = vrednost;
    }

    public void setCasProzitve(int casProzitve) {
        this.casProzitve = casProzitve;
    }

    public void setTkIdFilm(int tkIdFilm) {
        this.tkIdFilm = tkIdFilm;
    }
}
