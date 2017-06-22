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
import com.isaaristi.enjoyeating.adapters.EstuveAdapter;
import com.isaaristi.enjoyeating.databinding.FragmentEstuveBinding;
import com.isaaristi.enjoyeating.modelos.Estuve;
import com.isaaristi.enjoyeating.net.EstuveClient;
import com.isaaristi.enjoyeating.util.Dato;
import com.isaaristi.enjoyeating.util.Preference;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class EstuveFragment extends Fragment {

    FragmentEstuveBinding binding;
    EstuveAdapter adapter;
    EstuveClient client;
    SharedPreferences preferences;

    public static EstuveFragment instance() {
        return new EstuveFragment();
    }

    public EstuveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_estuve, container, false);
        adapter = new EstuveAdapter(getLayoutInflater(null), new ArrayList<Estuve>(), this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        preferences = this.getActivity().getSharedPreferences(Preference.PREFERENCE_NAME, MODE_PRIVATE);

        client = App.retrofit.create(EstuveClient.class);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadEstuve();
    }

    private void loadEstuve() {
        String id = preferences.getString(Preference.KEY_USERNAME, "");
        Call<List<Estuve>> request = client.all(id);
        request.enqueue(new Callback<List<Estuve>>() {
            @Override
            public void onResponse(Call<List<Estuve>> call, Response<List<Estuve>> response) {
                if (response.isSuccessful()){
                    Dato.estuve = response.body();
                    adapter.setData(Dato.estuve);
                }
            }

            @Override
            public void onFailure(Call<List<Estuve>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
