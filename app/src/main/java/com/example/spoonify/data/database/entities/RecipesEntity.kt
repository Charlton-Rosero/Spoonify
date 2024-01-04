package com.example.spoonify.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.spoonify.models.FoodRecipe
import com.example.spoonify.util.Constants.Companion.RECIPES_TABLE


@Entity(tableName = RECIPES_TABLE)
class RecipesEntity (
    var foodRecipe: FoodRecipe
){
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0

}