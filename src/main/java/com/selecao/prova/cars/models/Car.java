package com.selecao.prova.cars.models;

public class Car {


//    private String _id;
    private String title;
    private String brand;
    private String price;
    private int age;

    public Car() {}

    public Car(String title, String brand, String price, int age) {
        this.title = title;
        this.brand = brand;
        this.price = price;
        this.age = age;
    }

//    public String get_id() {
//        return _id;
//    }
//
//    public void set_id(String _id) {
//        this._id = _id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
