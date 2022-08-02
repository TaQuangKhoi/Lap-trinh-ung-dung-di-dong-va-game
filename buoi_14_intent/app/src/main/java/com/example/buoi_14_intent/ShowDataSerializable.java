package com.example.buoi_14_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class show_data_serializable extends AppCompatActivity {
    TextView receiveString;
    TextView receiveNumber;
    TextView receiveArray;
    TextView receiveObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data_serializable);

        receiveString = findViewById(R.id.receive_string);
        receiveNumber = findViewById(R.id.receive_number);
        receiveArray = findViewById(R.id.receive_array);
        receiveObject = findViewById(R.id.receive_object);

        String chuoi = getIntent().getStringExtra("chuoi");
        int so = getIntent().getIntExtra("so", 123);
        String [] mangNhan =  getIntent().getStringArrayExtra("mang");
        HocSinh hs = (HocSinh) getIntent().getSerializableExtra("doituong");

        receiveString.setText("Chuỗi nhận được là: " + chuoi.toString());
        receiveArray.setText("Giá trị đầu tiên của mảng là: " + mangNhan[0]);
        receiveNumber.setText("Tuổi nhận được là: " + so);
        receiveObject.setText("Học sinh tên " + hs.getTen() + " và lớp là: " + hs.getLop());

    }
}