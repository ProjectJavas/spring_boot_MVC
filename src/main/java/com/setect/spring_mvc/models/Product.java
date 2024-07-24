package com.setect.spring_mvc.models;

import java.util.ArrayList;
import java.util.Arrays;

public class Product {
    private int id;
    private String name;
    private long barcode;
    private double unitPrice;
    private double sellPrice;
    private String photo;

    public static ArrayList<Product> productList1 = new ArrayList(
            Arrays.asList(new Product(1, "ABC", 1111, 1, 2, "ABC.png"),
                    new Product(2, "Tiger", 2222, 1, 2, null)));

    public Product() {

    }

    public Product(int id, String name, long barcode, double unitPrice, double sellPrice, String photo) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.unitPrice = unitPrice;
        this.sellPrice = sellPrice;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
