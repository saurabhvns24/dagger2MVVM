package com.example.dagger2withmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2withmvvm.R
import com.example.dagger2withmvvm.application.FakerApplication
import com.example.dagger2withmvvm.viewmodel.MainViewModel
import com.example.dagger2withmvvm.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val productData: TextView
        get() = findViewById(R.id.productData)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as FakerApplication).applicationComponent.inject(this)
        val map = (application as FakerApplication).applicationComponent.getMap()
//        mainViewModel = map["mainViewModel"] as MainViewModel
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productsLiveData.observe(this, Observer {
            productData.text = it.joinToString { x ->
                x.title + " \n\n"
            }
        })
    }
}