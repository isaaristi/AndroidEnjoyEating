package com.isaaristi.enjoyeating.net;

import com.isaaristi.enjoyeating.modelos.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsersClient {

    @POST("users/signin")
    Call<RegistroResponse> registrar(@Body Users user);

    @POST("users/login")
    Call<SimpleResponse> login (@Body Users user);
}
