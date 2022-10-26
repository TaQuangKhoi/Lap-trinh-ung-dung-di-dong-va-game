package com.khoitien.learnsharepreferenceswithquynh;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen;
    EditText edtMSV;
    CheckBox cbxSaveInfo;
    Button btnDangNhap;
    TextView tvwDebug;
    Button btnChangeLang;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String name;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        AddSharedPreferences();

        AddControls();
        AddEvents();

        ReloadSavedInfo();

        btnChangeLang.setOnClickListener(view -> ShowLanguageDialog());

    }

    private void AddControls() {
        edtHoTen = findViewById(R.id.edt_hovaten);
        edtMSV = findViewById(R.id.edt_password);
        cbxSaveInfo = findViewById(R.id.cbx_save_info);
        btnDangNhap = findViewById(R.id.btn_dang_nhap);
        tvwDebug = findViewById(R.id.tvw_debug);
        btnChangeLang = findViewById(R.id.btn_change_language);
    }

    private void AddEvents() {
        btnDangNhap.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ShowResult.class);
            startActivity(intent);
        });

        cbxSaveInfo.setOnCheckedChangeListener((compoundButton, b) -> {
            if (cbxSaveInfo.isChecked()){
                SaveInfo();
                editor.putBoolean("key_bool", b).apply();
                Log.i("SaveInfo", "Đã luu");
            } else {
                editor.clear();
                editor.putBoolean("key_bool", b).apply();
                Toast.makeText(MainActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                Log.i("SaveInfo", "Đã xóa");
            }
        });
    }

    private void AddSharedPreferences() {
        sharedPreferences = getSharedPreferences("quynh", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private void SaveInfo() {
        name = edtHoTen.getText().toString();
        password = edtMSV.getText().toString();
        editor.putString("key_name", name).apply();
        editor.putString("key_password", password).apply();
        editor.commit();
        tvwDebug.setText(name + password);
        Toast.makeText(MainActivity.this, "Đã lưu", Toast.LENGTH_SHORT).show();
        Log.i("SaveInfo", "Đã chạy hàm");
    }

    private void ReloadSavedInfo() {
        cbxSaveInfo.setChecked(sharedPreferences.getBoolean("key_bool", false));
        if(sharedPreferences.getBoolean("key_bool", false)){
            name = sharedPreferences.getString("key_name", "Hoten");
            password = sharedPreferences.getString("key_password", "Password");
            edtHoTen.setText(name);
            edtMSV.setText(password);
            Toast.makeText(MainActivity.this, "Đã khôi phục", Toast.LENGTH_SHORT).show();
        }
    }

    private void ShowLanguageDialog () {
        final String[] listAvailableLanguage = {"Tiếng Việt", "日本", "English"};

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);

        mBuilder.setTitle("Choose Language...");
        mBuilder.setSingleChoiceItems(listAvailableLanguage, -1,
                (dialogInterface, i) -> {
                    if(i == 0)
                    {
                        //Tiếng Việt
                        setLocale("vi");
                        Relauch();
                    }
                    else if(i == 1)
                    {
                        //Tiếng Trung
                        setLocale("zh");
                        Relauch();
                    }
                    else if(i == 2)
                    {
                        //Tiếng Anh
                        setLocale("en");
                        Relauch();
                    }

                    //tắt alert dialog khi đã chọn ngôn ngữ
                    dialogInterface.dismiss();
                });

        AlertDialog mDialog = mBuilder.create();
        //Hiện AlterDialog
        mDialog.show();

    }

    private void Relauch() {
        finish();
        startActivity(getIntent());
        overridePendingTransition(0, 0); // chạy luôn, không cần xếp trong hàng đợi
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(
                config, getBaseContext().getResources().getDisplayMetrics());

        //Lưu dữ liệu vào shared preferences

        SharedPreferences.Editor editor = getSharedPreferences("Setting", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    //Đưa ngôn ngữ được lưu vào shared preferences
    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Setting", MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);
    }

}