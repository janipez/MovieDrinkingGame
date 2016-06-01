package com.jadi.moviedrinkinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lv = (ListView) findViewById(R.id.listViewTest);
        final TextView tv = (TextView) findViewById(R.id.textViewTest);

        final BazaPomocnik bp = new BazaPomocnik(this);

        /*bp.dodajFilm(new Film(1, "film", "Avengers", "Science Fiction", 8, "Assemble!", 140));
        bp.dodajFilm(new Film(2, "film", "Iron Man", "Science Fiction", 7, "Tony Stark was able to build this in a cave!", 130));
        bp.dodajFilm(new Film(3, "film", "Shutter Island", "Mystery", 9, "Who is mad?", 120));
        bp.dodajFilm(new Film(4, "serija", "Game of Thrones S02E05", "ZF", 9, "Hold the Door!", 55));
        bp.dodajFilm(new Film(5, "serija", "Gotham S02E10", "ZF", 7, "Batman.", 44));

        bp.dodajDogodek(new Dogodek(1, "Videl si Nick Furyja", "Spij malo vode za uvajanje", 5, 25, 1));
        bp.dodajDogodek(new Dogodek(2, "Videl si Lokija", "Na vrsti je 1 shot (vode, seveda)", 20, 27, 1));
        bp.dodajDogodek(new Dogodek(3, "Videl si Iron Mana", "Naredi 10 počepov", 10, 30, 1));
        bp.dodajDogodek(new Dogodek(4, "Hulk je podivjal?!?", "Spij 2 dcl vode za živce", 9, 35, 1));
        bp.dodajDogodek(new Dogodek(5, "Konec filma", "Eksaj vodo do konca!", 7, 100, 1));

        bp.dodajDogodek(new Dogodek(6, "Iron Man je ujet", "Spij malo vode, saj si v puščavi", 9, 20, 2));
        bp.dodajDogodek(new Dogodek(7, "Prvi oklep", "Na vrsti je 1 shot (vode, seveda)", 7, 22, 2));
        bp.dodajDogodek(new Dogodek(8, "Zmrznil si", "Dodaj led v kozarec vode", 15, 40, 2));
        bp.dodajDogodek(new Dogodek(9, "Tonyju Starku je to uspelo narediti v jami!", "EKSAJ!", 6, 67, 2));
        bp.dodajDogodek(new Dogodek(10, "Eksplozija", "Bomba vode", 8, 80, 2));*/

        //bp.izbrisiVseFilme();
        //bp.izbrisiVseDogodke();

        ArrayList<Film> vsiFilmi = bp.beriVseFilme();
        //ArrayList<Dogodek> izbraniDogodki = bp.beriIzbraneDogodke(2);

        FilmAdapter filmAdapter = new FilmAdapter(this, vsiFilmi);
        //DogodekAdapter dogodekAdapter = new DogodekAdapter(this, izbraniDogodki);

        lv.setAdapter(filmAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Film izbraniFilm = (Film) (lv.getItemAtPosition(position));
                tv.setText(String.valueOf(izbraniFilm.idFilm) + ": " + izbraniFilm.naslov);

                ArrayList<Dogodek> izbraniDogodki = bp.beriIzbraneDogodke(izbraniFilm.idFilm);
            }
        });
    }
}