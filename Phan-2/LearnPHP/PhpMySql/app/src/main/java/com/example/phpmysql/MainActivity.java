package com.example.phpmysql;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CardView cardView;
    ImageView image;
    Dialog dialog;
    FurnitureAdapter furnitureAdapter;
    int REQUEST_CODE_PMFOLDER = 123;
    String realpath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        cardView = findViewById(R.id.add);

        furnitureAdapter = new FurnitureAdapter(this,R.layout.card);
        LoadData();

        listView.setAdapter(furnitureAdapter);


    }

    private void LoadData() {

    }


    public void OpenDiaLog(Boolean isAdd, Furniture f) {
        CreateDialog(R.layout.dialog);

        Button cancel = dialog.findViewById(R.id.dialog_cancel);
        TextView typeDialog = dialog.findViewById(R.id.type_dialog);
        Button add = dialog.findViewById(R.id.dialog_add);
        image = dialog.findViewById(R.id.dialog_img);
        EditText edtname = dialog.findViewById(R.id.dialog_name);
        EditText edtdetail = dialog.findViewById(R.id.dialog_detail);
        EditText edtprice = dialog.findViewById(R.id.dialog_price);


        dialog.show();
    }

    private String UploadImage() {
        return "";
    }

    public void CreateDialog(int layout){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(layout);
        dialog.setCancelable(false);

        final Window window = dialog.getWindow();
        window.setLayout(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER;
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setDimAmount(0.5f);
        window.setAttributes(wlp);

        ((ViewGroup)dialog.getWindow().getDecorView())
                .getChildAt(0).startAnimation(AnimationUtils.loadAnimation(
                        this,android.R.anim.slide_in_left));
    }



    public void CloseDialog() {
        ((ViewGroup)dialog.getWindow().getDecorView())
                .getChildAt(0).startAnimation(AnimationUtils.loadAnimation(
                        MainActivity.this,android.R.anim.slide_out_right));

        CountDownTimer countDownTimer = new CountDownTimer(400,400) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                dialog.dismiss();
            }
        };
        countDownTimer.start();
    }


    private void AddFurniture(String name, String detail, Float price) {

    }

    private void UpdateFurniture(String name, String detail, Float price,String image, int id) {

    }

    public void OpenDialogDelete(int id){
        CreateDialog(R.layout.dialog_delete);

        Button yes = dialog.findViewById(R.id.dialog_yes);
        Button no = dialog.findViewById(R.id.dialog_no);


    }

    public void DeleteFurniture(int id){

    }


}