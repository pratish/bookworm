package com.code.range.bookworm.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.code.range.bookworm.di.AppModule
import com.code.range.bookworm.ui.navigation.LoginDestinations.CreateNewUser
import com.code.range.bookworm.ui.navigation.LoginDestinations.ForgotPassword
import com.code.range.bookworm.ui.navigation.LoginDestinations.Login
import com.code.range.bookworm.ui.screen.login.LoginScreen

fun NavGraphBuilder.loginNavGraph(
        navController: NavHostController,
        appModule: AppModule,
        setTitle: (String) -> Unit
) {
    navigation(
        startDestination = Login(), route = AppDestinations.Login()
    ) {
        composable(Login()) {
            LoginScreen {
                navController.navigate(AppDestinations.Books()) {
                    // Pop to the start destination so that we can clear all the backstack.
                    this.popUpTo(Login()) {
                        inclusive = true
                    }
                    appModule.isUserLoggedIn.value = true
                }
            }
        }

        composable(CreateNewUser()) {

        }

        composable(ForgotPassword()) {

        }
    }
}

sealed class LoginDestinations(override val displayTitle: String, override val route: String,
                               override val arguments: List<NamedNavArgument> = listOf()) :
    Destination {
    data object Login : LoginDestinations("Login", "login")
    data object ForgotPassword : LoginDestinations("Forgot Password","forgot_password")
    data object CreateNewUser : LoginDestinations("Register", "create_new_user")
}