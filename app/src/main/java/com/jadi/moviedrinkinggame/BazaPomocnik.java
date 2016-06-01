package com.jadi.moviedrinkinggame;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JaNi on 1. 06. 2016.
 */

public class BazaPomocnik extends SQLiteOpenHelper {

    //Ime PB
    static final String PB_IME = "FILMI_IN_DOGODKI.DB";

    //Verzija PB
    static final int PB_VERZIJA = 1;

    //Ustvarjanje tabel
    private static final String ustvariTabeloFilmi =
            "CREATE TABLE FILMI(" +
            "idFilm INTEGER PRIMARY KEY, " +
            "tip TEXT, " +
            "naslov TEXT, " +
            "zvrst TEXT, " +
            "ocena INTEGER, " +
            "citat TEXT, " +
            "casTrajanja INTEGER)";

    private static final String ustvariTabeloDogodki =
            "CREATE TABLE DOGODKI(" +
            "idDogodek INTEGER PRIMARY KEY, " +
            "naziv TEXT, " +
            "naloga TEXT, " +
            "vrednost INTEGER, " +
            "casProzitve INTEGER, " +
            "tkIdFilm INTEGER, " +
            "FOREIGN KEY(tkIdFilm) REFERENCES FILMI(idFilm)";

    public BazaPomocnik(Context context){
        super(context, PB_IME, null, PB_VERZIJA);
    }

    //Ustvarjanje baze
    @Override
    public void onCreate(SQLiteDatabase pb) {
        pb.execSQL(ustvariTabeloFilmi);
        pb.execSQL(ustvariTabeloDogodki);
    }

    //Nadgradnja baze
    @Override
    public void onUpgrade(SQLiteDatabase pb, int oldVersion, int newVersion) {
        pb.execSQL("DROP TABLE IF EXISTS FILMI");
        pb.execSQL("DROP TABLE IF EXISTS DOGODKI");
        onCreate(pb);
    }

    //Metoda za dodajanje filma
    public void dodajFilm(Film film) {
        SQLiteDatabase pb = this.getWritableDatabase();

        ContentValues vrednosti = new ContentValues();
        vrednosti.put("tip", film.getTip());
        vrednosti.put("naslov", film.getNaslov());
        vrednosti.put("zvrst", film.getZvrst());
        vrednosti.put("ocena", film.getOcena());
        vrednosti.put("citat", film.getCitat());
        vrednosti.put("casTrajanja", film.getCasTrajanja());

        pb.insert("FILMI", null, vrednosti);
        pb.close();
    }

    //Metoda za dodajanje dogodkov

}
