package com.example.android.pruebassi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView usersRecyclerView;
    private ListUserAdapter listUserAdapter;
    private ArrayList<User> usersList;

    private String baseUrl;
    private Retrofit retrofit;
    private ApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseUrl = "https://jsonplaceholder.typicode.com/";

        retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        service = retrofit.create(ApiService.class);

        //service.getAllUsers().enqueue(new Callback<List<User>>() {
            //@Override
            //public void onResponse(Call<ArrayList<User>> call, Response<List<User>> response) {
                //usersList = response.body();
            //}

            //@Override
            //public void onFailure(Call<List<User>> call, Throwable t) {
                //Log.e("Error:","Carga Fallida");
            //}
        //});

        usersList = new ArrayList<>();

        usersList.add(new User("Andres","1234"));
        usersList.add(new User("Lorena", "456"));
        usersList.add(new User("Pedro","1234"));
        usersList.add(new User("Jairo", "456"));

        usersRecyclerView = findViewById(R.id.users_recycler_view);
        usersRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        listUserAdapter = new ListUserAdapter(usersList);

        usersRecyclerView.setAdapter(listUserAdapter);
    }
}
