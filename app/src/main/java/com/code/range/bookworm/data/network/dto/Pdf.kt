package com.code.range.bookworm.data.network.dto


import com.google.gson.annotations.SerializedName

data class Pdf(
    @SerializedName("downloadLink")
    val downloadLink: String, // http://books.google.com/books/download/Pride_and_Prejudice.pdf?id=s1gVAAAAYAAJ&hl=&output=pdf&sig=ACfU3U3dQw5JDWdbVgk2VRHyDjVMT4oIaA&source=gbs_api
    @SerializedName("isAvailable")
    val isAvailable: Boolean // true
)