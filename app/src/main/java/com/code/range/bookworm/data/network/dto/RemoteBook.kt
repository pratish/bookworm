package com.code.range.bookworm.data.network.dto


import com.google.gson.annotations.SerializedName

data class RemoteBook(
    @SerializedName("accessInfo")
    val accessInfo: AccessInfo,
    @SerializedName("etag")
    val etag: String, // 3SQiWFM/sw0
    @SerializedName("id")
    val id: String, // s1gVAAAAYAAJ
    @SerializedName("kind")
    val kind: String, // books#volume
    @SerializedName("layerInfo")
    val layerInfo: LayerInfo,
    @SerializedName("saleInfo")
    val saleInfo: SaleInfo,
    @SerializedName("selfLink")
    val selfLink: String, // https://www.googleapis.com/books/v1/volumes/s1gVAAAAYAAJ
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo
)