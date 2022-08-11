package com.example.appsuggestic.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Calendar (
    @SerializedName("title")
    @Expose
    var title: String,
    @SerializedName("subtitle")
    @Expose
    var subtitle : String,
    @SerializedName("day")
    @Expose
    var day : String,
    @SerializedName("text_day")
    @Expose
    var textDay : String
)