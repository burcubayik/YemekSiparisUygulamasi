package com.example.lezzettreni.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Foods implements Serializable {
    @SerializedName("yemek_id")
    @Expose
    private int id;
    @SerializedName("yemek_adi")
    @Expose
    private String foodName;
    @SerializedName("yemek_resim_adi")
    @Expose
    private String pictureName;
    @SerializedName("yemek_fiyat")
    @Expose
    private int price;

    public Foods() {
    }

    public Foods(int id, String foodName, String pictureName, int price) {
        this.id = id;
        this.foodName = foodName;
        this.pictureName = pictureName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
