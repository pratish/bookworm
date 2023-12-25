package com.code.range.bookworm.data.network.dto

import com.google.gson.annotations.SerializedName

data class RemoteBookList(
    @SerializedName("kind") val kind: String,
    @SerializedName("totalItems") val totalItems: Int,
    @SerializedName("items") val items: List<RemoteBook>
)
