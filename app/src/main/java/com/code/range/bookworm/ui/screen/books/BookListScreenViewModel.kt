package com.code.range.bookworm.ui.screen.books

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.code.range.bookworm.data.network.GoogleBookApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BookListScreenViewModel(private val googleBooksApi: GoogleBookApi) : ViewModel() {
    private val _viewState: MutableStateFlow<ViewState> = MutableStateFlow(ViewState.Loading)
    val viewState = _viewState.asStateFlow()

    private var _list = mutableStateOf(listOf<BookModel>())
    val list = mutableStateOf(_list)

    val searchText = mutableStateOf("")

    init {
        println(" 1234 New VM Created with id: ${System.identityHashCode(this)}")
        viewModelScope.launch(Dispatchers.IO) {
            val tempList = mutableListOf<BookModel>()
            googleBooksApi.getBooks("quilting").execute().body()?.items?.map {
                tempList.add(BookModel(it.id, it.volumeInfo.title, it.selfLink.trimEnd()))
            }
            _list.value = tempList
            _viewState.emit(
                ViewState.DataLoaded(_list.value)
            )
        }
    }

//    fun searchTextChanged(text: String) {
//        viewModelScope.launch(Dispatchers.Main) {
//            _viewState.update { _viewState.value }
//            _viewState.emit(
//                ViewState.DataLoaded(
//                    list.filter { it.title.contains(text) },
//                    (_viewState.value as ViewState.DataLoaded).searchText.value
//                )
//        }
//    }
}


sealed class ViewState {
    data object Loading : ViewState()
    class DataLoaded(
            val listOfBooks: List<BookModel>,
    ) : ViewState()

    data class Error(val error: String) : ViewState()
}

data class BookModel(
        val id: String, val title: String, val imageUrl: String
)
