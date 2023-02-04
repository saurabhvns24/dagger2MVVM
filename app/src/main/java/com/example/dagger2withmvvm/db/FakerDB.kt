package com.example.dagger2withmvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dagger2withmvvm.model.ProductsItem

@Database(entities = [ProductsItem::class], version = 1)
abstract class FakerDB : RoomDatabase() {
    abstract fun getFakerDao(): FakerDao

}