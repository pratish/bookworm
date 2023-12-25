package com.code.range.bookworm.data.network

import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.PasswordCredential
import androidx.credentials.PublicKeyCredential
import androidx.credentials.exceptions.GetCredentialException
import com.code.range.bookworm.R
import com.code.range.bookworm.data.RemoteUser
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import kotlin.jvm.Throws


interface AuthApi {
    @Throws(Error::class)
    suspend fun signIn(mode: SignInMode): RemoteUser

    sealed class SignInMode {
        class Local(username: String, password: String) : SignInMode()

        data object Google : SignInMode()

        data object Apple : SignInMode()
    }

    sealed class Error: Throwable() {
        data object FailedToLogin: Error()
    }
}

class AuthApiImpl(private val context: Context) : AuthApi {

    private val googleCredentialManager: CredentialManager by lazy {
        CredentialManager.create(context)
    }

    override suspend fun signIn(mode: AuthApi.SignInMode): RemoteUser {
        println("Logging user with $mode")
        var user: RemoteUser? = null
        try {
            val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
                .setAutoSelectEnabled(true)
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(context.getString(R.string.server_key))
                .build()
            val request: GetCredentialRequest = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()
            try {
                val result = googleCredentialManager.getCredential(
                    request = request,
                    context = context,
                )
                handleSignIn(result)?.let {
                    user = it.toRemoteUser()
                }
            } catch (e: GetCredentialException) {
                println("get credential exception")
                e.printStackTrace()
            } catch (e: Exception) {
                println("general exception")
                e.printStackTrace()
            }
        } catch (e: Exception) {
            println("e is $e")
        }

        return user ?: throw AuthApi.Error.FailedToLogin

    }

    private fun handleSignIn(response: GetCredentialResponse): GoogleIdTokenCredential? {
        when (val credential = response.credential) {
            is PublicKeyCredential -> {
                val responseJson = credential.authenticationResponseJson
                println("PublicKeyCredential.responseJson: $responseJson")
            }

            is PasswordCredential -> {
                val username = credential.id
                val password = credential.password
                println("PasswordKeyCredential (userName: $username, password: $password)")
            }

            is CustomCredential -> {
                when (credential) {
                    is GoogleIdTokenCredential -> {
                        return credential
                    }
                }
                println("CustomCredential.type = ${credential.type}")

                println("\t.data = ${credential.data}")
            }
        }
        return null
    }
}

private fun GoogleIdTokenCredential.toRemoteUser() = RemoteUser(
    givenName = givenName,
    displayName = displayName,
    picUri = profilePictureUri,
    phoneNumber = phoneNumber,
    id = id,
    idToken = idToken,
    familyName = familyName
)

