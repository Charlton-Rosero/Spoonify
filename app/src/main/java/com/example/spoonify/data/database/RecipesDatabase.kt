package com.example.spoonify.data.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.spoonify.data.database.entities.FavouritesEntity
import com.example.spoonify.data.database.entities.RecipesEntity


@Database(
    entities = [RecipesEntity::class, FavouritesEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(RecipesTypeConverter::class)
abstract class RecipesDatabase: RoomDatabase() {

    abstract fun recipesDao(): RecipesDao
}