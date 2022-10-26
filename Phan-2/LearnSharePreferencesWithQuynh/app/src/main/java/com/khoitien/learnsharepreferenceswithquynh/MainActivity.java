package com.khoitien.learnsharepreferenceswithquynh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen;
    EditText edtMSV;
    CheckBox cbxSaveInfo;
    CheckBox btnDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControls();
    }

    private void AddControls() {
        edtHoTen = findViewById(R.id.edt_hovaten);
        edtMSV = findViewById(R.id.edt_msv);
    }
}