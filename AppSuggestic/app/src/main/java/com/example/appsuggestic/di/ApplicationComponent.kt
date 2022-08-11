package com.example.appsuggestic.di

import com.example.appsuggestic.di.modules.AppModule
import com.example.appsuggestic.di.modules.RepositoryModule
import com.example.appsuggestic.di.modules.ViewModelModule
import com.example.appsuggestic.ui.activity.HomeActivity
import dagger.Component

@Component(modules = [
    ViewModelModule::class,
    AppModule::class,
    RepositoryModule::class
])

interface ApplicationComponent {
    fun inject (target: HomeActivity)
}