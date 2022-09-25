package co.uk.thewirelessguy.androidsubredditcompose.navigation

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.Flow

interface AppNavigator {

    fun navigateUp(): Boolean

    fun navigate(
        route: String,
        hideBottomNavBar: Boolean = false,
        builder: NavOptionsBuilder.() -> Unit = { launchSingleTop = true }
    ): Boolean

    val destinations: Flow<NavigatorEvent>
}