package com.code.range.bookworm.ui.screen.books

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.code.range.bookworm.ui.theme.BookwormTheme

@Composable
fun BookListScreen(
        vm: BookListScreenViewModel, onItemClicked: (String) -> Unit
) {
    when (val viewState = vm.viewState.collectAsState().value) {
        ViewState.Loading -> Loading()
        is ViewState.DataLoaded -> Loaded(vm) { onItemClicked(it) }
        is ViewState.Error -> Error(viewState.error)
    }
}

@Composable
private fun Loading() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
        Text("Loading...")
    }
}

@Composable
private fun Loaded(vm: BookListScreenViewModel, onItemClicked: (String) -> Unit) {
    val data = (vm.viewState.collectAsState()).value as ViewState.DataLoaded
    var textValueFieldValue by remember { vm.searchText }
    var filteredList by remember { mutableStateOf(data.listOfBooks) } //    var t by remember{mutableStateOf(data.listOfBooks.filter { it.title.contains

    LazyColumn(
        content = {
        item {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp),
                value = textValueFieldValue,
                label = {Text("Search")},
                placeholder = {Text("What would you like to search for?")},
                onValueChange = { updatedText ->
                textValueFieldValue = updatedText
                filteredList = if (updatedText.isEmpty()) data.listOfBooks
                else data.listOfBooks.filter { it.title.contains(updatedText, true) }
            })
        }
        items(filteredList.size) { index ->
            val book = filteredList[index]
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Row(modifier = Modifier
                    .clickable {
                        onItemClicked(book.id)
                    }
                    .fillMaxWidth()
                    .height(64.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(book.title)
                }
                Divider(thickness = 1.dp)
            }
        }
    })
}

@Composable
private fun Error(msg: String) {

}

@Preview(showBackground = true)
@Composable
private fun BookListPreview() {
    BookwormTheme { //        Loading()
    }
}
