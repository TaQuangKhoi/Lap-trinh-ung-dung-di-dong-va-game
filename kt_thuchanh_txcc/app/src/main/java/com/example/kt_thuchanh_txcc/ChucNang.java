package com.example.kt_thuchanh_txcc;

import android.graphics.Color;

public class ChucNang {
    int imIconID;
    String tenChucNang;
    Color BackgroundColor;

    public ChucNang(int imID, String tenChucNang, Color BackgroundColor) {
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

    public Color getBackgroundColor() {
        return BackgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.BackgroundColor = backgroundColor;
    }
}
