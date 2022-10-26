package com.khoitien.learnsharepreferenceswithquynh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ShowResult extends AppCompatActivity {
    TextView tvwHoTen;
    TextView tvwMatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        tvwHoTen = findViewById(R.id.tvw_hoten);
        tvwMatKhau = findViewById(R.id.tvw_msv);

        SharedPreferences sharedPreferences = getSharedPreferences("Quynh", MODE_PRIVATE);
        String strHoTen = sharedPreferences.getString("key_name", "");
        tvwHoTen.setText(strHoTen);
    }
}