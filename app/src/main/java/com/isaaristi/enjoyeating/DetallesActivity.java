package com.isaaristi.enjoyeating;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.isaaristi.enjoyeating.databinding.ActivityDetallesBinding;
import com.isaaristi.enjoyeating.modelos.Estuve;
import com.isaaristi.enjoyeating.modelos.Guardar;
import com.isaaristi.enjoyeating.modelos.Menu;
import com.isaaristi.enjoyeating.modelos.Restaurante;
import com.isaaristi.enjoyeating.net.GuardarClient;
import com.isaaristi.enjoyeating.net.RegistroResponse;
import com.isaaristi.enjoyeating.net.SimpleResponse;
import com.isaaristi.enjoyeating.net.UsersClient;
import com.isaaristi.enjoyeating.util.Data;
import com.isaaristi.enjoyeating.util.Dato;
import com.isaaristi.enjoyeating.util.Preference;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static android.app.PendingIntent.getActivity;
import static com.isaaristi.enjoyeating.BR.restaurante;
import static com.isaaristi.enjoyeating.util.Preference.KEY_USERNAME;

public class DetallesActivity extends AppCompatActivity implements retrofit2.Callback<SimpleResponse> {

    ActivityDetallesBinding binding;
    SharedPreferences preferences;
    GuardarClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detalles);

        int pos = getIntent().getExtras().getInt("pos");
        Restaurante restaurante = Dato.restaurante.get(pos);
        preferences = getSharedPreferences(Preference.PREFERENCE_NAME, MODE_PRIVATE);
        binding.setHandler(this);
        client = ((App) getApplication()).retrofit.create(GuardarClient.class);
        binding.setRestaurante(restaurante);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void guardar() {
        final int pos = getIntent().getExtras().getInt("pos");
        final Restaurante restaurante = Dato.restaurante.get(pos);
        String imagen = restaurante.getImagen();
        String placeid = restaurante.getPlaceid();
        String nombre = restaurante.getNombre();

        String id = preferences.getString(Preference.KEY_USERNAME,"");

        Guardar guardar = new Guardar (id, imagen, placeid, nombre);

        Call<List<Guardar>> request = client.postear(guardar);
        request.enqueue(new retrofit2.Callback<List<Guardar>>() {
            @Override
            public void onResponse(Call<List<Guardar>> call, Response<List<Guardar>> response) {
                if (response.isSuccessful()){
                    Toast.makeText(DetallesActivity.this, getString(R.string.bueno), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DetallesActivity.this, getString(R.string.malo), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Guardar>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
        if (response.isSuccessful()) {

            SimpleResponse simpleResponse = response.body();
            if (simpleResponse.isSuccess()){
                Toast.makeText(this, R.string.guardarbien, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(this, R.string.guardarmal, Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, R.string.guardarerror, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<SimpleResponse> call, Throwable t) {
        Toast.makeText(this, R.string.erorrrr, Toast.LENGTH_SHORT).show();
    }
}
