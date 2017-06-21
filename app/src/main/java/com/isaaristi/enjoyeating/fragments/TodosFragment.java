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
import com.isaaristi.enjoyeating.adapters.TodosAdapter;
import com.isaaristi.enjoyeating.databinding.FragmentTodosBinding;
import com.isaaristi.enjoyeating.modelos.Restaurante;
import com.isaaristi.enjoyeating.net.RestaurantesClient;

import java.util.ArrayList;

public class TodosFragment extends Fragment {

    FragmentTodosBinding binding;
    TodosAdapter adapter;
    RestaurantesClient client;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_todos, container, false);
        adapter = new TodosAdapter(getLayoutInflater(null), new ArrayList<Restaurante>());
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        client = App.retrofit.create(RestaurantesClient.class);

        return binding.getRoot();
    }

}
