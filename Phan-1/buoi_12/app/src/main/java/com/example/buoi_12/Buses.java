package com.example.buoi_12;
// Lớp để taọ đối tượng chứa dữ liệu
public class Buses {
    // Khai báo thuộc tính
    private int idImage;
    private String nameBus, routeBus;

    // Hàm khởi tạo
    public Buses(int idImage, String nameBus, String routeBus) {
        this.idImage = idImage;
        this.nameBus = nameBus;
        this.routeBus = routeBus;
    }

    // Tạo các getter và setter cho các thuộc tính trên
    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getNameBus() {
        return nameBus;
    }

    public void setNameBus(String nameBus) {
        this.nameBus = nameBus;
    }

    public String getRouteBus() {
        return routeBus;
    }

    public void setRouteBus(String routeBus) {
        this.routeBus = routeBus;
    }

    /* Hàm toString() để in ra thông tin của đối tượng
    * Ghi đè method toString() của class Object
    */
    @Override
    public String toString() {
        return this.nameBus + " " + this.routeBus;
    }

}

