package com.example.rangkumanuts;

public class Customer {

    private String customerName;
    private int imgId;

    public Customer(String customerName, int imgId){
        this.customerName = customerName;
        this.imgId = imgId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
