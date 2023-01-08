package com.example.gestioncommerciale.retrofit;

import com.example.gestioncommerciale.models.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {


    @POST("/users")
    Call<ResponseBody> addUser(@Body User user);

    @GET("/users")
    Call<ResponseBody> getUser(@Body User user);

    @POST("/users/login")
    Call<ResponseBody> login(@Body User user);
}
