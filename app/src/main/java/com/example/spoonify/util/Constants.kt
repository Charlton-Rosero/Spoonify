package com.example.spoonify.util

import com.example.spoonify.BuildConfig

class Constants {

    companion object{
        const val BASE_URL = "https://api.spoonacular.com"
        const val API_KEY = BuildConfig.API_KEY.toString()

        //Queries
        const val QUERY_NUMBER = "50"
        const val QUERY_API_KEY= BuildConfig.API_KEY.toString()
        const val QUERY_TYPE = "type"
        const val QUERY_DIET = "diet"
        const val QUERY_ADD_RECIPE_INFO = "addRecipeInformation"
        const val QUERY_FILL_INGREDIENTS = "fillIngredients"

    }
}