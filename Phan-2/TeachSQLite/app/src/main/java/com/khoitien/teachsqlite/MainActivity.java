package com.khoitien.teachsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EditText edtTitle, edtContent;
    Button btnNew, btnUpdate, btnDelete, btnSave;
    ListView lv;
    NoteDbHelper noteDbHelper;
    NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControls();
        LoadData();
        AddEvents();
        FirstShowData();
    }

    private void AddControls() {
        edtTitle = findViewById(R.id.edt_Title);
        edtContent = findViewById(R.id.edt_Content);
        btnNew = findViewById(R.id.btn_new);
        btnUpdate = findViewById(R.id.btn_update);
        btnDelete = findViewById(R.id.btn_delete);
        btnSave = findViewById(R.id.btn_save);
        lv = findViewById(R.id.lv);
    }

    private void FirstShowData() {
        Note note = noteAdapter.getItem(0);
        edtTitle.setText(note.getTitle());
        edtContent.setText(note.getContent());
    }

    private void LoadData() {
        noteAdapter = new NoteAdapter(this, R.layout.listview_notes);

        noteDbHelper = new NoteDbHelper(this);

        noteAdapter.addAll(noteDbHelper.getAllNotes());

        lv.setAdapter(noteAdapter);
    }

    private void AddEvents() {
        btnNew.setOnClickListener(v -> {
            edtTitle.setText("");
            edtContent.setText("");
            btnSave.setEnabled(true);
        });

        btnSave.setOnClickListener(v -> {
            String title = edtTitle.getText().toString();
            String content = edtContent.getText().toString();
            Note note = new Note(title, content);
            noteDbHelper.addNote(note);

            LoadData();
            btnSave.setEnabled(false);
        });

        lv.setOnItemClickListener((parent, view, position, id) -> {
            Note note = noteAdapter.getItem(position);
            edtTitle.setText(note.getTitle());
            edtContent.setText(note.getContent());

            btnUpdate.setOnClickListener(v -> {
                note.setTitle(edtTitle.getText().toString());
                note.setContent(edtContent.getText().toString());
                noteDbHelper.updateNote(note);

                LoadData();
            });

            btnDelete.setOnClickListener(v -> {
                noteDbHelper.deleteNote(note);

                LoadData();
            });
        });
    }
}