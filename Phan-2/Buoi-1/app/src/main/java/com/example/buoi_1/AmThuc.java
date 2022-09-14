package com.example.buoi_1;

public class AmThuc {
    // Khai báo thuộc tính
    private int idImage;
    private String nameAmThuc;

    // Hàm khỏi tạo
    public AmThuc(int idImage, String nameAmThuc) {
        this.idImage = idImage;
        this.nameAmThuc = nameAmThuc;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getNameAmThuc() {
        return nameAmThuc;
    }

    public void setNameAmThuc(String nameAmThuc) {
        this.nameAmThuc = nameAmThuc;
    }
}
