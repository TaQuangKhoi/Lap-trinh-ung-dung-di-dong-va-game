package com.example.learnaboutmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}