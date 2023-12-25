package com.code.range.bookworm.data.network.dto


import com.google.gson.annotations.SerializedName

data class VolumeInfo(
    @SerializedName("allowAnonLogging")
    val allowAnonLogging: Boolean, // false
    @SerializedName("authors")
    val authors: List<String>,
    @SerializedName("averageRating")
    val averageRating: Int, // 4
    @SerializedName("canonicalVolumeLink")
    val canonicalVolumeLink: String, // https://play.google.com/store/books/details?id=s1gVAAAAYAAJ
    @SerializedName("contentVersion")
    val contentVersion: String, // 1.4.12.0.full.3
    @SerializedName("description")
    val description: String, // Austen’s most celebrated novel tells the story of Elizabeth Bennet, a bright, lively young woman with four sisters, and a mother determined to marry them to wealthy men. At a party near the Bennets’ home in the English countryside, Elizabeth meets the wealthy, proud Fitzwilliam Darcy. Elizabeth initially finds Darcy haughty and intolerable, but circumstances continue to unite the pair. Mr. Darcy finds himself captivated by Elizabeth’s wit and candor, while her reservations about his character slowly vanish. The story is as much a social critique as it is a love story, and the prose crackles with Austen’s wry wit.
    @SerializedName("dimensions")
    val dimensions: Dimensions,
    @SerializedName("imageLinks")
    val imageLinks: ImageLinks,
    @SerializedName("infoLink")
    val infoLink: String, // https://play.google.com/store/books/details?id=s1gVAAAAYAAJ&source=gbs_api
    @SerializedName("language")
    val language: String, // en
    @SerializedName("maturityRating")
    val maturityRating: String, // NOT_MATURE
    @SerializedName("pageCount")
    val pageCount: Int, // 401
    @SerializedName("panelizationSummary")
    val panelizationSummary: PanelizationSummary,
    @SerializedName("previewLink")
    val previewLink: String, // http://books.google.com/books?id=s1gVAAAAYAAJ&hl=&source=gbs_api
    @SerializedName("printType")
    val printType: String, // BOOK
    @SerializedName("printedPageCount")
    val printedPageCount: Int, // 448
    @SerializedName("publishedDate")
    val publishedDate: String, // 1918
    @SerializedName("publisher")
    val publisher: String, // C. Scribner's sons
    @SerializedName("ratingsCount")
    val ratingsCount: Int, // 370
    @SerializedName("readingModes")
    val readingModes: ReadingModes,
    @SerializedName("title")
    val title: String // Pride and Prejudice
)