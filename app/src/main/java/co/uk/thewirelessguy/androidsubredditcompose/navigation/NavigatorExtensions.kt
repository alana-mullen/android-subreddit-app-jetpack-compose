package co.uk.thewirelessguy.androidsubredditcompose.navigation

import androidx.navigation.*
import timber.log.Timber
import java.lang.Exception

private const val HIDE_BOTTOM_NAV_ARG = "co.uk.thewirelessguy.androidsubredditcompose.navigation.HIDE_BOTTOM_NAV_ARG"

fun NavController.navigateSafe(
    route: String,
    builder: NavOptionsBuilder.() -> Unit) {
    try {
        if (this.currentDestination?.route != route) {
            this.navigate(route, builder)
        }
    } catch (e: Exception) {
        Timber.e("Error navigating to route: $route\n$e")
    }
}


val hideBottomNamedArgument: NamedNavArgument
    get() = navArgument(HIDE_BOTTOM_NAV_ARG) {
        type = NavType.BoolType
        defaultValue = true
    }

val NavDestination?.hideBottomNavigation
    get() = hideBottomNamedArgument.argument == this?.arguments?.get(
        HIDE_BOTTOM_NAV_ARG
    )
val hideBottomBundleArgument: NavArgument get() = hideBottomNamedArgument.argument

fun navArgString(param: String, hideBottomNav: Boolean = false): List<NamedNavArgument> {
    return listOf(navArgument(param) {
        type = NavType.StringType
        if (hideBottomNav) hideBottomNamedArgument
    })
}

val NavBackStackEntry?.hideBottomNavigation
    get() = this?.arguments?.getBoolean(
        HIDE_BOTTOM_NAV_ARG
    ) ?: false

fun NavBackStackEntry.getStringArg(param: String): String? =
    this.arguments?.getString(param)