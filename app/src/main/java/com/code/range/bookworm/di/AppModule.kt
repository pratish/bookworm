package com.code.range.bookworm.di

import android.app.Application
import android.content.Context
import com.code.range.bookworm.data.network.ApiClientFactory
import com.code.range.bookworm.data.service.AuthRepository
import com.code.range.bookworm.data.service.AuthRepositoryImpl
import com.code.range.bookworm.data.network.AuthApi
import com.code.range.bookworm.data.network.AuthApiImpl
import com.code.range.bookworm.data.network.GoogleBookApi
import retrofit2.Retrofit

interface AppModule {
    val authRepo: AuthRepository
    val authApi: AuthApi
    val googleBookApi: GoogleBookApi
}

typealias ApiClient = Retrofit

class AppModuleImpl(private val context: Context) : AppModule {


    private val apiClient = ApiClientFactory.instance

    override val authApi: AuthApi by lazy {
        AuthApiImpl(context)
    }

    override val authRepo: AuthRepository by lazy {
        AuthRepositoryImpl(authApi)
    }

    override val googleBookApi: GoogleBookApi by lazy {
        apiClient.create(GoogleBookApi::class.java)
    }
}