package com.mphasis;

import java.io.Serializable;

public class Bottle implements Serializable {
    private int id;
    private String brand;
    private int price;
    private String color;

    public Bottle(int id, String brand, int price, String color) {
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bottle [id=" + id + ", brand=" + brand + ", price=" + price + ", color=" + color + "]";
    }
}
