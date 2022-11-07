package com.khoitien.teachsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EditText edtTitle, edtContent;
    Button btn;
    ListView lv;
    NoteDbHelper noteDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControls();
        LoadData();
    }

    private void AddControls() {
        edtTitle = findViewById(R.id.edt_Title);
        edtContent = findViewById(R.id.edt_Content);
        btn = findViewById(R.id.btn);
        lv = findViewById(R.id.lv);
    }

    private void LoadData() {
        noteDbHelper = new NoteDbHelper(this);
    }
}