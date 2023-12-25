package com.code.range.bookworm.data.service

import com.code.range.bookworm.data.UserConverter
import com.code.range.bookworm.data.local.UserDto
import com.code.range.bookworm.data.network.AuthApi

interface AuthRepository {
    suspend fun signIn(): UserDto
}
class AuthRepositoryImpl(private val authApi: AuthApi): AuthRepository {
    override suspend fun signIn(): UserDto {
        // Only signin using google supported for now
        return UserConverter.fromNetwork(authApi.signIn(AuthApi.SignInMode.Google))
    }
}