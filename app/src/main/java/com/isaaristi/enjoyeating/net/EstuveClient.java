package com.isaaristi.enjoyeating.net;

import com.isaaristi.enjoyeating.modelos.Estuve;
import com.isaaristi.enjoyeating.modelos.Guardar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EstuveClient {

    @GET("estuve/{idUS}")
    Call<List<Estuve>> all(@Path("idUs") String idUS);

    @POST("estuve")
    Call<List<Guardar>> postear(@Body Estuve estuve);
}
