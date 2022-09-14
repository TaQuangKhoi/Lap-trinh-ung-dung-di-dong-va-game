package com.example.relearn_buoi_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btnc1);
        btn2 = findViewById(R.id.btnc2);
        btn3 = findViewById(R.id.btnc3);
        Intent cach_1 = new Intent(this, Cach_1.class);
        Intent cach_2 = new Intent(this, Cach_2.class);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Cách 1", Toast.LENGTH_SHORT).show();
                startActivity(cach_1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Cách 2", Toast.LENGTH_SHORT).show();
                startActivity(cach_2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "Chính là cách đang sử dụng để hiện Toast này",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}