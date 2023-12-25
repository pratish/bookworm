package com.code.range.bookworm.di

import android.app.Application
import android.content.Context
import com.code.range.bookworm.data.service.AuthRepository
import com.code.range.bookworm.data.service.AuthRepositoryImpl
import com.code.range.bookworm.data.network.AuthApi
import com.code.range.bookworm.data.network.AuthApiImpl

interface AppModule {
    val authRepo: AuthRepository
    val authApi: AuthApi
}

class AppModuleImpl(private val context: Context) : AppModule {
    override val authApi: AuthApi by lazy {
        AuthApiImpl(context)
    }

    override val authRepo: AuthRepository by lazy {
        AuthRepositoryImpl(authApi)
    }
}