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
        chucNangAdapter.add(new ChucNang(R.drawable.ic_bank, "Chức năng 1", 0xFF0000FF));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_add, "Chức năng 2"));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_agriculture, "Chức năng 3"));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_alarm, "Chức năng 4"));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_airport, "Chức năng 5"));

    }
}