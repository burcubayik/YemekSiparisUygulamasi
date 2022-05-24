package com.example.lezzettreni.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lezzettreni.R;
import com.example.lezzettreni.databinding.FragmentDetailBinding;
import com.example.lezzettreni.entity.Foods;
import com.example.lezzettreni.view.DetailFragmentViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;


public class DetailFragment extends Fragment {
    private FragmentDetailBinding design;
    private DetailFragmentViewModel viewModel;
    private int amount = 0;
    private Foods gelenFood;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false);
        design.setDetailFragment(this);
        design.setDetailToolbarTitle("Yemek Detay");
        DetailFragmentArgs bundle = DetailFragmentArgs.fromBundle(getArguments());
        gelenFood = bundle.getFood();
        design.setFoodObject(gelenFood);

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + gelenFood.getPictureName();
        Picasso.get().load(url).into(design.imageViewDetail);


        return design.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DetailFragmentViewModel.class);

    }

    public void buttonPlusClick(){
        amount++;
        design.textViewDetailAmount.setText(String.valueOf(amount));


    }
    public void buttonMinusClick(){
        if (amount>0){
            amount--;

        }
        else {
            amount = 0;
        }
        design.textViewDetailAmount.setText(String.valueOf(amount));}

    public void buttonAddToCartClick(){

          viewModel.add(gelenFood.getFoodName(), gelenFood.getPictureName(), gelenFood.getPrice(),amount);
          Snackbar.make(design.getRoot(),gelenFood.getFoodName()+" sepete eklendi!", Snackbar.LENGTH_SHORT).show();
    }


    }

