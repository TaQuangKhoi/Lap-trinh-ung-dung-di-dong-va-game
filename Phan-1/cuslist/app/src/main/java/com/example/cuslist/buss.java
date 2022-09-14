package com.example.cuslist;

public class buss {
    //thuoc tính
private int Image;
private String NameBus, RouteBus;
    //ham khoi tao

    public buss(int image, String nameBus, String routeBus) {
        Image = image;
        NameBus = nameBus;
        RouteBus = routeBus;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getNameBus() {
        return NameBus;
    }

    public void setNameBus(String nameBus) {
        NameBus = nameBus;
    }

    public String getRouteBus() {
        return RouteBus;
    }

    public void setRouteBus(String routeBus) {
        RouteBus = routeBus;
    }
//getter va setter

    //ham toString
    @Override
    public String toString() {
        return this.NameBus + " " + this.RouteBus;
    }
}

