package com.example.buoi_10_fuck;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.buoi_10_fuck.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private TextView tv1;
    private Button btn1;
    private Button btn2;
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); // Chỉnh cái này

        // Ánh xạ
        tv1 = (TextView)findViewById(R.id.tv1); // Thêm cài này để ánh xạ:v - từ android 3., có thễ bỏ qua ép kiểu
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        et1 = (EditText) findViewById(R.id.et1);

        // Đăng ký Event
        /* Cach 2
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setText("123");
            }
        });*/

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //tv1.setText("Cách 3");
        /*
        Toast.makeText(this,
                et1.getText().toString(), Toast.LENGTH_SHORT).show();*/
        AlertDialog.Builder al1 = new AlertDialog.Builder(this);
        al1.setIcon(R.drawable.ic_plus);
        al1.setTitle("Tiêu đề");
        al1.setMessage("Thử nghiệm");
        al1.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Đã nhấn đồng ý", Toast.LENGTH_SHORT).show();
            }
        });
        al1.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Đã nhấn không đồng ý", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog.Builder builder = al1.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Đã nhấn huỷ", Toast.LENGTH_SHORT).show();
            }
        });
        al1.show();
    }

   /* @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
*/

    public void doitext(View view) {
        //textView.setText("jadh");
    }
}