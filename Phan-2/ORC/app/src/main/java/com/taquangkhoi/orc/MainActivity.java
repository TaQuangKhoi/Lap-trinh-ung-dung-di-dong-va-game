package com.taquangkhoi.orc;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnTakePhoto, btnCopy, btnPickPhoto;
    TextView tvwResult;
    private static final int REQUEST_CAMERA_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControls();
        CheckPermission();
        AddEvents();
    }

    private void AddControls() {
        btnTakePhoto = findViewById(R.id.btnTakePhoto);
        btnCopy = findViewById(R.id.btnCopy);
        btnPickPhoto = findViewById(R.id.btnPickPhoto);
        tvwResult = findViewById(R.id.tvwResult);

    }

    private void CheckPermission() {
        if (ContextCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{ Manifest.permission.CAMERA },
                    REQUEST_CAMERA_CODE);
        }
    }

    private void AddEvents() {
        btnTakePhoto.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraLauncher.launch(intent);
        });
        btnPickPhoto.setOnClickListener(v -> {});
        btnCopy.setOnClickListener(v -> {});
    }

    // ActivityResultLauncher for camera
    ActivityResultLauncher<Intent> cameraLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                }
            }
    );
}