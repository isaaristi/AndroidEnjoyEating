package com.isaaristi.enjoyeating;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.isaaristi.enjoyeating.databinding.ActivityMainBinding;
import com.isaaristi.enjoyeating.fragments.EstuveFragment;
import com.isaaristi.enjoyeating.fragments.GuardarFragment;
import com.isaaristi.enjoyeating.fragments.PlatosFragment;
import com.isaaristi.enjoyeating.fragments.TiposFragment;
import com.isaaristi.enjoyeating.fragments.TodosFragment;
import com.isaaristi.enjoyeating.util.Preference;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {

    ActivityMainBinding binding;
    ActionBarDrawerToggle toggle;
    int content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, binding.drawer, R.string.open_menu, R.string.close_menu);
        binding.drawer.addDrawerListener(this);
        binding.nav.setNavigationItemSelectedListener(this);

        content = R.id.nav_home;
        if(savedInstanceState != null){
            content = savedInstanceState.getInt("content");
        }

        setContent(content);
    }

    //region Toggle
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }
    //endregion

    public void putFragment (int container, Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(container, fragment);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        binding.drawer.closeDrawers();
        setContent(item.getItemId());
        return false;
    }

    void setContent(int navItem){
        content = navItem;
        switch(navItem){
            case R.id.nav_home:
                getSupportActionBar().setTitle("Todos los restaurantes");
                putFragment(R.id.container, TodosFragment.instance());
                break;
            case R.id.nav_tipos:
                getSupportActionBar().setTitle("Tipos de restaurantes");
                putFragment(R.id.container, TiposFragment.instance());
                break;
            case R.id.nav_platos:
                getSupportActionBar().setTitle("Todos los platos");
                putFragment(R.id.container, PlatosFragment.instance());
                break;
            case R.id.nav_guardar:
                getSupportActionBar().setTitle("Restaurantes que he guardado");
                putFragment(R.id.container, GuardarFragment.instance());
                break;
            case R.id.nav_estuve:
                getSupportActionBar().setTitle("Restaurantes en los que he estado");
                putFragment(R.id.container, EstuveFragment.instance());
                break;
            case R.id.nav_logout:
            SharedPreferences preferences = getSharedPreferences(Preference.PREFERENCE_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(Preference.KEY_LOGGED, false);
            editor.apply();

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("content", content);
        super.onSaveInstanceState(outState);
    }
}
