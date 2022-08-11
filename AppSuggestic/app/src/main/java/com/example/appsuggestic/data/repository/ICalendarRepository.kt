package com.example.appsuggestic.data.repository

import com.example.appsuggestic.domain.Calendar
import io.reactivex.Observable

interface ICalendarRepository {
    fun getCalendar() : Observable<ArrayList<Calendar>>
}