import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.uk.thewirelessguy.androidsubredditcompose.ui.navigation.AppNavigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@Composable
fun MainScreen() {

    val navController = rememberAnimatedNavController()

    Scaffold(

    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            AppNavigation(
                navController = navController
            )
        }
    }
}