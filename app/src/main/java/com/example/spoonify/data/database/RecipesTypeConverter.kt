package com.example.spoonify.data.database

import androidx.room.TypeConverter
import com.example.spoonify.models.FoodRecipe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecipesTypeConverter {


    @TypeConverter
    fun foodRecipeToString(foodRecipe: FoodRecipe):String{
        return Gson().toJson(foodRecipe)
    }
    @TypeConverter
    fun stringToFoodRecipe(data:String): FoodRecipe{
        val listType = object : TypeToken<FoodRecipe>() {}.type
        return Gson().fromJson(data, listType)
    }




}