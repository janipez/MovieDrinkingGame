package com.jadi.moviedrinkinggame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JaNi on 1. 06. 2016.
 */

public class BazaPomocnik extends SQLiteOpenHelper
{

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
            "FOREIGN KEY(tkIdFilm) REFERENCES FILMI(idFilm))";

    public BazaPomocnik(Context context)
    {
        super(context, PB_IME, null, PB_VERZIJA);
    }

    //Ustvarjanje baze
    @Override
    public void onCreate(SQLiteDatabase pb)
    {
        pb.execSQL(ustvariTabeloFilmi);
        pb.execSQL(ustvariTabeloDogodki);
    }

    //Nadgradnja baze
    @Override
    public void onUpgrade(SQLiteDatabase pb, int oldVersion, int newVersion)
    {
        pb.execSQL("DROP TABLE IF EXISTS FILMI");
        pb.execSQL("DROP TABLE IF EXISTS DOGODKI");
        onCreate(pb);
    }

    //Dodajanje filma v bazo
    public void dodajFilm(Film film)
    {
        SQLiteDatabase pb = this.getWritableDatabase();

        ContentValues vrednosti = new ContentValues();
        vrednosti.put("idFilm", film.getIdFilm());
        vrednosti.put("tip", film.getTip());
        vrednosti.put("naslov", film.getNaslov());
        vrednosti.put("zvrst", film.getZvrst());
        vrednosti.put("ocena", film.getOcena());
        vrednosti.put("citat", film.getCitat());
        vrednosti.put("casTrajanja", film.getCasTrajanja());

        pb.insert("FILMI", null, vrednosti);
        pb.close();
    }

    //Branje 1 filma iz baze
    public Film beriFilm(int id)
    {
        SQLiteDatabase pb = this.getWritableDatabase();
        String selectStavek = "SELECT * FROM FILMI WHERE idFilm = " + String.valueOf(id);
        Cursor cursor = pb.rawQuery(selectStavek, null);

        Film film = new Film();

        if (cursor.moveToFirst())
        {
            do
            {
                film.setIdFilm(Integer.parseInt(cursor.getString(0)));
                film.setTip(cursor.getString(1));
                film.setNaslov(cursor.getString(2));
                film.setZvrst(cursor.getString(3));
                film.setOcena(Integer.parseInt(cursor.getString(4)));
                film.setCitat(cursor.getString(5));
                film.setCasTrajanja(Integer.parseInt(cursor.getString(6)));
            }
            while (cursor.moveToNext());
        }

        pb.close();
        cursor.close();

        return film;
    }

    //Branje vseh filmov iz baze
    public ArrayList<Film> beriVseFilme()
    {
        ArrayList<Film> seznamFilmov = new ArrayList<Film>();

        SQLiteDatabase pb = this.getWritableDatabase();
        String selectStavek = "SELECT * FROM FILMI";
        Cursor cursor = pb.rawQuery(selectStavek, null);

        if (cursor.moveToFirst())
        {
            do
            {
                Film film = new Film();

                film.setIdFilm(Integer.parseInt(cursor.getString(0)));
                film.setTip(cursor.getString(1));
                film.setNaslov(cursor.getString(2));
                film.setZvrst(cursor.getString(3));
                film.setOcena(Integer.parseInt(cursor.getString(4)));
                film.setCitat(cursor.getString(5));
                film.setCasTrajanja(Integer.parseInt(cursor.getString(6)));

                seznamFilmov.add(film);
            }
            while (cursor.moveToNext());
        }

        return seznamFilmov;
    }

    //Dodajanje dogodkov

}
