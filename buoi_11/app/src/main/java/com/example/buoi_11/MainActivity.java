package com.example.buoi_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv1;
    EditText edt1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Các ánh xạ
        lv1 = findViewById(R.id.lv1);
        edt1 = findViewById(R.id.edt1);

        // Tạo dữ liệu
        //final String[] data = {"Android", "IOS", "Windows", "Linux", "Mac OS", "Ubuntu", "Debian"};
        final String[] data = getResources().getStringArray(R.array.list_os);

        // Tạo adapter
        ArrayAdapter adapter_data_os = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);

        // Gán adapter cho listview
        lv1.setAdapter(adapter_data_os);
    }
}