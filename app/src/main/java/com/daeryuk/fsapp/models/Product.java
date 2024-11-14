package com.daeryuk.fsapp.models;

public class Product {
    private String productName;
    private Integer image;
    private Double price;

    public Product(String productName, Integer image, Double price) {
        this.productName = productName;
        this.image = image;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
