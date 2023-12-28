package com.code.range.bookworm.ui.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.code.range.bookworm.di.AppModule
import com.code.range.bookworm.ui.ViewModelProvider
import com.code.range.bookworm.ui.navigation.BooksDestinations.MyLibrary
import com.code.range.bookworm.ui.navigation.BooksDestinations.RemoteSearch
import com.code.range.bookworm.ui.screen.books.BookDetailScreen
import com.code.range.bookworm.ui.screen.books.BookListScreen
import com.code.range.bookworm.ui.screen.books.BookListScreenViewModel
import com.code.range.bookworm.ui.screen.books.MyLibraryScreen

fun NavGraphBuilder.booksNavGraph(
        navController: NavHostController, appModule: AppModule, padding: PaddingValues, setTitle:
        (String) -> Unit
) {
    navigation(
        startDestination = RemoteSearch(), route = AppDestinations.Books()
    ) {
        composable(RemoteSearch()) {
            setTitle(RemoteSearch.displayTitle)
            Surface(modifier = Modifier.padding(padding)) {
                val viewModel: BookListScreenViewModel =  ViewModelProvider.viewModel(BookListScreenViewModel::class.java)

                BookListScreen(viewModel) {
                    println("1234 RouterBuilder: ${BooksDestinations.BookDetail.routeBuilder(it)}")
                    navController.navigate(BooksDestinations.BookDetail.routeBuilder(it))
                }
            }
        }
        composable(MyLibrary()) {
            Surface(modifier = Modifier.padding(padding)) {
                MyLibraryScreen()
            }
        }
        composable(
            route=BooksDestinations.BookDetail.route,
            arguments = BooksDestinations.BookDetail.arguments
        ){backStackEntry ->
            Surface(modifier = Modifier.padding(padding)) {
                val selectedBookId = backStackEntry.arguments?.getString("bookId")!!
                setTitle(selectedBookId)
                BookDetailScreen(bookId = selectedBookId)
            }
        }
    }
}

sealed class BooksDestinations(
        override val displayTitle: String,
        override val route: String,
                               override val arguments: List<NamedNavArgument> = listOf()
) : Destination {
    data object RemoteSearch: BooksDestinations("Search","remote_search")
    data object MyLibrary: BooksDestinations("My Library", "my_library")
    data object BookDetail: BooksDestinations("bookId","book_detail/{bookId}") {
        override val arguments: List<NamedNavArgument>
            get() = listOf(
                navArgument("bookId") {
                    this.type = NavType.StringType
                }
            )

        fun routeBuilder(id: String): String = route.replace("{bookId}", id)
    }
}

