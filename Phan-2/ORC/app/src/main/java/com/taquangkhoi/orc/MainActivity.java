package com.taquangkhoi.orc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnTakePhoto, btnCopy, btnPickPhoto;
    TextView tvwResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControls();
    }

    private void AddControls() {
        btnTakePhoto = findViewById(R.id.btnTakePhoto);
        btnCopy = findViewById(R.id.btnCopy);
        btnPickPhoto = findViewById(R.id.btnPickPhoto);
        tvwResult = findViewById(R.id.tvwResult);

    }
}