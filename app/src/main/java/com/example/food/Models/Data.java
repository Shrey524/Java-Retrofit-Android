package com.example.food.Models;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("strMeal")
    private String strMeal;

    @SerializedName("strCategory")
    private String strCategory;

    @SerializedName("strInstructions")
    private String strInstructions;

    @SerializedName("strMealThumb")
    private String strMealThumb;

    public String getStrMealThumb(){
        return strMealThumb;
    }
    public void setStrMealThumb(String StrMealThumb) { this.strMealThumb = StrMealThumb; }

    public String getStrMeal(){
        return strMeal;
    }
    public void setStrMeal(String strMeal) { this.strMeal = strMeal; }

    public String getStrCategory(){
        return strCategory;
    }
    public void setStrCategory(String strCategory) { this.strCategory = strCategory; }

    public String getStrInstructions(){
        return strInstructions;
    }
    public void setStrInstructions(String StrInstructions) { this.strInstructions = StrInstructions; }
}
