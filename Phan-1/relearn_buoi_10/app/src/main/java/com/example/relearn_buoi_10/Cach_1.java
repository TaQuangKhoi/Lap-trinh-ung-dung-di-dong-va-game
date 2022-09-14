package com.example.relearn_buoi_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cach_1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cach1);

    }

    public void Cach1(View view){
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
    }
}