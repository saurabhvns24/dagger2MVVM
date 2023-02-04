package com.example.dagger2withmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2withmvvm.repository.ProductRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val productRepository: ProductRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(productRepository) as T
    }
}