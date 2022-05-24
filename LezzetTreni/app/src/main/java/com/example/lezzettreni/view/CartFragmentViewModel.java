package com.example.lezzettreni.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lezzettreni.entity.CartFood;
import com.example.lezzettreni.repo.FoodsDaoRepository;

import java.util.List;

public class CartFragmentViewModel extends ViewModel {
    private FoodsDaoRepository frepo = new FoodsDaoRepository();
    public MutableLiveData<List<CartFood>> cartFoodList;

    private String userName = "burcu_bayik";

    public CartFragmentViewModel(){
        getFoods();
        cartFoodList = frepo.getcFoodList();
    }


    public void getFoods(){

        frepo.getCartFoods(this.userName);

    }

    public void delete(int id,String userName)
    {
        frepo.deleteFoods(id,userName);
        getFoods();
    }




}
