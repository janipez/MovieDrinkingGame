package com.jadi.moviedrinkinggame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JaNi on 1. 06. 2016.
 */

public class FilmAdapter extends ArrayAdapter<Film>
{
    public FilmAdapter(Context context, ArrayList<Film> filmi)
    {
        super(context, 0, filmi);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        Film film = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.film_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.filmNaslov);
        TextView tvHome = (TextView) convertView.findViewById(R.id.filmOcena);
        // Populate the data into the template view using the data object
        tvName.setText(film.naslov);
        tvHome.setText(String.valueOf(film.idFilm));
        // Return the completed view to render on screen
        return convertView;
    }
}
