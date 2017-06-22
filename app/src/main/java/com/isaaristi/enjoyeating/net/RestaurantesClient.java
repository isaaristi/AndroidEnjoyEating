package com.isaaristi.enjoyeating.net;

import com.isaaristi.enjoyeating.R;
import com.isaaristi.enjoyeating.modelos.Menu;
import com.isaaristi.enjoyeating.modelos.Restaurante;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestaurantesClient {

    @GET ("restaurante")
    Call<List<Restaurante>> all();

    @GET ("restaurante/all/menus")
    Call<List<Menu>> menus();

    @GET ("restaurante/{nombre}")
    Call<List<Restaurante>> nombre(@Path("nombre") String nombre);

    @GET ("restaurante/menu/{ingredientes}")
    Call<List<Restaurante>> ingredientes(@Path("ingredientes") String ingredientes);

}
