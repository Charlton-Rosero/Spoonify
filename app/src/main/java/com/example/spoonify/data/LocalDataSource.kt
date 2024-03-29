package com.example.spoonify.data

import com.example.spoonify.data.database.RecipesDao
import com.example.spoonify.data.database.entities.FavouritesEntity
import com.example.spoonify.data.database.entities.RecipesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val recipesDao: RecipesDao

) {

    fun readRecipes(): Flow<List<RecipesEntity>>{
        return recipesDao.readRecipes()
    }
    

    fun readFavouriteRecipes(): Flow<List<FavouritesEntity>>{
        return recipesDao .readFavouriteRecipes()
    }

    suspend fun insertRecipes(recipesEntity: RecipesEntity){
        recipesDao.insertRecipes(recipesEntity)
    }

    suspend fun  insertFavouriteRecipes(favouritesEntity: FavouritesEntity){
        recipesDao.insertFavouriteRecipe(favouritesEntity)
    }

    suspend fun deleteFavouriteRecipe(favouritesEntity: FavouritesEntity){
        recipesDao.deleteFavouriteRecipe(favouritesEntity)
    }

    suspend fun deleteAllFavouriteRecipes(){
        recipesDao.deleteAllFavouriteRecipes()
    }


}