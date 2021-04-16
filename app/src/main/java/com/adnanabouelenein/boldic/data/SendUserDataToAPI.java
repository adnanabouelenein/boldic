package com.adnanabouelenein.boldic.data;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SendUserDataToAPI extends AppCompatActivity {

    public void sendData(String name, String phone, String email,
                         String password, Context context) {

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://student.valuxapps.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Callable callable = retrofit.create(Callable.class);


        Call<CreateAccountModel> createAccountCall = callable.registerUrl(name, phone, email, password);

        createAccountCall.enqueue(new Callback<CreateAccountModel>() {
            @Override
            public void onResponse(Call<CreateAccountModel> call,
                                   Response<CreateAccountModel> response) {
                Toast.makeText(context, "You have been Registered", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<CreateAccountModel> call, Throwable t) {

                Toast.makeText(context, "Check Your Internet Connection", Toast.LENGTH_LONG).show();
            }
        });
    }
}
