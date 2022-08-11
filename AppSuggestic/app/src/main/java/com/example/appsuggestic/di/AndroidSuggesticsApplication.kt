package com.example.appsuggestic.di

import android.app.Application
import com.example.appsuggestic.di.modules.AppModule
import com.example.appsuggestic.di.modules.RepositoryModule

class AndroidSuggesticsApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .repositoryModule(RepositoryModule())
            .build()
    }

    fun getComponent() = applicationComponent
}