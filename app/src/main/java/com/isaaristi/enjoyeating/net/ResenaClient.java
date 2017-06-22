package com.isaaristi.enjoyeating.net;

import com.isaaristi.enjoyeating.modelos.Resena;
import com.isaaristi.enjoyeating.modelos.Restaurante;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ResenaClient {

    @GET("resena/{idRes}")
    Call<List<Resena>> all(@Path("idRes") String idRes);

    @POST ("resena")
    Call<List<Resena>> postear(@Body Resena resena);
}
