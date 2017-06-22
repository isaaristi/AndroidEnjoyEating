package com.isaaristi.enjoyeating.fragments;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaaristi.enjoyeating.App;
import com.isaaristi.enjoyeating.DetallesActivity;
import com.isaaristi.enjoyeating.R;
import com.isaaristi.enjoyeating.adapters.TodosAdapter;
import com.isaaristi.enjoyeating.databinding.FragmentTodosBinding;
import com.isaaristi.enjoyeating.modelos.Restaurante;
import com.isaaristi.enjoyeating.net.RestaurantesClient;
import com.isaaristi.enjoyeating.util.Dato;
import com.squareup.picasso.Downloader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodosFragment extends Fragment implements TodosAdapter.onRestauranteListener {

    public static TodosFragment instance() {
        return new TodosFragment();
    }

    FragmentTodosBinding binding;
    TodosAdapter adapter;
    RestaurantesClient client;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_todos, container, false);
        adapter = new TodosAdapter(getLayoutInflater(null), new ArrayList<Restaurante>(), this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        client = App.retrofit.create(RestaurantesClient.class);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadRestaurantes();
    }

    private void loadRestaurantes(){
        Call<List<Restaurante>> request = client.all();
        request.enqueue(new Callback<List<Restaurante>>(){

            @Override
            public void onResponse(Call<List<Restaurante>> call, Response<List<Restaurante>> response) {
                if(response.isSuccessful()) {
                    Dato.restaurante = response.body();
                    adapter.setData(Dato.restaurante);
                }
            }

            @Override
            public void onFailure(Call<List<Restaurante>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onRestauranteClick(int position) {
        Intent intent = new Intent(getActivity(), DetallesActivity.class);
        intent.putExtra("pos", position);
        startActivity(intent);
    }
}
