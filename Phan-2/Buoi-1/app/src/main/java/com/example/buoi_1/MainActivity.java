package com.example.buoi_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnChuyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChuyen = findViewById(R.id.btnChuyen);

        btnChuyen.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            startActivity(intent);
        });
    }
}