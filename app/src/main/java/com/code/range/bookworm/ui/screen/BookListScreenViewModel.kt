package com.code.range.bookworm.ui.screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.code.range.bookworm.BookwormApp
import com.code.range.bookworm.data.network.GoogleBookApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BookListScreenViewModel(private val googleBooksApi: GoogleBookApi = BookwormApp.appModule
    .googleBookApi):
    ViewModel() {
    private val _viewState: MutableStateFlow<ViewState> = MutableStateFlow(ViewState.Loading)
    val viewState = _viewState.asStateFlow()

    private val list = mutableListOf<BookModel>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            googleBooksApi.getBooks("quilting").execute().body()?.items?.map {
                list.add(BookModel(it.id, it.volumeInfo.title, it.selfLink.trimEnd()))
            }
            _viewState.emit(ViewState.DataLoaded(list))
        }
    }
}


sealed class ViewState {
    data object Loading: ViewState()
    class DataLoaded(val data: List<BookModel>) : ViewState()
    data class Error(val error: String) : ViewState()
}

data class BookModel(
    val id: String,
    val title: String,
    val imageUrl: String
)
