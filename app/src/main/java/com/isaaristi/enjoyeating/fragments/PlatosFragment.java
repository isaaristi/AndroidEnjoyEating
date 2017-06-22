package com.isaaristi.enjoyeating.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaaristi.enjoyeating.App;
import com.isaaristi.enjoyeating.R;
import com.isaaristi.enjoyeating.adapters.PlatosAdapter;
import com.isaaristi.enjoyeating.databinding.FragmentPlatosBinding;
import com.isaaristi.enjoyeating.modelos.Menu;
import com.isaaristi.enjoyeating.modelos.Restaurante;
import com.isaaristi.enjoyeating.net.RestaurantesClient;
import com.isaaristi.enjoyeating.util.Dato;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlatosFragment extends Fragment implements PlatosAdapter.onPlatosListener{

    FragmentPlatosBinding binding;
    PlatosAdapter adapter;
    RestaurantesClient client;

    public static PlatosFragment instance() {
        return new PlatosFragment();
    }

    public PlatosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_platos, container, false);
        adapter = new PlatosAdapter(getLayoutInflater(null), new ArrayList<Menu>(), this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        client = App.retrofit.create(RestaurantesClient.class);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadPlatos();
    }

    private void loadPlatos() {
        Call<List<Menu>> request = client.menus();
        request.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                if (response.isSuccessful()){
                    Dato.menu = response.body();
                    adapter.setData(Dato.menu);
                }
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onPlatosClick(int position) {

    }
}
