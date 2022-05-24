package com.example.lezzettreni.retrofit;

public class ApiUtils {
    public static final String BASE_URL = "http://kasimadalan.pe.hu/";
    public static FoodsDaoInterface getFoodsDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(FoodsDaoInterface.class);
    }

}
