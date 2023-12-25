package com.code.range.bookworm.data.network.dto


import com.google.gson.annotations.SerializedName

data class LayerInfo(
    @SerializedName("layers")
    val layers: List<Layer>
)