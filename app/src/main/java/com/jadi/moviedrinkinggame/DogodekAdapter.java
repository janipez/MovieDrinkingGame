package com.jadi.moviedrinkinggame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by JaNi on 1. 06. 2016.
 */

public class DogodekAdapter extends ArrayAdapter<Dogodek>
{
    public DogodekAdapter(Context context, ArrayList<Dogodek> dogodki)
    {
        super(context, 0, dogodki);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        Dogodek dogodek = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dogodek_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.dogodekNaziv);
        TextView tvHome = (TextView) convertView.findViewById(R.id.dogodekNaloga);
        // Populate the data into the template view using the data object
        tvName.setText(dogodek.naziv);
        tvHome.setText(String.valueOf(dogodek.naloga));
        // Return the completed view to render on screen
        return convertView;
    }
}
