package com.code.range.bookworm.data.network.dto


import com.google.gson.annotations.SerializedName

data class AccessInfo(
    @SerializedName("accessViewStatus")
    val accessViewStatus: String, // FULL_PUBLIC_DOMAIN
    @SerializedName("country")
    val country: String, // US
    @SerializedName("embeddable")
    val embeddable: Boolean, // true
    @SerializedName("epub")
    val epub: Epub,
    @SerializedName("pdf")
    val pdf: Pdf,
    @SerializedName("publicDomain")
    val publicDomain: Boolean, // true
    @SerializedName("quoteSharingAllowed")
    val quoteSharingAllowed: Boolean, // false
    @SerializedName("textToSpeechPermission")
    val textToSpeechPermission: String, // ALLOWED
    @SerializedName("viewability")
    val viewability: String, // ALL_PAGES
    @SerializedName("webReaderLink")
    val webReaderLink: String // http://play.google.com/books/reader?id=s1gVAAAAYAAJ&hl=&source=gbs_api
)