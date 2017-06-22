package com.isaaristi.enjoyeating;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.isaaristi.enjoyeating.databinding.ActivityLoginBinding;
import com.isaaristi.enjoyeating.modelos.Users;
import com.isaaristi.enjoyeating.net.SimpleResponse;
import com.isaaristi.enjoyeating.net.UsersClient;
import com.isaaristi.enjoyeating.util.Preference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements Callback<SimpleResponse> {

    ActivityLoginBinding binding;
    SharedPreferences preferences;
    UsersClient client;

    @Override
    protected void onCreate (Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);

        preferences = getSharedPreferences(Preference.PREFERENCE_NAME, MODE_PRIVATE);
        boolean logged = preferences.getBoolean(Preference.KEY_LOGGED, false);
        if (logged) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return;
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setHandler(this);
        client = ((App) getApplication()).retrofit.create(UsersClient.class);

    }

    public void registrar() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    public void goToMain() {
        String username = binding.username.getText().toString();
        String password = binding.password.getText().toString();

        if ((username.equals("")) || (password.equals(""))) {
            Toast.makeText(this, R.string.vacio, Toast.LENGTH_SHORT).show();
        }
        else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(Preference.KEY_USERNAME, username);
            editor.putBoolean(Preference.KEY_LOGGED, true);
            editor.apply();

            Users user = new Users(username, password);

            Call<SimpleResponse> request = client.login(user);
            request.enqueue(this);
        }
    }


    @Override
    public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
        if (response.isSuccessful()) {
            SimpleResponse simpleResponse = response.body();
            if (simpleResponse.isSuccess()) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, R.string.error_login, Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, R.string.login_error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<SimpleResponse> call, Throwable t) {
        Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
    }
}
