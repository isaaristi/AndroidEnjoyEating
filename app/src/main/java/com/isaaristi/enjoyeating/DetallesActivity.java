package com.isaaristi.enjoyeating;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.isaaristi.enjoyeating.databinding.ActivityDetallesBinding;
import com.isaaristi.enjoyeating.modelos.Restaurante;
import com.isaaristi.enjoyeating.util.Data;
import com.isaaristi.enjoyeating.util.Dato;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DetallesActivity extends AppCompatActivity implements Callback {

    ActivityDetallesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detalles);

        int pos = getIntent().getExtras().getInt("pos");
        Restaurante restaurante = Dato.restaurante.get(pos);

        binding.setRestaurante(restaurante);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }
}
