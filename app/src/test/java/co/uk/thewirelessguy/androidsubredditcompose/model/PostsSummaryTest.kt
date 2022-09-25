package co.uk.thewirelessguy.androidsubredditcompose.model

import co.uk.thewirelessguy.androidsubredditcompose.model.api.SubredditResponse
import co.uk.thewirelessguy.androidsubredditcompose.model.app.PostsSummary
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class PostsSummaryTest : FreeSpec() {

    private val subredditResponseItem = SubredditResponse.Datum.Children(
        SubredditResponse.Datum.Children.Datum(
            author = "some-author",
            id = "some-id",
            permalink = "some-permalink",
            thumbnail = "some-image",
            title = "some-title"
        )
    )

    private val subredditResponse = SubredditResponse(
        data = SubredditResponse.Datum(
            children = listOf(
                SubredditResponse.Datum.Children(
                    data = subredditResponseItem.data
                )
            )
        )
    )

    init {
        "from (PostsSummary)" - {
            "When given a correct SubredditResponse it returns correct data" {
                val postsSummary = PostsSummary.from(subredditResponse)
                with (postsSummary.first()) {
                    author shouldBe "some-author"
                    id shouldBe "some-id"
                    permalink shouldBe "some-permalink"
                    title shouldBe "some-title"
                    image shouldBe "some-image"
                }
            }

            "When given incorrect SubredditResponse data it returns false" - {

                "Field required for id is not supplied" {
                    val postsSummary = PostsSummary.from(subredditResponseItem.copy(
                        SubredditResponse.Datum.Children.Datum(
                            id = ""
                        )
                    ))
                    postsSummary shouldBe null
                }

                "Field required for title is not supplied" {
                    val postsSummary = PostsSummary.from(subredditResponseItem.copy(
                        SubredditResponse.Datum.Children.Datum(
                            title = ""
                        )
                    ))
                    postsSummary shouldBe null
                }
            }
        }

        "from (List<PostsSummary>)" - {
            "If SubredditResponse list is empty then it returns an empty list" {
                val postsSummary = PostsSummary.from(subredditResponse.copy(
                    subredditResponse.data!!.copy(
                        children = listOf()
                    )
                ))
                postsSummary shouldBe emptyList()
            }

            "If SubredditResponse list is comprised of some number of valid posts it returns that same number of correct PostsSummary objects" - {

                "A single post" {
                    val postsSummary = PostsSummary.from(subredditResponse)
                    with (postsSummary.first()) {
                        author shouldBe "some-author"
                        id shouldBe "some-id"
                        permalink shouldBe "some-permalink"
                        title shouldBe "some-title"
                        image shouldBe "some-image"
                    }
                }

                "More than one post" {
                    val postsSummary = PostsSummary.from(
                        subredditResponse.copy(
                            subredditResponse.data!!.copy(
                                children = listOf(
                                    subredditResponseItem,
                                    SubredditResponse.Datum.Children(
                                        SubredditResponse.Datum.Children.Datum(
                                            id = "some-other-id",
                                            title = "some-other-title"
                                        )
                                    )
                                )
                            )
                        )
                    )
                    with (postsSummary.first()) {
                        author shouldBe "some-author"
                        id shouldBe "some-id"
                        permalink shouldBe "some-permalink"
                        title shouldBe "some-title"
                        image shouldBe "some-image"
                    }
                    with (postsSummary.last()) {
                        title shouldBe "some-other-title"
                    }
                }
            }

            "If SubredditResponse list is comprised of some number of invalid posts it doesn't return that same number of PostsSummary objects" - {

                "If all posts are bad data it returns an empty list" {
                    val postsSummary = PostsSummary.from(
                        subredditResponse.copy(
                            subredditResponse.data!!.copy(
                                children = listOf(
                                    subredditResponseItem.copy(
                                        SubredditResponse.Datum.Children.Datum(
                                            id = null
                                        )
                                    ),
                                    subredditResponseItem.copy(
                                        SubredditResponse.Datum.Children.Datum(
                                            title = null
                                        )
                                    )
                                )
                            )
                        )
                    )
                    postsSummary shouldBe emptyList()
                }

                "More than one post with some good and some bad data will return only the good data" {
                    val postsSummary = PostsSummary.from(
                        subredditResponse.copy(
                            subredditResponse.data!!.copy(
                                children = listOf(
                                    subredditResponseItem, // Good data
                                    subredditResponseItem.copy(
                                        SubredditResponse.Datum.Children.Datum(
                                            title = null
                                        )
                                    )
                                )
                            )
                        )
                    )
                    with (postsSummary.first()) {
                        author shouldBe "some-author"
                        id shouldBe "some-id"
                        permalink shouldBe "some-permalink"
                        title shouldBe "some-title"
                        image shouldBe "some-image"
                    }
                }
            }
        }
    }
}