package com.example.food.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.BottomNavigationViewKt;

import com.example.food.Models.Data;
import com.example.food.Models.MealsItem;
import com.example.food.Network.Client;
import com.example.food.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private NavController navController;
    private NavHostFragment navHostFragment;
    private BottomNavigationView bottomNavigationView;
    public ArrayList<Data> list;
    public Data RandomData;
    public Data Result;
    public ArrayList<Data> saved_list = new ArrayList<Data>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.hide();

        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        navController = navHostFragment.getNavController();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        BottomNavigationViewKt.setupWithNavController(bottomNavigationView, navController);


    }
    public Data RandomDish(Client client){
        Call<com.example.food.Models.Response> call = client.getResponse();
        call.enqueue(new Callback<com.example.food.Models.Response>() {
            @Override
            public void onResponse(Call<com.example.food.Models.Response> call, Response<com.example.food.Models.Response> response) {
                com.example.food.Models.Response response1 = response.body();
                list = CreateList(response1);
                RandomData = list.get(0);
                Log.i("retrofit", "working");
            }

            @Override
            public void onFailure(Call<com.example.food.Models.Response> call, Throwable t) {
                Log.i("retrofit",t.toString());
            }
        });
        return RandomData;
    }

    public Data Search(Client client){
        Call<com.example.food.Models.Response> call = client.getSearchResult();
        call.enqueue(new Callback<com.example.food.Models.Response>() {
            @Override
            public void onResponse(Call<com.example.food.Models.Response> call, Response<com.example.food.Models.Response> response) {
                com.example.food.Models.Response response1 = response.body();
                list = CreateList(response1);
                Result = list.get(0);
                Log.i("search_retrofit", "working");
            }

            @Override
            public void onFailure(Call<com.example.food.Models.Response> call, Throwable t) {
                Log.i("search_retrofit",t.toString());
            }
        });
        return Result;
    }

    public ArrayList<Data> CreateList(com.example.food.Models.Response response1) {
        ArrayList<Data> list = new ArrayList<Data>();
        ArrayList<MealsItem> meal = (ArrayList<MealsItem>) response1.getMeals();
        MealsItem meal1 = meal.get(0);
        Data data = new Data();
        data.setStrCategory(meal1.getStrCategory());
        data.setStrInstructions(meal1.getStrInstructions());
        data.setStrMeal(meal1.getStrMeal());
        data.setStrMealThumb(meal1.getStrMealThumb());
        list.add(data);
        return list;
    }

    public void SaveDishes(Data data){
        saved_list.add(data);
        Log.i("Fuck1","fuck you");
    }

    public void RemoveDishes(Data data){
        saved_list.remove(data);
        Log.i("Fuck1","fuck you too");
    }
}