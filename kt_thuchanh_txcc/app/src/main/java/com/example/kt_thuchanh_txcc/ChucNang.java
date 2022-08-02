package com.example.kt_thuchanh_txcc;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

public class ChucNang {
    int imIconID;
    String tenChucNang;
    int BackgroundColor;

    public ChucNang(int imID, String tenChucNang, int BackgroundColor) {
        this.imIconID = imID;
        this.tenChucNang = tenChucNang;
        this.BackgroundColor = BackgroundColor;
    }

    public ChucNang(int imIconID, String tenChucNang) {
        this.imIconID = imIconID;
        this.tenChucNang = tenChucNang;
    }

    public int getImIconID() {
        return imIconID;
    }

    public void setImIconID(int imIconID) {
        this.imIconID = imIconID;
    }

    public String getTenChucNang() {
        return tenChucNang;
    }

    public void setTenChucNang(String tenChucNang) {
        this.tenChucNang = tenChucNang;
    }

    public int getBackgroundColor() {
        return BackgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.BackgroundColor = backgroundColor;
    }
}
