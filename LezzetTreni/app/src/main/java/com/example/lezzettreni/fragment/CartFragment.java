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
import com.example.lezzettreni.adapter.CartAdapter;
import com.example.lezzettreni.databinding.FragmentCartBinding;
import com.example.lezzettreni.entity.CartFood;
import com.example.lezzettreni.view.CartFragmentViewModel;

import java.util.List;

public class CartFragment extends Fragment {
    private FragmentCartBinding design;
    private CartFragmentViewModel viewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_cart,container,false);
        design.setToolbarCartTitle("Sepet");

        viewModel.cartFoodList.observe(getViewLifecycleOwner(),list->{

            CartAdapter cartAdapter = new CartAdapter(requireContext(),list,viewModel);
            totalPrice(list);
            design.setCartAdapter(cartAdapter);
        });

        return design.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CartFragmentViewModel.class);
    }
    public void totalPrice(List<CartFood> cartFoods){
            int total = 0;
            for (CartFood c : cartFoods) {
                total += c.getYemek_fiyat() * c.getYemek_siparis_adet();
            }
            design.setTotalPrice(String.valueOf(total));
    }
}