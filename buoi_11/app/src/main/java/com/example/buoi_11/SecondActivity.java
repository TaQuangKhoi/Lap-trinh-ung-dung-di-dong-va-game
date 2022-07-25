package com.example.buoi_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

public class SecondActivity extends AppCompatActivity {
    GridView gvMain;
    Button btnGo;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        gvMain = findViewById(R.id.gv_main);
        btnGo = findViewById(R.id.btn_go);

        String[] data = getResources().getStringArray(R.array.list_os);

        ArrayAdapter adapter_data_os = new ArrayAdapter(SecondActivity.this, android.R.layout.simple_list_item_1, data);

        gvMain.setAdapter(adapter_data_os);

        // Nhấn nút `Go` để dến MainActivity
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}