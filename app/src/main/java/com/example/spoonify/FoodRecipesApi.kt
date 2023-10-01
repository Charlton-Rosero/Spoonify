package com.example.spoonify

import com.example.spoonify.models.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap
import java.time.temporal.TemporalQueries

interface FoodRecipesApi {

    @GET("/recipes/complexSearch")
    fun getRecipes(
        @QueryMap queries: Map<String, String>
    ):Response<FoodRecipe>



}