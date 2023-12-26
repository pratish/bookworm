package com.code.range.bookworm.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BookListScreen(
    vm: BookListScreenViewModel = viewModel{
        BookListScreenViewModel()
    }
) {
    val viewState = vm.viewState.collectAsState().value
    println("view state changed: $viewState")
    when (viewState) {

        ViewState.Loading -> Loading()
        is ViewState.DataLoaded -> Loaded(viewState.data)
        is ViewState.Error -> Error(viewState.error)
    }
}

@Composable
private fun Loading() {
    Text("Loading")
}

@Composable
private fun Loaded(list: List<BookModel>) {
    LazyColumn(content = {
        item {Text("Total count: ${list.size}")}
        this.items(list.size) {index ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(if (index % 2 == 0) Color.Red else Color.Blue)
            ) {
                Text(list[index].id)
                Text(list[index].title)
//                Text(list[index].imageUrl)
            }
        }
    })
}

@Composable
private fun Error(msg: String) {
    Text(msg)
}