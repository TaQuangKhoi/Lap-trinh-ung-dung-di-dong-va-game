package com.example.buoi_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

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