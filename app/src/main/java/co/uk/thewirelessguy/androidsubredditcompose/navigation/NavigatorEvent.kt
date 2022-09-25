package co.uk.thewirelessguy.androidsubredditcompose.navigation

import androidx.navigation.NavOptionsBuilder

sealed class NavigatorEvent {
    object NavigateUp : NavigatorEvent()
    class Directions(
        val destination: String,
        val hideBottomNavBar: Boolean = false,
        val builder: NavOptionsBuilder.() -> Unit) : NavigatorEvent()
}