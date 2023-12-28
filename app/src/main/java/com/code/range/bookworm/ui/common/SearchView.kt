package com.code.range.bookworm.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun SearchView(
        value: MutableState<String>, placeHolder: String,
        onValueChanged: (String) -> Unit
) {
    TextField(modifier = Modifier.fillMaxWidth(), value = value.value, onValueChange = {
        println("1234: Pre: ${it}")
        onValueChanged(it)
    }, placeholder = {
        Text(placeHolder)
    })
}