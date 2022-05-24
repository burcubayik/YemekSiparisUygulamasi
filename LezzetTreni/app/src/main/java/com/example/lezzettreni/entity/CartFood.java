package com.example.lezzettreni.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CartFood implements Serializable {
    @SerializedName("sepet_yemek_id")
    @Expose
    private int sepet_yemek_id;
    @SerializedName("yemek_adi")
    @Expose
    private String yemek_adi;
    @SerializedName("yemek_resim_adi")
    @Expose
    private String yemek_resim_adi;
    @SerializedName("yemek_fiyat")
    @Expose
    private int yemek_fiyat;
    @SerializedName("yemek_siparis_adet")
    @Expose
    private int yemek_siparis_adet;
    @SerializedName("kullanici_adi")
    @Expose
    private String kullanici_adi;

    public CartFood()  {
    }

    public CartFood(int sepet_yemek_id, String yemek_adi, String yemek_resim_adi, int yemek_fiyat, int yemek_siparis_adet, String kullanici_adi) {
        this.sepet_yemek_id = sepet_yemek_id;
        this.yemek_adi = yemek_adi;
        this.yemek_resim_adi = yemek_resim_adi;
        this.yemek_fiyat = yemek_fiyat;
        this.yemek_siparis_adet = yemek_siparis_adet;
        this.kullanici_adi = kullanici_adi;
    }

    public int getSepet_yemek_id() {
        return sepet_yemek_id;
    }

    public void setSepet_yemek_id(int sepet_yemek_id) {
        this.sepet_yemek_id = sepet_yemek_id;
    }

    public String getYemek_adi() {
        return yemek_adi;
    }

    public void setYemek_adi(String yemek_adi) {
        this.yemek_adi = yemek_adi;
    }

    public String getYemek_resim_adi() {
        return yemek_resim_adi;
    }

    public void setYemek_resim_adi(String yemek_resim_adi) {
        this.yemek_resim_adi = yemek_resim_adi;
    }

    public int getYemek_fiyat() {
        return yemek_fiyat;
    }

    public void setYemek_fiyat(int yemek_fiyat) {
        this.yemek_fiyat = yemek_fiyat;
    }

    public int getYemek_siparis_adet() {
        return yemek_siparis_adet;
    }

    public void setYemek_siparis_adet(int yemek_siparis_adet) {
        this.yemek_siparis_adet = yemek_siparis_adet;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }
}
