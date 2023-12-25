package com.code.range.bookworm.data.network.dto


import com.google.gson.annotations.SerializedName

data class Layer(
    @SerializedName("layerId")
    val layerId: String, // geo
    @SerializedName("volumeAnnotationsVersion")
    val volumeAnnotationsVersion: String // 20
)