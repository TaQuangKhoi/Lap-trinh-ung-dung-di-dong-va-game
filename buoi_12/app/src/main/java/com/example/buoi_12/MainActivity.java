package com.example.buoi_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Buses[] bus_list;
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
        bus_list = new Buses[3];
        bus_list[0] = new Buses(R.drawable.bus_1, "Bus 1", "Hà Nội - Hồ Chí Minh");
        bus_list[1] = new Buses(R.drawable.bus_2, "Bus 2", "Hà Nội - Hồ Chí Minh");
        bus_list[2] = new Buses(R.drawable.bus_3, "Bus 3", "Hà Nội - Hồ Chí Minh");

        busAdapter.addAll(bus_list);
    }
}