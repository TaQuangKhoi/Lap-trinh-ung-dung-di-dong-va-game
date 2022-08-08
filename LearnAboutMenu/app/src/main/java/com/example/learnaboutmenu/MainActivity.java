package com.example.learnaboutmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        registerForContextMenu(tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game_menu, menu); // Trỏ đến cả Menu
        MenuItem menuItem = menu.findItem(R.id.new_game); // trỏ đến từng item
        return super.onCreateOptionsMenu(menu);
    }

    // Code chạy khi nhấn từng item
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.new_game:
                Toast.makeText(this, "Vừa nhấn New Game", Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(this, "Vừa nhấn Help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "Vừa nhấn Item 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem1:
                Toast.makeText(this, "Vừa nhấn Sub Item 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem2:
                Toast.makeText(this, "Vừa nhấn Sub Item 2", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.ct1:
                Toast.makeText(this, "Nhấn CT 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ct2:
                Toast.makeText(this, "Nhấn CT 2", Toast.LENGTH_SHORT).show();
                break;
            default:

        }

        return super.onContextItemSelected(item);
    }
}