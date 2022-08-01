package com.example.kt_thuchanh_txcc;

import android.graphics.Color;

public class ChucNang {
    int imIconID;
    String tenChucNang;
    Color color;

    public ChucNang(int imID, String tenChucNang, Color color) {
        this.imIconID = imID;
        this.tenChucNang = tenChucNang;
        this.color = color;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
