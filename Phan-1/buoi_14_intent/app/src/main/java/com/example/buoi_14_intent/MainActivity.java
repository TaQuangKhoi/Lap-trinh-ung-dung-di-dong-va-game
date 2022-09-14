package com.example.buoi_14_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnOpenFacebook;
    Button btnOpenSerializable;
    Button btnNhanTin;
    Button btnClick;
    TextView tvName;
    public String[] mangTen = {"Khôi", "Thịnh", "Tâm", "Tiến"};
    HocSinh hs = new HocSinh("Khôi", "DH20LT");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenFacebook = findViewById(R.id.btn_open_facebook);
        btnOpenSerializable = findViewById(R.id.btn_open_serializable);
        btnNhanTin = findViewById(R.id.btn_nhantin);
        btnClick = findViewById(R.id.btn_click);

        btnOpenFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openFacebook = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://facebook.com"));
                startActivity(openFacebook);
            }
        });

        btnOpenSerializable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // PutExtraSeperate();
                PutExtraWithBundle();
            }
        });

        btnNhanTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:0935198419"));
                intent.putExtra("sms_body", "Chào em");
                startActivity(intent);
            }
        });

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LearnIntentResult.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    // Nhận kết quả từ intent
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1 && resultCode == RESULT_OK && data != null){
            tvName = findViewById(R.id.tv_my_name);
            tvName.setText(data.getStringExtra("dulieu"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    // Truyển dữ liệu với gói Bundle
    private void PutExtraWithBundle() {
        Intent openSerializable = new Intent(MainActivity.this,
                ShowDataSerializable.class);

        Bundle bd = new Bundle();
        bd.putString("chuoi", "Tạ Quang Khôi");
        bd.putInt("so", 1234);
        bd.putStringArray("mang", mangTen);
        bd.putSerializable("doituong", hs);

        openSerializable.putExtra("goi", bd);
        startActivity(openSerializable);
    }

    // Gửi data với putExtra từng biến một..
    private void PutExtraSeperate() {
        Intent openSerializable = new Intent(MainActivity.this,
                ShowDataSerializable.class);

        openSerializable.putExtra("chuoi", "Tạ Quang Khôi");
        openSerializable.putExtra("so", 1234);
        openSerializable.putExtra("mang", mangTen);
        openSerializable.putExtra("doituong", hs);

        startActivity(openSerializable);
    }
}