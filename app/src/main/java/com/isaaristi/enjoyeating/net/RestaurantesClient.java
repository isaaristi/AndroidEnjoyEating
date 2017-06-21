package com.isaaristi.enjoyeating.net;

import com.isaaristi.enjoyeating.modelos.Restaurante;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Isabel on 19/06/17.
 */

public interface RestaurantesClient {

    @GET ("restaurante")
    Call<List<Restaurante>> all();

}
