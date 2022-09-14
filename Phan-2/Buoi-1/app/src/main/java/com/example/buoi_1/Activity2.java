package com.example.buoi_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    ListView listView;
    AmThucAdapter atadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Controls();
        Events();
        Data();
    }

    private void Controls() {
        listView = findViewById(R.id.listView);

        atadapter = new AmThucAdapter(this, R.layout.listview);

        listView.setAdapter(atadapter);
    }

    private void Events() {
        // Sự kiện khi click vào 1 item trong ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Activity2.this, atadapter.getItem(position).getNameAmThuc(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                atadapter.remove(atadapter.getItem(position));
                atadapter.notifyDataSetChanged();
                Toast.makeText(Activity2.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


    private void Data(){
        atadapter.add(new AmThuc(R.drawable.ic_android_black_24dp, "Bánh mì"));
        atadapter.add(new AmThuc(R.drawable.ic_android_black_24dp, "Bánh tét"));
    }
}