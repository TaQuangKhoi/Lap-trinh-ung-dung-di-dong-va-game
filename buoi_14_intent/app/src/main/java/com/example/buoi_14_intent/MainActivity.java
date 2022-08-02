package com.example.buoi_14_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    Button btnOpenFacebook;
    Button btnOpenSerializable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenFacebook = findViewById(R.id.btn_open_facebook);
        btnOpenSerializable = findViewById(R.id.btn_open_serializable);
        String[] mangTen = {"Khôi", "Thịnh", "Tâm", "Tiến"};
        HocSinh hs = new HocSinh("Khôi", "DH20LT");

        btnOpenFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openFacebook = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://facebook.com"));
                startActivity(openFacebook);
            }
        });

        btnOpenSerializable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openSerializable = new Intent(MainActivity.this,
                        show_data_serializable.class);

                openSerializable.putExtra("chuoi", "Tạ Quang Khôi");
                openSerializable.putExtra("so", 1234);
                openSerializable.putExtra("mang", mangTen);
                openSerializable.putExtra("doituong", hs);

                startActivity(openSerializable);
            }
        });
    }
}