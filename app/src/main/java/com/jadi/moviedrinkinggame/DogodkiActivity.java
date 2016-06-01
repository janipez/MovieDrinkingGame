package com.jadi.moviedrinkinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DogodkiActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogodki);

        BazaPomocnik bp = new BazaPomocnik(this);

        //Pridobi prenesene podatke
        Intent intent = getIntent();
        String filmZaDogodke = intent.getStringExtra(MainActivity.prenesiFilm);

        //Inicializacija TextViewa
        TextView tvIdFilm = (TextView) findViewById(R.id.textViewIdFilm);
        tvIdFilm.setText(filmZaDogodke);

        //Pridobivanje dogodkov
        String[] razbitiPreneseni = filmZaDogodke.split(":");
        int idZaDogodke = Integer.parseInt(razbitiPreneseni[0].toString());

        ArrayList<Dogodek> izbraniDogodki = bp.beriIzbraneDogodke(idZaDogodke);

        //Izpis dogodkov
        ListView listViewDogodki = (ListView) findViewById(R.id.listViewDogodki);
        DogodekAdapter dogodekAdapter = new DogodekAdapter(this, izbraniDogodki);
        listViewDogodki.setAdapter(dogodekAdapter);
    }
}
