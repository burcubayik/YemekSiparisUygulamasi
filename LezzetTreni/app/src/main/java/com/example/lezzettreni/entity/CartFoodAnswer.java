package com.example.lezzettreni.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CartFoodAnswer {
    @SerializedName("sepet_yemekler")
    @Expose
    private List<CartFood> cartFoods;
    @SerializedName("success")
    @Expose
    private int success;

    public CartFoodAnswer() {
    }

    public CartFoodAnswer(List<CartFood> cartFoods, int success) {
        this.cartFoods = cartFoods;
        this.success = success;
    }

    public List<CartFood> getCartFoods() {
        return cartFoods;
    }

    public void setCartFoods(List<CartFood> cartFoods) {
        this.cartFoods = cartFoods;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
