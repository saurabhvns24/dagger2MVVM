package com.example.dagger2withmvvm.di

import com.example.dagger2withmvvm.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,ViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}