package com.isaaristi.enjoyeating.fragments;


import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaaristi.enjoyeating.App;
import com.isaaristi.enjoyeating.R;
import com.isaaristi.enjoyeating.adapters.GuardarAdapter;
import com.isaaristi.enjoyeating.databinding.FragmentGuardarBinding;
import com.isaaristi.enjoyeating.modelos.Guardar;
import com.isaaristi.enjoyeating.net.GuardarClient;
import com.isaaristi.enjoyeating.util.Dato;
import com.isaaristi.enjoyeating.util.Preference;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class GuardarFragment extends Fragment {

    FragmentGuardarBinding binding;
    GuardarAdapter adapter;
    GuardarClient client;
    SharedPreferences preferences;

    public static GuardarFragment instance() {
        return new GuardarFragment();
    }

    public GuardarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_guardar, container, false);
        adapter = new GuardarAdapter(getLayoutInflater(null), new ArrayList<Guardar>(), this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        preferences = this.getActivity().getSharedPreferences(Preference.PREFERENCE_NAME, MODE_PRIVATE);

        client = App.retrofit.create(GuardarClient.class);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadGuardar();
    }

    private void loadGuardar() {

        String id = preferences.getString(Preference.KEY_USERNAME, "");
        Call<List<Guardar>> request = client.all(id);
        request.enqueue(new Callback<List<Guardar>>() {
            @Override
            public void onResponse(Call<List<Guardar>> call, Response<List<Guardar>> response) {
                if (response.isSuccessful()){
                    Dato.guardar = response.body();
                    adapter.setData(Dato.guardar);
                }
            }

            @Override
            public void onFailure(Call<List<Guardar>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
