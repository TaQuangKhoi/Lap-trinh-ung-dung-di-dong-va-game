package com.example.kt_thuchanh_txcc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.GridView;

public class grid_view extends AppCompatActivity {
    ChucNangAdapter chucNangAdapter;
    GridView gvChucNang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gvChucNang = findViewById(R.id.gv_cac_chucnang);
        chucNangAdapter = new ChucNangAdapter(this, R.layout.chucnang);

        gvChucNang.setAdapter(chucNangAdapter);


        Data();
    }

    private void Data() {
        chucNangAdapter.add(new ChucNang(R.drawable.coronavirus_sars_cov_2,
                "Chức năng 1", 0xFF0000FF));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_add, "Chức năng 2", 0x2F542D));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_agriculture, "Chức năng 3", Color.parseColor("#00ff00")));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_alarm, "Chức năng 4", Color.parseColor("#6C5E18")));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_airport, "Chức năng 5", Color.parseColor("#53DC93")));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_airport, "Chức năng 6", Color.parseColor("#A68D11")));

    }
}