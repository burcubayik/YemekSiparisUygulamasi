package com.example.lezzettreni.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lezzettreni.R;
import com.example.lezzettreni.databinding.CartCardDesignBinding;
import com.example.lezzettreni.entity.CartFood;
import com.example.lezzettreni.view.CartFragmentViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CardDesignHolder> {
    private Context mContext;
    private List<CartFood> cartFoodsList;
    private CartFragmentViewModel viewModel;



    public CartAdapter(Context mContext, List<CartFood> cartFoodsList, CartFragmentViewModel viewModel) {
        this.mContext = mContext;
        this.cartFoodsList = cartFoodsList;
        this.viewModel = viewModel;

    }


    public class CardDesignHolder extends RecyclerView.ViewHolder {
        private CartCardDesignBinding design;

        public CardDesignHolder(CartCardDesignBinding design) {
            super(design.getRoot());
            this.design = design;
        }
    }
    @NonNull
    @Override
    public CardDesignHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CartCardDesignBinding design = DataBindingUtil.inflate(layoutInflater, R.layout.cart_card_design,parent,false);

        return new CardDesignHolder(design);
    }

    @Override
    public void onBindViewHolder(@NonNull CardDesignHolder holder, int position) {
        CartFood cartFood = cartFoodsList.get(position);
        CartCardDesignBinding t = holder.design;
        t.setCartFoodObject(cartFood);

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + cartFood.getYemek_resim_adi();
        Picasso.get().load(url).into(t.imageView2);

        t.imageViewDelete.setOnClickListener(view ->{

            Snackbar.make(view,cartFood.getYemek_adi()+" silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("Evet",v1 -> {
                        viewModel.delete(cartFood.getSepet_yemek_id(),cartFood.getKullanici_adi());
                    }).show();

        });

    }

    @Override
    public int getItemCount() {
        return cartFoodsList.size();
    }
}
