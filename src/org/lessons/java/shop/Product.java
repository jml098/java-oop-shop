package org.lessons.java.shop;

import java.util.ArrayList;
import java.util.Random;

public class Product {
    private int code;
    private String name;
    private String description;
    private double price;
    private double vat;
    private ArrayList<Category> categories;

    public Product() {
        this.code = new Random().nextInt(1, 100000000);
        this.categories = new ArrayList<>();
    }

    public Product(String name, String description, double price, double vat, ArrayList<Category> categories) {
        this();
        this.name = name;
        this.description = description;
        this.price = price;
        this.vat = vat;
        this.categories = categories;
    }

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public double getVatPrice() {
        return this.price + this.price * (this.vat / 100);
    }

    public String getProductName() {
        String stringCode = String.valueOf(this.code);
        int codeLength = stringCode.length();
        return "0".repeat(8 - codeLength) + stringCode + "-" + this.name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vat=" + vat +
                ", categories=" + categories +
                '}';
    }
}
