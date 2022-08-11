package com.example.appsuggestic.data.repository

import android.content.Context
import com.example.appsuggestic.data.dataSource.LocalJSONReader
import com.example.appsuggestic.domain.Calendar
import io.reactivex.Observable
import org.json.JSONArray

class CalendarRepository(context: Context) : ICalendarRepository {

    private var localJSONReader = LocalJSONReader(context)

    override fun getCalendar(): Observable<ArrayList<Calendar>> {
        val obj = JSONArray(localJSONReader.loadJSONFromAsset("data.json"))
        var result : ArrayList<Calendar> = ArrayList()
        for (i in 0 until obj.length()) {
            val dayCalendar = obj.getJSONObject(i)
            val calendar = Calendar(
                dayCalendar.getString("title"),
                dayCalendar.getString("subtitle"),
                dayCalendar.getString("day"),
                dayCalendar.getString("text_day")
            )
            result.add(calendar)
        }
        return Observable.just(result)
    }
}