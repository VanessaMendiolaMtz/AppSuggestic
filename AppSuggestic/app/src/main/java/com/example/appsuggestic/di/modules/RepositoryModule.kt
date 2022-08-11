package com.example.appsuggestic.di.modules

import android.content.Context
import com.example.appsuggestic.data.repository.CalendarRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun getCalendar(context: Context) = CalendarRepository(context)
}