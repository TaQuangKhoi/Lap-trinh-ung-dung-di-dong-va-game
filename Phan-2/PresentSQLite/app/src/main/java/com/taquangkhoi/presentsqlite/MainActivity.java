package com.taquangkhoi.presentsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Button;
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

        AnhXa();
        LoadData();
        SuKien();
    }

    // Hàm chứa code ánh xạ
    private void AnhXa() {
        edtTitle = findViewById(R.id.edt_Title);
        edtContent = findViewById(R.id.edt_Content);

        btnNew = findViewById(R.id.btn_new);
        btnSave = findViewById(R.id.btn_save);
        btnUpdate = findViewById(R.id.btn_update);
        btnDelete = findViewById(R.id.btn_delete);

        lv = findViewById(R.id.listView);
    }

    // Gán dữ liệu từ database vào ListView,
    private void LoadData() {
        noteAdapter = new NoteAdapter(this, R.layout.item_listview);

        noteDbHelper = new NoteDbHelper(this);

        noteAdapter.addAll(noteDbHelper.getAllNotes());

        lv.setAdapter(noteAdapter);
    }

    // Hàm chứa code xử lý sự kiện
    private void SuKien() {
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtTitle.setText("");
                edtContent.setText("");
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtTitle.getText().toString().equals("")
                        || edtContent.getText().toString().equals("")) {
                    return;
                } else {
                    String title = edtTitle.getText().toString();
                    String content = edtContent.getText().toString();
                    Note note = new Note(title, content);

                    noteDbHelper.addNote(note);

                    LoadData();
                }
            }
        });



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = noteAdapter.getItem(position);

                edtTitle.setText(note.getTitle());
                edtContent.setText(note.getContent());

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        note.setTitle(edtTitle.getText().toString());
                        note.setContent(edtContent.getText().toString());

                        noteDbHelper.updateNote(note);

                        LoadData();
                    }
                });

                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        noteDbHelper.deleteNote(note);

                        LoadData();
                    }
                });
            }
        });
    }
}