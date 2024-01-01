package com.example.spoonify.data

import android.app.DownloadManager.Query
import com.example.spoonify.data.network.FoodRecipesApi
import com.example.spoonify.models.FoodRecipe
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
) {

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }

    suspend fun searchRecipes(searchQuery: Map<String, String>): Response<FoodRecipe>{
        return  foodRecipesApi.searchRecipes(searchQuery)
    }
    
}