package com.example.cuslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BussAdapter extends ArrayAdapter<buss> {
    private Context context;
    private int resource;


    public BussAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = LayoutInflater.from(context).inflate(resource, null);
        ImageView imageView = customView.findViewById(R.id.xeden);
        TextView tvNameBus = customView.findViewById(R.id.txXeden);
        TextView tvRouteBus = customView.findViewById(R.id.txXedi);
        buss bus = getItem(position);
        imageView.setImageResource(getItem(position).getImage());
        tvNameBus.setText(getItem(position).getNameBus());
        tvRouteBus.setText(getItem(position).getRouteBus());
        return customView;


    }
}
