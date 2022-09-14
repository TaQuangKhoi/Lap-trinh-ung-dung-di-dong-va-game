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
                "Corona", 0xFF0000FF));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_add, "Cảm Cúm", Color.parseColor("#A68D11")));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_agriculture, "Đậu Mùa Khỉ", Color.parseColor("#00ff00")));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_alarm, "Thuỷ Đậu", Color.parseColor("#6C5E18")));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_airport, "Chức năng 5", Color.parseColor("#53DC93")));
        chucNangAdapter.add(new ChucNang(R.drawable.ic_bank, "Chức năng 6", Color.parseColor("#A68D11")));

    }
}