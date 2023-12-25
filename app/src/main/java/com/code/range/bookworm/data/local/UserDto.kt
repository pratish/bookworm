package com.code.range.bookworm.data.local

data class UserDto(
    val firstName: String,
    val lastName: String,
    val sessionToken: String?
) {
    companion object {
        val mock = UserDto("tester", "lastNameTester", null)
    }
}
