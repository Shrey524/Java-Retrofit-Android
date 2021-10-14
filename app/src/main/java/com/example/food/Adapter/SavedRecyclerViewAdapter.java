package com.example.food.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food.Models.Data;
import com.example.food.R;

import java.util.ArrayList;

public class SavedRecyclerViewAdapter extends RecyclerView.Adapter<SavedRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Data> saved_list = new ArrayList<Data>();
    private Context context;

    public SavedRecyclerViewAdapter(ArrayList<Data> saved_list, Context context){
        this.saved_list = saved_list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.fragment_saved_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SavedRecyclerViewAdapter.ViewHolder holder, int position) {
        final Data data = saved_list.get(position);
        holder.name.setText(data.getStrMeal());
        holder.category.setText(data.getStrCategory());
        holder.instruction.setText(data.getStrInstructions());
        Glide.with(context).load(data.getStrMealThumb()).into(holder.Dish);
    }

    @Override
    public int getItemCount() {
        return saved_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView Dish;
        public TextView name;
        public TextView category;
        public TextView instruction;
        public ViewHolder(View itemView) {
            super(itemView);
            this.Dish = (ImageView) itemView.findViewById(R.id.DishPhoto);
            this.name = (TextView) itemView.findViewById(R.id.dish_name);
            this.category = (TextView) itemView.findViewById(R.id.dish_category);
            this.instruction = (TextView) itemView.findViewById(R.id.instructions);
        }
    }
}