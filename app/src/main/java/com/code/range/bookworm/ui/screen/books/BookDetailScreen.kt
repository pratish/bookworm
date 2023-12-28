package com.code.range.bookworm.ui.screen.books

import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun BookDetailScreen(
        bookId: String,
) {
    Text(text = "BookDetail for $bookId")
}