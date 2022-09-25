package co.uk.thewirelessguy.androidsubredditcompose.model.app

import co.uk.thewirelessguy.androidsubredditcompose.model.api.SubredditResponse

data class PostsSummary(
    val id: String,
    val title: String,
    val author: String,
    val image: String,
) {
    companion object {
        fun from(post: SubredditResponse.Data.Children): PostsSummary? {
            val data = post.data
            if (data == null || data.id.isNullOrEmpty() || data.name.isNullOrEmpty()) return null
            val id = data.id
            val postTitle = data.title.orEmpty()
            val postAuthor = data.author.orEmpty()
            val thumbnail = data.thumbnail.orEmpty()
            return PostsSummary(
                id = id,
                title = postTitle,
                author = postAuthor,
                image = thumbnail
            )
        }

        fun from(posts: SubredditResponse): List<PostsSummary> {
            val postList = posts.data?.children
            return postList?.mapNotNull { post ->
                from(post)
            } ?: mutableListOf()
        }
    }
}