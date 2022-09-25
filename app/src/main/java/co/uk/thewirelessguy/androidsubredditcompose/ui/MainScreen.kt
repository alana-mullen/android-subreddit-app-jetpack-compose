import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import co.uk.thewirelessguy.androidsubredditcompose.R
import co.uk.thewirelessguy.androidsubredditcompose.ui.PostsListScreen
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@Composable
fun MainScreen() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            PostsListScreen()
        }
    }
}