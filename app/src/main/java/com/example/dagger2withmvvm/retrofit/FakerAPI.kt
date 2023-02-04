package com.example.dagger2withmvvm.retrofit

import com.example.dagger2withmvvm.model.ProductsItem
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {
    @GET("/products")
    suspend fun getProduct() :Response<List<ProductsItem>>
}