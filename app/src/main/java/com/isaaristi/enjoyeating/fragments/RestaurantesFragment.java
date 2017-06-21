package com.isaaristi.enjoyeating.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaaristi.enjoyeating.R;
import com.isaaristi.enjoyeating.adapters.RestaurantesAdapter;
import com.isaaristi.enjoyeating.databinding.FragmentRestaurantesBinding;

import java.util.ArrayList;
import java.util.List;

public class RestaurantesFragment extends AppCompatActivity{

    FragmentRestaurantesBinding binding;
    TodosFragment fragment1 = new TodosFragment();

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_restaurantes);

        List<Fragment> pages = new ArrayList<>();
        pages.add(fragment1);

        RestaurantesAdapter adapter = new RestaurantesAdapter(getSupportFragmentManager(), pages);
        binding.pager1.setAdapter(adapter);

        setSupportActionBar(binding.toolbar);
        binding.tabs1.setupWithViewPager(binding.pager1);
    }


}
