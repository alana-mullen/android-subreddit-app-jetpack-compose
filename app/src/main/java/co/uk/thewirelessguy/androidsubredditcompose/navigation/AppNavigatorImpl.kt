package co.uk.thewirelessguy.androidsubredditcompose.navigation

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AppNavigatorImpl @Inject constructor() : AppNavigator {

    private val navigationEvents = Channel<NavigatorEvent>()
    override val destinations = navigationEvents.receiveAsFlow()

    override fun navigateUp(): Boolean =
        navigationEvents.trySend(NavigatorEvent.NavigateUp).isSuccess

    override fun navigate(
        route: String,
        hideBottomNavBar: Boolean,
        builder: NavOptionsBuilder.() -> Unit): Boolean =
        navigationEvents.trySend(
            NavigatorEvent.Directions(route, hideBottomNavBar, builder)
        ).isSuccess

}