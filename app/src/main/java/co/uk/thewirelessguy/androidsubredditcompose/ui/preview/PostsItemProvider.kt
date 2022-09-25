package co.uk.thewirelessguy.androidsubredditcompose.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import co.uk.thewirelessguy.androidsubredditcompose.model.app.PostsSummary

class PostsItemProvider : PreviewParameterProvider<PostsSummary> {
    override val values: Sequence<PostsSummary> = sequenceOf(
        PostsSummary(
            id = "1",
            title = "Some Post",
            author = "Some Name",
            image = ""
        ),
        PostsSummary(
            id = "2",
            title = "Some Other Post",
            author = "Another Name",
            image = ""
        )
    )
}