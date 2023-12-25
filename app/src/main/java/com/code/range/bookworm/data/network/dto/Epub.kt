package com.code.range.bookworm.data.network.dto


import com.google.gson.annotations.SerializedName

data class Epub(
    @SerializedName("downloadLink")
    val downloadLink: String, // http://books.google.com/books/download/Pride_and_Prejudice.epub?id=s1gVAAAAYAAJ&hl=&output=epub&source=gbs_api
    @SerializedName("isAvailable")
    val isAvailable: Boolean // true
)