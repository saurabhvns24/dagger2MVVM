package com.example.dagger2withmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dagger2withmvvm.db.FakerDB
import com.example.dagger2withmvvm.model.ProductsItem
import com.example.dagger2withmvvm.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val fakerAPI: FakerAPI,
    private val fakerDB: FakerDB
) {
    private val products = MutableLiveData<List<ProductsItem>>()
    val productsItemList: LiveData<List<ProductsItem>>
        get() = products

    suspend fun getProducts() {
        val result = fakerAPI.getProduct()
        if (result.body() != null) {
            fakerDB.getFakerDao().addProducts(result.body()!!)
            products.postValue(result.body())
        }
    }

}