package com.jadi.moviedrinkinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BazaPomocnik bp = new BazaPomocnik(this);

        /*bp.dodajFilm(new Film(1, "film", "Avengers", "Science Fiction", 8, "Assemble!", 140));
        bp.dodajFilm(new Film(2, "film", "Iron Man", "Science Fiction", 7, "Tony Stark was able to build this in a cave!", 130));
        bp.dodajFilm(new Film(3, "film", "Shutter Island", "Mystery", 9, "Who is mad?", 120));
        bp.dodajFilm(new Film(4, "serija", "Game of Thrones S02E05", "ZF", 9, "Hold the Door!", 55));
        bp.dodajFilm(new Film(5, "serija", "Gotham S02E10", "ZF", 7, "Batman.", 44));*/

        ArrayList<Film> vsiFilmi = bp.beriVseFilme();

        FilmAdapter filmAdapter = new FilmAdapter(this, vsiFilmi);

        ListView lv = (ListView) findViewById(R.id.listViewTest);
        lv.setAdapter(filmAdapter);
    }
}