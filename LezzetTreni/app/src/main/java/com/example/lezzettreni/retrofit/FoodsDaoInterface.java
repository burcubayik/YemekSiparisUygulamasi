package com.example.lezzettreni.retrofit;

import com.example.lezzettreni.entity.CRUDAnswer;
import com.example.lezzettreni.entity.CartFoodAnswer;
import com.example.lezzettreni.entity.FoodsAnswer;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FoodsDaoInterface {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    @GET("yemekler/tumYemekleriGetir.php")
    Call<FoodsAnswer> allFoods();

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    Call<CRUDAnswer> addToCart
            (@Field("yemek_adi") String yemek_adi, @Field("yemek_resim_adi") String yemek_resim_adi,
             @Field("yemek_fiyat") int yemek_fiyat, @Field("yemek_siparis_adet") int yemek_siparis_adet, @Field("kullanici_adi") String kullanici_adi);

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    Call<CartFoodAnswer> getCartFoods (@Field("kullanici_adi") String userName);

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    Call <CRUDAnswer> deleteFood (@Field("sepet_yemek_id") int id, @Field("kullanici_adi") String userName);



}
