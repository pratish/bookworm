package com.code.range.bookworm.ui.screen.login

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(onLoginComplete: () -> Unit) {
    TextButton(
        onClick = {
            onLoginComplete()
    }) {
        Text("Login screen. Log in using this button")
    }

}