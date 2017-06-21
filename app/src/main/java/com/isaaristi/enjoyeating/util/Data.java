package com.isaaristi.enjoyeating.util;

import com.isaaristi.enjoyeating.R;
import com.isaaristi.enjoyeating.modelos.Tipo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class Data {

    private static List<Tipo> tipo;
    private static List<Tipo> getTipo(){

        if(tipo == null){
            tipo = new ArrayList<>();

            Tipo t1 = new Tipo();
            t1.setNombre("Restaurante tradicional");
            t1.setImagen(R.drawable.dish);
            t1.setValor("tradicional");

            Tipo t2 = new Tipo();
            t2.setNombre("Restaurante tipico");
            t2.setImagen(R.drawable.saladlogo);
            t2.setValor("tipico");

            Tipo t3 = new Tipo();
            t3.setNombre("Comidas rapidas");
            t3.setImagen(R.drawable.sandwich);
            t3.setValor("rapidas");

            tipo.add(t1);
            tipo.add(t2);
            tipo.add(t3);
        }

        return tipo;
    }

}
