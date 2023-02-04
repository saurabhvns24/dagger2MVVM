package com.example.dagger2withmvvm.application

import android.app.Application
import com.example.dagger2withmvvm.di.ApplicationComponent
import com.example.dagger2withmvvm.di.DaggerApplicationComponent

class FakerApplication :Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()

    }
}