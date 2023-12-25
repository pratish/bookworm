package com.code.range.bookworm.data

import android.net.Uri
import com.code.range.bookworm.data.local.UserDto

interface Converter<T: Any, U: Any> {
    fun fromNetwork(networkObject: U): T
    fun fromDto(dto: T): U
}

object UserConverter: Converter<UserDto, RemoteUser> {
    override fun fromNetwork(networkObject: RemoteUser): UserDto {
        return UserDto(networkObject.givenName!!, networkObject.familyName!!, "")
    }

    override fun fromDto(dto: UserDto): RemoteUser {
        return RemoteUser(givenName = dto.firstName, familyName = dto.lastName, picUri = Uri.EMPTY,
                          phoneNumber = "",
                          id = "", idToken = "", displayName = ""
        )
    }
}

data class RemoteUser(
    val givenName: String?,
    val familyName: String?,
    val displayName: String?,
    val phoneNumber: String?,
    val id: String,
    val idToken: String,
    val picUri: Uri?
)