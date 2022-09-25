package co.uk.thewirelessguy.androidsubredditcompose.model.app

import co.uk.thewirelessguy.androidsubredditcompose.model.api.SubredditResponse

data class PostsSummary(
    val id: String,
    val title: String,
    val author: String,
    val image: String,
    val permalink: String
) {
    companion object {
        fun from(post: SubredditResponse.Datum.Children): PostsSummary? {
            val data = post.data
            if (data == null || data.id.isNullOrEmpty() || data.title.isNullOrEmpty()) return null
            return PostsSummary(
                id = data.id,
                title = data.title,
                author = data.author.orEmpty(),
                image = data.thumbnail.orEmpty(),
                permalink = data.permalink.orEmpty()
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