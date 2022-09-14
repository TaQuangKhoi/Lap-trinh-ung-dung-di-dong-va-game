package com.example.buoi_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BusesAdapter busAdapter;
    ListView lvBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
        fakeData();
    }

    private void addControls() {
        lvBus = findViewById(R.id.lv);

        busAdapter = new BusesAdapter(this, R.layout.item_bus);

        lvBus.setAdapter(busAdapter);
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

    private void fakeData() {
        busAdapter.add(new Buses(R.drawable.bus_red, "Bus 1", "Vũng Tàu - Hồ Chí Minh"));
        busAdapter.add(new Buses(R.drawable.bus_yellow, "Bus 2", "Hồ Chí Minh - Vũng Tàu"));
        busAdapter.add(new Buses(R.drawable.bus_blue, "Bus 3", "Hồ Chí Minh - Đà Nẵng"));
        busAdapter.add(new Buses(R.drawable.bus_black, "Bus 4", "Đà Nẵng - Hồ Chí Minh"));
        busAdapter.add(new Buses(R.drawable.bus_pink, "Bus 5", "Đà Lạ - Vũng Tàu"));
        busAdapter.add(new Buses(R.drawable.bus_red, "Bus 6", "Vũng Tàu - Đà Lạ"));
        busAdapter.add(new Buses(R.drawable.bus_yellow, "Bus 7", "Hồ Chí Minh - Đà Lạt"));
        busAdapter.add(new Buses(R.drawable.bus_blue, "Bus 8", "Đà Lạt - Hồ Chí Minh"));
        busAdapter.add(new Buses(R.drawable.bus_black, "Bus 9", "Hà Nội - Hồ Chí Minh"));
        busAdapter.add(new Buses(R.drawable.bus_pink, "Bus 10", "Hồ Chí Minh - Hà Nội"));
        busAdapter.add(new Buses(R.drawable.bus_red, "Bus 11", "Cần Thơ - Vũng Tàu"));
        busAdapter.add(new Buses(R.drawable.bus_black, "Bus 12", "Vũng Tàu - Cần Thơ"));
    }
}