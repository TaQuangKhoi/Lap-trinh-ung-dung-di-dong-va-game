package com.khoitien.teachsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NoteDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "noteManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "notes";

    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";

    public NoteDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_TITLE + " TEXT,"
                + KEY_CONTENT + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, note.getTitle());
        values.put(KEY_CONTENT, note.getContent());

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public Note getNote(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                new String[]{KEY_ID, KEY_TITLE, KEY_CONTENT},
                KEY_ID + "=?", new String[]{String.valueOf(id)},
                null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Note note = new Note(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2));

        return note;
    }

    public List<Note> getAllNotes() {
        List<Note> noteList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {
            Note note = new Note(cursor.getInt(0), cursor.getString(1), cursor.getString(2));

            noteList.add(note);

            cursor.moveToNext();
        }

        return noteList;
    }

    public void updateNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, note.getTitle());
        values.put(KEY_CONTENT, note.getContent());

        db.update(TABLE_NAME, values, KEY_ID + "=?",
                new String[]{String.valueOf(note.getId())});

        db.close();
    }

    public void deleteNote (Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, KEY_ID + "=?", new String[]{String.valueOf(note.getId())});

        db.close();
    }
}
