package com.code.range.bookworm.data.network.dto


import com.google.gson.annotations.SerializedName

data class ReadingModes(
    @SerializedName("image")
    val image: Boolean, // true
    @SerializedName("text")
    val text: Boolean // true
)