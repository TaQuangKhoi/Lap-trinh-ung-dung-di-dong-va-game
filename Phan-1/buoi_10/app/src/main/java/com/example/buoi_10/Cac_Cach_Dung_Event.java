package com.example.buoi_10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.buoi_10.databinding.ActivityCacCachDungEventBinding;

public class Cac_Cach_Dung_Event extends AppCompatActivity {

    private ActivityCacCachDungEventBinding binding;
    Button btnc2;
    Button btnc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCacCachDungEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_cac_cach_dung_event);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Cách 2: Using an Anonymous Inner Class

        btnc2 = (Button) findViewById(R.id.btnc2);
        /*
        btnc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Cac_Cach_Dung_Event.this, "Cách 3", Toast.LENGTH_SHORT).show();
            }
        });*/

        // Cách 3: Activity class implements the Listener interface.

        btnc3 = (Button) findViewById(R.id.btnc3);
        View.OnClickListener(this);
    }

    // Cách 1: Đăng ký sự kiện trong file XML - Using Layout file activity_main.xml to specify event handler directly.
    public void Cach1 (View v) {
        Toast.makeText(this, "Cach 1", Toast.LENGTH_SHORT).show();
    }
}