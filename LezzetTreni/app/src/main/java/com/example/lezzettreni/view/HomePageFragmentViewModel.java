package com.example.lezzettreni.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lezzettreni.entity.Foods;
import com.example.lezzettreni.repo.FoodsDaoRepository;

import java.util.List;

public class HomePageFragmentViewModel extends ViewModel {
    private FoodsDaoRepository frepo = new FoodsDaoRepository();
    public MutableLiveData<List<Foods>> foodsList = new MutableLiveData<>();

    public HomePageFragmentViewModel() {
        getFoods();
        foodsList = frepo.getFoods();
    }

    public void getFoods(){
        frepo.getAllFoods();
    }


}
