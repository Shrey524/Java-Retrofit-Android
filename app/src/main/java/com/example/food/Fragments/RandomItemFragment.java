package com.example.food.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.food.Activities.MainActivity;
import com.example.food.Models.Data;
import com.example.food.Network.Client;
import com.example.food.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RandomItemFragment extends Fragment {

    public RandomItemFragment() {}

    public static RandomItemFragment newInstance() {
        RandomItemFragment fragment = new RandomItemFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Initializing views
        try{
            View view = inflater.inflate(R.layout.fragment_random_item, container, false);
            ImageView dish = view.findViewById(R.id.DishPhoto);
            TextView name = view.findViewById(R.id.dish_name);
            TextView category = view.findViewById(R.id.dish_category);
            TextView instruction = view.findViewById(R.id.instructions);
            ImageView bookmark = view.findViewById(R.id.bookmark);

            // Retrofit
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.themealdb.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Client client = retrofit.create(Client.class);
            Data data = ((MainActivity)getActivity()).RandomDish(client);

            //Setting data
            if(data.getStrMealThumb()!=null){
                Glide.with(this).load(data.getStrMealThumb()).into(dish);
            }
            name.setText(data.getStrMeal());
            category.setText(data.getStrCategory());
            instruction.setText(data.getStrInstructions());

            //Saving recipes
            bookmark.setOnClickListener(new View.OnClickListener() {
                Integer count = 0;
                @Override
                public void onClick(View v) {
                    count+=1;
                    if(count%2==0){
                        ((MainActivity)getActivity()).RemoveDishes(data);
                        Toast.makeText(requireContext(),"Recipe Removed form list",Toast.LENGTH_SHORT).show();
                    }else {
                        ((MainActivity)getActivity()).SaveDishes(data);
                        Toast.makeText(requireContext(),"Recipe Saved",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            return view;
        }catch (Exception e){
            Log.d("Fuck",e.toString());
        }
        return getView();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}