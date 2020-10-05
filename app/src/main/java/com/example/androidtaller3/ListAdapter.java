package com.example.androidtaller3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Auto> {

    private List<Auto> mlist;
    private Context mContext;
    private int resourceLayout;

    public ListAdapter(@NonNull Context context, int resource, List<Auto> objects) {
        super(context, resource, objects);
        this.mlist = objects;
        this.mContext = context;
        this.resourceLayout = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null)
            view = LayoutInflater.from(mContext).inflate(resourceLayout, null);

        Auto auto = mlist.get(position);

        TextView txtmarca = view.findViewById(R.id.textmarca);
        txtmarca.setText(auto.getMarca());

        TextView txtmodelo = view.findViewById(R.id.textmodelo);
        txtmodelo.setText(auto.getModelo());
        TextView txtplaca = view.findViewById(R.id.textplaca);
        txtplaca.setText(auto.getPlaca());

            return view;

    }
}

