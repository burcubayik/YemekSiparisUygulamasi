package com.example.lezzettreni.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lezzettreni.R;
import com.example.lezzettreni.databinding.CardDesignBinding;
import com.example.lezzettreni.entity.Foods;
import com.example.lezzettreni.fragment.HomePageFragmentDirections;
import com.example.lezzettreni.view.HomePageFragmentViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.CardDesignHolder> {
    private Context mContext;
    private List<Foods> foodsList;
    private HomePageFragmentViewModel viewModel;

    public FoodsAdapter(Context mContext, List<Foods> foodsList, HomePageFragmentViewModel viewModel) {
        this.mContext = mContext;
        this.foodsList = foodsList;
        this.viewModel = viewModel;
    }

    public class CardDesignHolder extends RecyclerView.ViewHolder {
        private CardDesignBinding design;

        public CardDesignHolder(CardDesignBinding design) {
            super(design.getRoot());
            this.design = design;
        }
    }

    @NonNull
    @Override
    public CardDesignHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardDesignBinding design = DataBindingUtil.inflate(layoutInflater, R.layout.card_design,parent,false);
        return new CardDesignHolder(design);
    }

    @Override
    public void onBindViewHolder(@NonNull CardDesignHolder holder, int position) {
        Foods food = foodsList.get(position);
        CardDesignBinding t = holder.design;
        t.setFoodObject(food);
        t.foodCard.setOnClickListener(view -> {
            HomePageFragmentDirections.GoToDetail go = HomePageFragmentDirections.goToDetail(food);
            Navigation.findNavController(view).navigate(go);
        });
        String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + food.getPictureName();
        Picasso.get().load(url).into(t.imageViewHomeList);



    }

    @Override
    public int getItemCount() {
        return foodsList.size();
    }





}
