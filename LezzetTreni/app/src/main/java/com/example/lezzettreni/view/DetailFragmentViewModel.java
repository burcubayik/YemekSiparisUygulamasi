package com.example.lezzettreni.view;

import androidx.lifecycle.ViewModel;
import com.example.lezzettreni.repo.FoodsDaoRepository;

public class DetailFragmentViewModel extends ViewModel {
    private FoodsDaoRepository frepo = new FoodsDaoRepository();
    private String userName = "burcu_bayik";

    public void add(String foodName, String pictureName, int foodPrice, int orderAmount ){
        frepo.addFood(foodName,pictureName,foodPrice,orderAmount,userName);
    }

}
