package com.isaaristi.enjoyeating.net;

import com.isaaristi.enjoyeating.modelos.Guardar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GuardarClient {

    @GET("guardar/{idUs}")
    Call<List<Guardar>> all(@Path("idUs") String idUs);

    @POST ("guardar")
    Call<List<Guardar>> postear(@Body Guardar guardar);
}
