package com.jadi.moviedrinkinggame;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Timer;

public class DogodkiActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogodki);

        final Chronometer timer = (Chronometer) findViewById(R.id.chronometerTimer);
        final TextView tvTimer = (TextView) findViewById(R.id.textViewTimer);
        final Button btnStart = (Button) findViewById(R.id.buttonStart);

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

        final ArrayList<Dogodek> izbraniDogodki = bp.beriIzbraneDogodke(idZaDogodke);

        //Pridobivanje podatkov o trenutnem filmu
        Film film = bp.beriFilm(idZaDogodke);

        //Izpis dogodkov
        ListView listViewDogodki = (ListView) findViewById(R.id.listViewDogodki);
        DogodekAdapter dogodekAdapter = new DogodekAdapter(this, izbraniDogodki);
        listViewDogodki.setAdapter(dogodekAdapter);

        btnStart.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                timer.start();

                timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        String cas = timer.getText().toString();
                        String[] casRazbit = cas.split(":");
                        int casSekunde = Integer.parseInt(casRazbit[0]) * 60 + Integer.parseInt(casRazbit[1]);
                        tvTimer.setText(String.valueOf(casSekunde));

                        for (Integer i = 0; i < izbraniDogodki.size(); i++) {
                            if (izbraniDogodki.get(i).getCasProzitve() == casSekunde) {
                                Toast.makeText(DogodkiActivity.this, izbraniDogodki.get(i).getNaziv() + " - " + izbraniDogodki.get(i).getNaloga(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
            }
        });
    }
}
