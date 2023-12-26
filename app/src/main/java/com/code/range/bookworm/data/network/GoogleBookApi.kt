package com.code.range.bookworm.data.network

import com.code.range.bookworm.data.network.dto.RemoteBook
import com.code.range.bookworm.data.network.dto.RemoteBookList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleBookApi {
    @GET("books/v1/volumes/{id}")
    fun getBook(@Path("id") id: String) : Call<RemoteBook>

    @GET("books/v1/volumes")
    fun getBooks(@Query("q") query: String, @Query("max_results") max: Int = 40):
            Call<RemoteBookList>
}