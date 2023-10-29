package com.example.apifetchget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.hardware.biometrics.BiometricPrompt;
//import androidx.biometric.BiometricManager;


//import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
  private ArrayList<Post> listpost;
  RecyclerView recycle;
    Retrofit retrofit;
  MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listpost = new ArrayList<>();
      // adapter = new MyAdapter(this,listpost);
       // recycle.setAdapter(adapter);
        recycle= findViewById(R.id.recycleview);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setHasFixedSize(true);

        retrofit = new Retrofit.Builder().
                baseUrl("https://jsonplaceholder.typicode.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonApi jsonapi =retrofit.create(JsonApi.class);
        Call<List<Post>> call = jsonapi.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    // Handle successful response
                    List<Post> apiResponsePost = response.body();
                    adapter = new MyAdapter(MainActivity.this,apiResponsePost);
                    recycle.setAdapter(adapter);

                    // Do something with the data
                } else {
                    // Handle unsuccessful response
                    Toast.makeText(MainActivity.this, "no contact exist", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                // Handle API call failure
                // ...
            }   });

    }
  /*  private void showBiometricPrompt() {
        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Authenticate with your fingerprint")
                .setNegativeButtonText("Cancel")
                .build();

        BiometricPrompt biometricPrompt = new BiometricPrompt(this, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                // Handle authentication success
            }

            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                // Handle authentication error
            }
        });

        biometricPrompt.authenticate(promptInfo);
    }*/
}
