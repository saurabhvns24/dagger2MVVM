package com.example.dagger2withmvvm.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.dagger2withmvvm.view.MainActivity
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DBModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun getMap(): Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}