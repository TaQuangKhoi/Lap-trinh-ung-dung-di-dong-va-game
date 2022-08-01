package com.example.kt_thuchanh_txcc;

public class ChucNang {
    int imID;
    String tenChucNang;

    public ChucNang(int imID, String tenChucNang) {
        this.imID = imID;
        this.tenChucNang = tenChucNang;
    }

    public int getImID() {
        return imID;
    }

    public void setImID(int imID) {
        this.imID = imID;
    }

    public String getTenChucNang() {
        return tenChucNang;
    }

    public void setTenChucNang(String tenChucNang) {
        this.tenChucNang = tenChucNang;
    }
}
