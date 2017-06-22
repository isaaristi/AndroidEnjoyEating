package com.isaaristi.enjoyeating;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.databinding.DataBindingUtil;
import android.widget.Toast;

import com.isaaristi.enjoyeating.databinding.ActivityRegistroBinding;
import com.isaaristi.enjoyeating.modelos.Users;
import com.isaaristi.enjoyeating.net.RegistroResponse;
import com.isaaristi.enjoyeating.net.UsersClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements Callback<RegistroResponse> {

    ActivityRegistroBinding binding;
    UsersClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_registro);
        binding.setHandler(this);
        client = ((App)getApplication()).retrofit.create(UsersClient.class);
    }

    public void principal () {
        String usern = binding.username.getText().toString();
        String correo = binding.correo.getText().toString();
        String pass= binding.password.getText().toString();

        Users user = new Users(usern, correo, pass);

        Call<RegistroResponse> request = client.registrar(user);
        request.enqueue(this);
    }

    @Override
    public void onResponse(Call<RegistroResponse> call, Response<RegistroResponse> response) {
        if (response.isSuccessful()) {

            RegistroResponse registroResponse = response.body();
            if (registroResponse.isSuccess()){
                Toast.makeText(this, R.string.register_success, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }else if (registroResponse.isExists()){
                Toast.makeText(this, R.string.register_exist, Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, R.string.register_exist, Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, R.string.error_register, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<RegistroResponse> call, Throwable t) {
        Toast.makeText(this, R.string.register_error, Toast.LENGTH_SHORT).show();
    }
}
