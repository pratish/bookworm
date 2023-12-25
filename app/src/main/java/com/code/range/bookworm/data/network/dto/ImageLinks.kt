package com.code.range.bookworm.data.network.dto


import com.google.gson.annotations.SerializedName

data class ImageLinks(
    @SerializedName("extraLarge")
    val extraLarge: String, // http://books.google.com/books/content?id=s1gVAAAAYAAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE70BxyS3zGCln1XcBTqov7BOJRJDnIBsY_CeEFL9sNFrOSBqETprFIABKKrQohQNxZymt4sQdIMUDQSW3Dn9Vu6an89lPnxw4HCgfqkVaPJ6QoQv61t_bgFrr1ZZWS9UKSDD8jYQ&source=gbs_api
    @SerializedName("large")
    val large: String, // http://books.google.com/books/content?id=s1gVAAAAYAAJ&printsec=frontcover&img=1&zoom=4&edge=curl&imgtk=AFLRE73F1Ur3g7OOJ6Pi-EjSexQzb-K85mswT5oSSQmy9BNpc3LsLW0Owtr9-3ywfeKqEeRG1xhHxWNEOMZAHztA4fuAZWAvHIyd0O_dMfxyLeweHRGbaclxarJ0odOecCZMg1J4Lo-i&source=gbs_api
    @SerializedName("medium")
    val medium: String, // http://books.google.com/books/content?id=s1gVAAAAYAAJ&printsec=frontcover&img=1&zoom=3&edge=curl&imgtk=AFLRE70G44uOLouVKiF9tAv6jliBWDd1rtFhz14RloKu3mYJSnJ0gZ6hVuDH1ilLtE9ct4RsFjYqjujqnHBwUkL-j1w8-UER9_Y61cPKqlzos_27Tbx0BUuSsdcw4YHPlCCwR7EgGR5v&source=gbs_api
    @SerializedName("small")
    val small: String, // http://books.google.com/books/content?id=s1gVAAAAYAAJ&printsec=frontcover&img=1&zoom=2&edge=curl&imgtk=AFLRE73rpxs2VTpLIPeS-dXoN0ykQbZtJLtTMOwvVUntfs4-w9kBG-GwMYaKGtgzNrZ44piolHcCbW9d3AT5CzYf5qRg2IP0vGonBwg7PCgaHtwjKVycL4iWDJk6_rrY56HAMb4wkm3Z&source=gbs_api
    @SerializedName("smallThumbnail")
    val smallThumbnail: String, // http://books.google.com/books/content?id=s1gVAAAAYAAJ&printsec=frontcover&img=1&zoom=5&edge=curl&imgtk=AFLRE71sfoegOkplipCiRe_qdBebAClcBrINfMossKTcOBLGALVAqf-iww7PVSU-V6HF5xeT1BOAF68W5ctImbaeO4-BBB-Kn0oDbeRoEmB0uHlYTy9_8BUuJfwPXv6IRJwA27viuAqb&source=gbs_api
    @SerializedName("thumbnail")
    val thumbnail: String // http://books.google.com/books/content?id=s1gVAAAAYAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE70fjzxoQEy7YvuLvCAyUYTGDOFn1fr99rng8q2bXZNkevcn2lahmZI1GiqLvTPssVIxhFKnASe7N0qscBFjHNZHysAFk5VN_o1btd09vJPQhyJiMZWOZwrRIjR0WfOvw9BC5GMv&source=gbs_api
)