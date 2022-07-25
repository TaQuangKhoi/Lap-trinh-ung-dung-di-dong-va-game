package com.example.buoi_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv1;
    EditText et1;
    Button btnAdd;
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Các ánh xạ
        lv1 = findViewById(R.id.lv1);
        et1 = findViewById(R.id.et1);
        btnAdd = findViewById(R.id.btnadd);
        btnChange = findViewById(R.id.btnchange);

        // Tạo dữ liệu
        //final String[] data = {"Android", "IOS", "Windows", "Linux", "Mac OS", "Ubuntu", "Debian"};
        // String[] data = getResources().getStringArray(R.array.list_os);
        //final String[] data = {"Android", "IOS", "Windows", "Linux", "Mac OS", "Ubuntu", "Debian"};

        ArrayList list = new ArrayList <String>();
        list.add("Android");
        list.add("iOS");
        list.add("Windows Phone");


        // Tạo adapter
        ArrayAdapter adapter_data_os = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        // Gán adapter cho listview
        lv1.setAdapter(adapter_data_os);

        // Nhấn nút để thêm item vào lv với tên trong et1
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add(et1.getText().toString());
                adapter_data_os.notifyDataSetChanged();
            }
        });

        // Hiện txt của item được chọn vào et1
        lv1.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                et1.setText(list.get(i).toString());

                /* Sau khi người dùng thay đổi txt của item,
                thì nhấn btnChange để cập nhật txt mới cho item đó */
                btnChange.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        list.set(i, et1.getText().toString());
                        adapter_data_os.notifyDataSetChanged(); // Cập nhật lại adapter
                    }
                });
            }

        });

        // Nhấn Long Click để xoá item được chọn
        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                adapter_data_os.notifyDataSetChanged();
                return true;
            }
        });
    }

}