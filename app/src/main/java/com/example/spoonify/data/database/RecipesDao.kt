package com.example.spoonify.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spoonify.data.database.entities.FavouritesEntity
import com.example.spoonify.data.database.entities.RecipesEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface RecipesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipesEntity: RecipesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavouriteRecipe(favouritesEntity: FavouritesEntity)

    @Query("SELECT * FROM recipes_table ORDER BY id ASC")
    fun readRecipes(): Flow<List<RecipesEntity>>


    @Query("SELECT * FROM favourite_recipes_table ORDER BY id ASC")
    fun readFavouriteRecipes(): Flow<List<FavouritesEntity>>


    @Delete
    suspend fun  deleteFavouriteRecipe(favouritesEntity: FavouritesEntity)

    @Query("DELETE FROM favourite_recipes_table")
    suspend fun  deleteAllFavouriteRecipes()

}