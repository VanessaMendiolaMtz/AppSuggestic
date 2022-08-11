package com.example.appsuggestic.data.dataSource

import android.content.Context
import java.io.IOException
import java.nio.charset.StandardCharsets

class LocalJSONReader(var context: Context) {

    @Throws(IOException::class)
    fun loadJSONFromAsset(fileName: String?): String? {
        val inputStream = context!!.assets.open(fileName!!)
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        inputStream.close()
        return String(buffer, StandardCharsets.UTF_8)
    }
}