package com.code.range.bookworm.data.network.dto


import com.google.gson.annotations.SerializedName

data class SaleInfo(
    @SerializedName("buyLink")
    val buyLink: String, // https://play.google.com/store/books/details?id=s1gVAAAAYAAJ&rdid=book-s1gVAAAAYAAJ&rdot=1&source=gbs_api
    @SerializedName("country")
    val country: String, // US
    @SerializedName("isEbook")
    val isEbook: Boolean, // true
    @SerializedName("saleability")
    val saleability: String // FREE
)