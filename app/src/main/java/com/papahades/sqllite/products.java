package com.papahades.sqllite;

public class products {
    private int ID;
    private String productName ;


    public products(){}


    public products(String productName) {
        this.productName = productName;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getID() {
        return ID;
    }

    public String getProductName() {
        return productName;
    }
}
