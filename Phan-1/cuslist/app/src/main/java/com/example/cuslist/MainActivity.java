package com.example.cuslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private BussAdapter busAdapter;
    ListView lvBus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        fakeData();
    }

    private void fakeData() {
        busAdapter.add(new buss(R.drawable.xeden, "Bus 1", "Vũng Tàu - Hồ Chí Minh"));
        busAdapter.add(new buss(R.drawable.xedo, "Bus 2", "Hồ Chí Minh - Vũng Tàu"));
        busAdapter.add(new buss(R.drawable.xexxanh, "Bus 3", "Hồ Chí Minh - Đà Nẵng"));
        busAdapter.add(new buss(R.drawable.xetim, "Bus 4", "Đà Nẵng - Hồ Chí Minh"));
        busAdapter.add(new buss(R.drawable.xeden, "Bus 5", "Đà Lạ - Vũng Tàu"));

    }

    private void addEvents() {
        lvBus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, busAdapter.getItem(i).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        lvBus.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Remove item from list
                Toast.makeText(MainActivity.this, "Bạn đã xóa xe " +
                        busAdapter.getItem(i).getNameBus(),
                        Toast.LENGTH_SHORT).show();
                busAdapter.remove(busAdapter.getItem(i));
                return false;
            }
        });
    }

    private void addControls() {
        lvBus = findViewById(R.id.Lv1);
        busAdapter = new BussAdapter(this,R.layout.cuslist);
        lvBus.setAdapter(busAdapter);
    }
}