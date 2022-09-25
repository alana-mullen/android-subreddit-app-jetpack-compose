package co.uk.thewirelessguy.androidsubredditcompose.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import co.uk.thewirelessguy.androidsubredditcompose.model.app.PostsSummary
import co.uk.thewirelessguy.androidsubredditcompose.ui.theme.listItemTitleTextColor
import co.uk.thewirelessguy.androidsubredditcompose.model.State
import co.uk.thewirelessguy.androidsubredditcompose.ui.component.CustomImage
import co.uk.thewirelessguy.androidsubredditcompose.ui.component.ErrorScreen
import co.uk.thewirelessguy.androidsubredditcompose.ui.component.LoadingScreen
import co.uk.thewirelessguy.androidsubredditcompose.ui.preview.PostsItemProvider
import co.uk.thewirelessguy.androidsubredditcompose.ui.theme.listItemSubTitleTextColor
import co.uk.thewirelessguy.androidsubredditcompose.viewmodel.SubredditViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch

@Composable
fun PostsListScreen(
    viewModel: SubredditViewModel = hiltViewModel()
) {
    val composableScope = rememberCoroutineScope()
    val uiState = viewModel.postsListUIState.collectAsState().value
    val isRefreshing by viewModel.isRefreshing.collectAsState()

    LaunchedEffect(key1 = Unit, block = {
        viewModel.fetchPostsList()
    })

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
        onRefresh = {
            composableScope.launch {
                viewModel.fetchPostsList(refresh = true)
            }
        },
    ) {
        when (uiState) {
            is State.Success -> PostsList(items = uiState.data.toMutableList())
            is State.Error -> ErrorScreen()
            else -> LoadingScreen()
        }
    }
}

@Composable
fun PostsList(items: MutableList<PostsSummary>) {
    LazyColumn {
        itemsIndexed(
            items = items,
            key = { _, item ->
                item.id
            }
        ) { index, item ->
            PostsItem(item)
            if (index < items.lastIndex) Divider(modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}

@Composable
fun PostsItem(item: PostsSummary) {
    val context = LocalContext.current

    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        CustomImage(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp),
            context = context,
            image = item.image
        )

        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = item.title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3,
                color = listItemTitleTextColor,
                style = MaterialTheme.typography.h6
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = item.author,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = listItemSubTitleTextColor,
                style = MaterialTheme.typography.h6,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Preview(
    showBackground = true,
    group = "PostsItem",
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun PostsItemLightModePreview(
    @PreviewParameter(PostsItemProvider::class) postsSummary: PostsSummary
) {
    PostsItem(item = postsSummary)
}

@Preview(
    showBackground = false,
    group = "PostsItem",
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
fun PostsItemDarkModePreview(
    @PreviewParameter(PostsItemProvider::class) postsSummary: PostsSummary
) {
    PostsItem(item = postsSummary)
}