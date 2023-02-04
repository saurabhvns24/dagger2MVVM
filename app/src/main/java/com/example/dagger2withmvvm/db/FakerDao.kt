package com.example.dagger2withmvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dagger2withmvvm.model.ProductsItem

@Dao
interface FakerDao {
    @Insert
    suspend fun addProducts(productsItemList: List<ProductsItem>)

    @Query("Select * from product")
    suspend fun getProductFromDB(): List<ProductsItem>
}