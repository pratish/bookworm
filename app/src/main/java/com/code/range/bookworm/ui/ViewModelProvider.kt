package com.code.range.bookworm.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.code.range.bookworm.BookwormApp
import com.code.range.bookworm.ui.screen.books.BookListScreenViewModel
import java.io.InvalidObjectException
//
//fun <T: ViewModel> viewModelFactory(initializer: () -> T): ViewModelProvider.Factory {
//    return object : ViewModelProvider.Factory {
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            println("1234 modelClass: $modelClass")
//            return initializer() as T
//        }
//    }
//}
object ViewModelProvider {

    val appModule = BookwormApp.appModule

    @Composable
    inline fun <reified T : ViewModel> viewModel(type: Class<T>): T {
        return viewModel<T> {
            when (type) {
                BookListScreenViewModel::class.java -> BookListScreenViewModel(this@ViewModelProvider.appModule.googleBookApi) as T
                else -> throw InvalidObjectException("Class of viewModel not found")
            }
        }
    }
}

//fun <T: ViewModel> viewModelFactory(initializer: () -> T): ViewModelProvider.Factory {
//    return object : ViewModelProvider.Factory {
//        override fun <R : ViewModel> create(modelClass: Class<R>) : R {
//            return initializer() as R
//        }
//    }
//}