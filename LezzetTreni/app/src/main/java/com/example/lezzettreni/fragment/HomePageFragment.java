package com.example.lezzettreni.fragment;

import android.os.Bundle;


import androidx.annotation.Nullable;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lezzettreni.R;
import com.example.lezzettreni.adapter.FoodsAdapter;
import com.example.lezzettreni.databinding.FragmentHomePageBinding;
import com.example.lezzettreni.view.HomePageFragmentViewModel;

public class HomePageFragment extends Fragment{
    private FragmentHomePageBinding design;
    private HomePageFragmentViewModel viewModel;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page,container,false);
        design.setHomePageFragment(this);
        design.setToolbarHomeTitle("Lezzet Treni");
        design.setSayHello("Merhaba");
        viewModel.foodsList.observe(getViewLifecycleOwner(),list->{
            FoodsAdapter adapter = new FoodsAdapter(requireContext(),list,viewModel);
            design.setFoodsAdapter(adapter);
        });
        return design.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomePageFragmentViewModel.class);
    }
}