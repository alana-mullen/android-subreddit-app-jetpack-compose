package co.uk.thewirelessguy.androidsubredditcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import co.uk.thewirelessguy.androidsubredditcompose.viewmodel.BaseViewModel
import co.uk.thewirelessguy.androidsubredditcompose.navigation.NavigatorEvent
import co.uk.thewirelessguy.androidsubredditcompose.navigation.defaultAppEnterTransition
import co.uk.thewirelessguy.androidsubredditcompose.navigation.defaultAppExitTransition
import co.uk.thewirelessguy.androidsubredditcompose.navigation.defaultAppPopEnterTransition
import co.uk.thewirelessguy.androidsubredditcompose.navigation.defaultAppPopExitTransition
import co.uk.thewirelessguy.androidsubredditcompose.navigation.model.NavGraph
import co.uk.thewirelessguy.androidsubredditcompose.navigation.navgraph.addPostsNavGraph
import co.uk.thewirelessguy.androidsubredditcompose.navigation.navigateSafe
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

@Composable
fun AppNavigation(
    navController: NavHostController,
    navigationViewModel: BaseViewModel = hiltViewModel()
) {
    val bottomSheetNavigator = rememberBottomSheetNavigator()

    /**
     * Observe the navigator for navigation events from the modules
     * ready to navigate around.
     */
    LaunchedEffect(key1 = navController) {
        navigationViewModel.destinations.collectLatest { navigatorEvent ->
            Timber.d("navigatorEvent $navigatorEvent")
            when (navigatorEvent) {
                is NavigatorEvent.Directions -> {
                    Timber.d("showBottomNav ${navigatorEvent.hideBottomNavBar}")
                    navController.navigateSafe(
                        navigatorEvent.destination,
                        navigatorEvent.builder,
                    )
                }
                is NavigatorEvent.NavigateUp -> navController.navigateUp()
            }
        }
    }

    /**
     * Create the navigation host adding the navigation graphs
     */
    ModalBottomSheetLayout(bottomSheetNavigator = bottomSheetNavigator) {
        AnimatedNavHost(
            navController = navController,
            startDestination = NavGraph.Posts.topLevelRoute,
            enterTransition = { defaultAppEnterTransition(initialState, targetState) },
            exitTransition = { defaultAppExitTransition(initialState, targetState) },
            popEnterTransition = { defaultAppPopEnterTransition() },
            popExitTransition = { defaultAppPopExitTransition() },
        ) {
            addPostsNavGraph()
        }
    }
}