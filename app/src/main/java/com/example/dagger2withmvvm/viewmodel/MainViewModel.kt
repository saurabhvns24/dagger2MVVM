package com.example.dagger2withmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger2withmvvm.model.ProductsItem
import com.example.dagger2withmvvm.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val productRepository: ProductRepository) : ViewModel() {
    val productsLiveData: LiveData<List<ProductsItem>>
        get() = productRepository.productsItemList

    init {
        viewModelScope.launch {
            productRepository.getProducts()
        }
    }
}