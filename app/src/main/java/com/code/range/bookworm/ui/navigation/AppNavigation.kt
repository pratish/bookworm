package com.code.range.bookworm.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.code.range.bookworm.di.AppModule
import com.code.range.bookworm.ui.theme.DarkColorScheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(appModule: AppModule, navController: NavHostController) {
    var title by remember { mutableStateOf("Hello World") }

    fun setTitle(newTitle: String) {
        title = newTitle
    }

    appModule.isUserLoggedIn.value = false
    Scaffold(
        bottomBar = {
        if (appModule.isUserLoggedIn.value) {
            BottomAppBar {
                Text(text = "Hello")
            }
        }
    },
        topBar = {
        if (appModule.isUserLoggedIn.value) {
            LargeTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = DarkColorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {Text(title)}
            )
        }
    }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = if (appModule.isUserLoggedIn.value) AppDestinations.Books() else
                AppDestinations.Login()
        ) {
            loginNavGraph(navController = navController, appModule, ::setTitle)
            booksNavGraph(navController = navController, appModule, padding, ::setTitle)
        }
    }
}

