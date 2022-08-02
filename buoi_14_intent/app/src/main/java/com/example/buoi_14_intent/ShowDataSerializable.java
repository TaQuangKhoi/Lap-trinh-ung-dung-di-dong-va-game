package com.example.buoi_14_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDataSerializable extends AppCompatActivity {
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

        Bundle bd = getIntent().getBundleExtra("goi");
        String chuoi = bd.getString("chuoi");
        int so = bd.getInt("so", 123);
        String [] mangNhan =  bd.getStringArray("mang");
        HocSinh hs = (HocSinh) bd.getSerializable("doituong");

        receiveString.setText("Chuỗi nhận được là: " + chuoi.toString());
        receiveArray.setText("Giá trị đầu tiên của mảng là: " + mangNhan[0]);
        receiveNumber.setText("Tuổi nhận được là: " + so);
        receiveObject.setText("Học sinh tên " + hs.getTen() + " và lớp là: " + hs.getLop());

    }
}