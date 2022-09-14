package com.example.buoi_14_intent;

import java.io.Serializable;

public class HocSinh implements Serializable {
    String Ten;
    String Lop;

    public HocSinh(String ten, String lop) {
        Ten = ten;
        Lop = lop;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }
}
