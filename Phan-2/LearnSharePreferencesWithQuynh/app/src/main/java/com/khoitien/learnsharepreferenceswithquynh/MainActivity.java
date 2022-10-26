package com.khoitien.learnsharepreferenceswithquynh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen;
    EditText edtMSV;
    CheckBox cbxSaveInfo;
    Button btnDangNhap;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddSharedPreferences();

        AddControls();
        AddEvents();


        ReloadSavedInfo();
    }

    private void AddControls() {
        edtHoTen = findViewById(R.id.edt_hovaten);
        edtMSV = findViewById(R.id.edt_password);
        cbxSaveInfo = findViewById(R.id.cbx_save_info);
        btnDangNhap = findViewById(R.id.btn_dang_nhap);
    }

    private void AddEvents() {
        btnDangNhap.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ShowResult.class);
            startActivity(intent);
        });

        cbxSaveInfo.setOnCheckedChangeListener((compoundButton, b) -> {
            if (cbxSaveInfo.isChecked()){
                SaveInfo();
                editor.putBoolean("key_bool", b);
                editor.apply();
                Log.i("SaveInfo", "Đã luu");
            } else {
                editor.clear();
                editor.putBoolean("key_bool", b);
                editor.apply();
                Toast.makeText(MainActivity.this, "Đã xóa", Toast.LENGTH_SHORT);
                Log.i("SaveInfo", "Đã xóa");
            }
        });
    }

    private void AddSharedPreferences() {
        sharedPreferences = getSharedPreferences("quynh", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private void SaveInfo() {
        editor.putString("key_name", edtHoTen.getText().toString()).apply();
        editor.putString("key_password", edtMSV.getText().toString()).apply();
        editor.commit();
        Toast.makeText(MainActivity.this, "Đã lưu", Toast.LENGTH_SHORT);
    }

    private void ReloadSavedInfo() {
        cbxSaveInfo.setChecked(sharedPreferences.getBoolean("key_bool", false));
        if(sharedPreferences.getBoolean("key_bool", false)){
            String name = sharedPreferences.getString("key_name", "Hoten");
            String password = sharedPreferences.getString("key_password", "Password");
            edtHoTen.setText(name);
            edtMSV.setText(password);
            Toast.makeText(MainActivity.this, "Đã khôi phục", Toast.LENGTH_SHORT);
        }
    }
}