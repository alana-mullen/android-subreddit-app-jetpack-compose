package co.uk.thewirelessguy.androidsubredditcompose.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink

fun interface NavigationDestination {

    fun route(): String

    //fun createRoute(id: String): String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()
}