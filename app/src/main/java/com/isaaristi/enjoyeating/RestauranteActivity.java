package com.isaaristi.enjoyeating;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.isaaristi.enjoyeating.adapters.RestaurantesAdapter;
import com.isaaristi.enjoyeating.databinding.ActivityRestauranteBinding;
import com.isaaristi.enjoyeating.databinding.FragmentRestaurantesBinding;
import com.isaaristi.enjoyeating.fragments.TodosFragment;

import java.util.ArrayList;
import java.util.List;

public class RestauranteActivity extends AppCompatActivity {

    ActivityRestauranteBinding binding;
    TodosFragment fragment1 = new TodosFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
