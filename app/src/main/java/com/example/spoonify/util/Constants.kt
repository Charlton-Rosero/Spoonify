package com.example.spoonify.util

import com.example.spoonify.BuildConfig

class Constants {

    companion object{
        const val BASE_URL = "https://api.spoonacular.com"
       const val API_KEY = BuildConfig.API_KEY.toString()
    }
}