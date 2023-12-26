package com.code.range.bookworm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

fun <T: ViewModel> viewModelFactory(initializer: () -> T): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            println("1234 modelClass: $modelClass")
            return initializer() as T
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