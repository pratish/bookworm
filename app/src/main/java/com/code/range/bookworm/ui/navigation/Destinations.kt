package com.code.range.bookworm.ui.navigation

import androidx.navigation.NamedNavArgument

interface Destination {
    val route: String
    val arguments: List<NamedNavArgument>
    val displayTitle: String

    operator fun invoke() = route
}

sealed class AppDestinations(
        override val displayTitle: String, override val route: String,
        override val arguments:
        List<NamedNavArgument> = listOf()
) : Destination {
    data object Login : AppDestinations("", "login_navigation")
    data object Books : AppDestinations("","books_navigation")
    data object Settings : AppDestinations("","settings_navigation")
}


