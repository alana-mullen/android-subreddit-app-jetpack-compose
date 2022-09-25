package co.uk.thewirelessguy.androidsubredditcompose.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import co.uk.thewirelessguy.androidsubredditcompose.navigation.model.NavGraph
import co.uk.thewirelessguy.androidsubredditcompose.ui.PostsListScreen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

fun NavGraphBuilder.addPostsNavGraph() {
    navigation(
        route = NavGraph.Posts.topLevelRoute,
        startDestination = NavGraph.Posts.route
    ) {
        composable(NavGraph.Posts.route) {
            PostsListScreen()
        }
    }
}