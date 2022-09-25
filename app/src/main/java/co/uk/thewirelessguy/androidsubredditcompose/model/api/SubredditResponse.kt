package co.uk.thewirelessguy.androidsubredditcompose.model.api

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class SubredditResponse(
    @SerialName("data")
    val `data`: Data? = Data(),
    @SerialName("kind")
    val kind: String? = ""
) {
    @Serializable
    data class Data(
        @SerialName("after")
        val after: String? = "",
        //@SerialName("before")
        //val before: Any? = Any(),
        @SerialName("children")
        val children: List<Children>? = listOf(),
        @SerialName("dist")
        val dist: Int? = 0,
        @SerialName("modhash")
        val modhash: String? = ""
    ) {
        @Serializable
        data class Children(
            @SerialName("data")
            val `data`: Data? = Data(),
            @SerialName("kind")
            val kind: String? = ""
        ) {
            @Serializable
            data class Data(
                @SerialName("all_awardings")
                val allAwardings: List<AllAwarding?>? = listOf(),
                @SerialName("allow_live_comments")
                val allowLiveComments: Boolean? = false,
                //@SerialName("approved_at_utc")
                //val approvedAtUtc: Any? = Any(),
                //@SerialName("approved_by")
                //val approvedBy: Any? = Any(),
                @SerialName("archived")
                val archived: Boolean? = false,
                @SerialName("author")
                val author: String? = "",
                //@SerialName("author_flair_background_color")
                //val authorFlairBackgroundColor: Any? = Any(),
                //@SerialName("author_flair_css_class")
                //val authorFlairCssClass: Any? = Any(),
                //@SerialName("author_flair_richtext")
                //val authorFlairRichtext: List<Any?>? = listOf(),
                //@SerialName("author_flair_template_id")
                //val authorFlairTemplateId: Any? = Any(),
                //@SerialName("author_flair_text")
                //val authorFlairText: Any? = Any(),
                //@SerialName("author_flair_text_color")
                //val authorFlairTextColor: Any? = Any(),
                @SerialName("author_flair_type")
                val authorFlairType: String? = "",
                @SerialName("author_fullname")
                val authorFullname: String? = "",
                @SerialName("author_patreon_flair")
                val authorPatreonFlair: Boolean? = false,
                @SerialName("author_premium")
                val authorPremium: Boolean? = false,
                //@SerialName("awarders")
                //val awarders: List<Any?>? = listOf(),
                //@SerialName("banned_at_utc")
                //val bannedAtUtc: Any? = Any(),
                //@SerialName("banned_by")
                //val bannedBy: Any? = Any(),
                @SerialName("can_gild")
                val canGild: Boolean? = false,
                @SerialName("can_mod_post")
                val canModPost: Boolean? = false,
                //@SerialName("category")
                //val category: Any? = Any(),
                @SerialName("clicked")
                val clicked: Boolean? = false,
                //@SerialName("content_categories")
                //val contentCategories: Any? = Any(),
                @SerialName("contest_mode")
                val contestMode: Boolean? = false,
                @SerialName("created")
                val created: Double? = 0.0,
                @SerialName("created_utc")
                val createdUtc: Double? = 0.0,
                //@SerialName("discussion_type")
                //val discussionType: Any? = Any(),
                //@SerialName("distinguished")
                //val distinguished: Any? = Any(),
                @SerialName("domain")
                val domain: String? = "",
                @SerialName("downs")
                val downs: Int? = 0,
                //@SerialName("edited")
                //val edited: Any? = Any(),
                @SerialName("gilded")
                val gilded: Int? = 0,
                @SerialName("gildings")
                val gildings: Gildings? = Gildings(),
                @SerialName("hidden")
                val hidden: Boolean? = false,
                @SerialName("hide_score")
                val hideScore: Boolean? = false,
                @SerialName("id")
                val id: String? = "",
                @SerialName("is_crosspostable")
                val isCrosspostable: Boolean? = false,
                @SerialName("is_meta")
                val isMeta: Boolean? = false,
                @SerialName("is_original_content")
                val isOriginalContent: Boolean? = false,
                @SerialName("is_reddit_media_domain")
                val isRedditMediaDomain: Boolean? = false,
                @SerialName("is_robot_indexable")
                val isRobotIndexable: Boolean? = false,
                @SerialName("is_self")
                val isSelf: Boolean? = false,
                @SerialName("is_video")
                val isVideo: Boolean? = false,
                //@SerialName("likes")
                //val likes: Any? = Any(),
                @SerialName("link_flair_background_color")
                val linkFlairBackgroundColor: String? = "",
                //@SerialName("link_flair_css_class")
                //val linkFlairCssClass: Any? = Any(),
                //@SerialName("link_flair_richtext")
                //val linkFlairRichtext: List<Any?>? = listOf(),
                //@SerialName("link_flair_text")
                //val linkFlairText: Any? = Any(),
                @SerialName("link_flair_text_color")
                val linkFlairTextColor: String? = "",
                @SerialName("link_flair_type")
                val linkFlairType: String? = "",
                @SerialName("locked")
                val locked: Boolean? = false,
                //@SerialName("media")
                //val media: Any? = Any(),
                @SerialName("media_embed")
                val mediaEmbed: MediaEmbed? = MediaEmbed(),
                @SerialName("media_only")
                val mediaOnly: Boolean? = false,
                //@SerialName("mod_note")
                //val modNote: Any? = Any(),
                //@SerialName("mod_reason_by")
                //val modReasonBy: Any? = Any(),
                //@SerialName("mod_reason_title")
                //val modReasonTitle: Any? = Any(),
                //@SerialName("mod_reports")
                //val modReports: List<Any?>? = listOf(),
                @SerialName("name")
                val name: String? = "",
                @SerialName("no_follow")
                val noFollow: Boolean? = false,
                @SerialName("num_comments")
                val numComments: Int? = 0,
                @SerialName("num_crossposts")
                val numCrossposts: Int? = 0,
                //@SerialName("num_reports")
                //val numReports: Any? = Any(),
                @SerialName("over_18")
                val over18: Boolean? = false,
                @SerialName("parent_whitelist_status")
                val parentWhitelistStatus: String? = "",
                @SerialName("permalink")
                val permalink: String? = "",
                @SerialName("pinned")
                val pinned: Boolean? = false,
                @SerialName("post_hint")
                val postHint: String? = "",
                @SerialName("preview")
                val preview: Preview? = Preview(),
                @SerialName("pwls")
                val pwls: Int? = 0,
                @SerialName("quarantine")
                val quarantine: Boolean? = false,
                //@SerialName("removal_reason")
                //val removalReason: Any? = Any(),
                //@SerialName("removed_by")
                //val removedBy: Any? = Any(),
                //@SerialName("removed_by_category")
                //val removedByCategory: Any? = Any(),
                //@SerialName("report_reasons")
                //val reportReasons: Any? = Any(),
                @SerialName("saved")
                val saved: Boolean? = false,
                @SerialName("score")
                val score: Int? = 0,
                //@SerialName("secure_media")
                //val secureMedia: Any? = Any(),
                @SerialName("secure_media_embed")
                val secureMediaEmbed: SecureMediaEmbed? = SecureMediaEmbed(),
                @SerialName("selftext")
                val selftext: String? = "",
                @SerialName("selftext_html")
                val selftextHtml: String? = "",
                @SerialName("send_replies")
                val sendReplies: Boolean? = false,
                @SerialName("spoiler")
                val spoiler: Boolean? = false,
                @SerialName("stickied")
                val stickied: Boolean? = false,
                @SerialName("subreddit")
                val subreddit: String? = "",
                @SerialName("subreddit_id")
                val subredditId: String? = "",
                @SerialName("subreddit_name_prefixed")
                val subredditNamePrefixed: String? = "",
                @SerialName("subreddit_subscribers")
                val subredditSubscribers: Int? = 0,
                @SerialName("subreddit_type")
                val subredditType: String? = "",
                //@SerialName("suggested_sort")
                //val suggestedSort: Any? = Any(),
                @SerialName("thumbnail")
                val thumbnail: String? = "",
                //@SerialName("thumbnail_height")
                //val thumbnailHeight: Any? = Any(),
                //@SerialName("thumbnail_width")
                //val thumbnailWidth: Any? = Any(),
                @SerialName("title")
                val title: String? = "",
                //@SerialName("top_awarded_type")
                //val topAwardedType: Any? = Any(),
                @SerialName("total_awards_received")
                val totalAwardsReceived: Int? = 0,
                //@SerialName("treatment_tags")
                //val treatmentTags: List<Any?>? = listOf(),
                @SerialName("ups")
                val ups: Int? = 0,
                @SerialName("upvote_ratio")
                val upvoteRatio: Double? = 0.0,
                @SerialName("url")
                val url: String? = "",
                @SerialName("url_overridden_by_dest")
                val urlOverriddenByDest: String? = "",
                //@SerialName("user_reports")
                //val userReports: List<Any?>? = listOf(),
                //@SerialName("view_count")
                //val viewCount: Any? = Any(),
                @SerialName("visited")
                val visited: Boolean? = false,
                @SerialName("whitelist_status")
                val whitelistStatus: String? = "",
                @SerialName("wls")
                val wls: Int? = 0
            ) {
                @Serializable
                data class AllAwarding(
                    @SerialName("award_sub_type")
                    val awardSubType: String? = "",
                    @SerialName("award_type")
                    val awardType: String? = "",
                    //@SerialName("awardings_required_to_grant_benefits")
                    //val awardingsRequiredToGrantBenefits: Any? = Any(),
                    @SerialName("coin_price")
                    val coinPrice: Int? = 0,
                    @SerialName("coin_reward")
                    val coinReward: Int? = 0,
                    @SerialName("count")
                    val count: Int? = 0,
                    @SerialName("days_of_drip_extension")
                    val daysOfDripExtension: Int? = 0,
                    @SerialName("days_of_premium")
                    val daysOfPremium: Int? = 0,
                    @SerialName("description")
                    val description: String? = "",
                    //@SerialName("end_date")
                    //val endDate: Any? = Any(),
                    @SerialName("giver_coin_reward")
                    val giverCoinReward: Int? = 0,
                    @SerialName("icon_format")
                    val iconFormat: String? = "",
                    @SerialName("icon_height")
                    val iconHeight: Int? = 0,
                    @SerialName("icon_url")
                    val iconUrl: String? = "",
                    @SerialName("icon_width")
                    val iconWidth: Int? = 0,
                    @SerialName("id")
                    val id: String? = "",
                    @SerialName("is_enabled")
                    val isEnabled: Boolean? = false,
                    @SerialName("is_new")
                    val isNew: Boolean? = false,
                    @SerialName("name")
                    val name: String? = "",
                    @SerialName("penny_donate")
                    val pennyDonate: Int? = 0,
                    @SerialName("penny_price")
                    val pennyPrice: Int? = 0,
                    @SerialName("resized_icons")
                    val resizedIcons: List<ResizedIcon?>? = listOf(),
                    @SerialName("resized_static_icons")
                    val resizedStaticIcons: List<ResizedStaticIcon?>? = listOf(),
                    //@SerialName("start_date")
                    //val startDate: Any? = Any(),
                    @SerialName("static_icon_height")
                    val staticIconHeight: Int? = 0,
                    @SerialName("static_icon_url")
                    val staticIconUrl: String? = "",
                    @SerialName("static_icon_width")
                    val staticIconWidth: Int? = 0,
                    @SerialName("subreddit_coin_reward")
                    val subredditCoinReward: Int? = 0,
                    //@SerialName("subreddit_id")
                    //val subredditId: Any? = Any(),
                    //@SerialName("tiers_by_required_awardings")
                    //val tiersByRequiredAwardings: Any? = Any()
                ) {
                    @Serializable
                    data class ResizedIcon(
                        @SerialName("height")
                        val height: Int? = 0,
                        @SerialName("url")
                        val url: String? = "",
                        @SerialName("width")
                        val width: Int? = 0
                    )

                    @Serializable
                    data class ResizedStaticIcon(
                        @SerialName("height")
                        val height: Int? = 0,
                        @SerialName("url")
                        val url: String? = "",
                        @SerialName("width")
                        val width: Int? = 0
                    )
                }

                @Serializable
                data class Gildings(
                    @SerialName("gid_1")
                    val gid1: Int? = 0
                )

                @Serializable
                data class MediaEmbed(
                    @SerialName("content")
                    val content: String? = "",
                    @SerialName("height")
                    val height: Int? = 0,
                    @SerialName("scrolling")
                    val scrolling: Boolean? = false,
                    @SerialName("width")
                    val width: Int? = 0
                )

                @Serializable
                data class Preview(
                    @SerialName("enabled")
                    val enabled: Boolean? = false,
                    @SerialName("images")
                    val images: List<Image?>? = listOf()
                ) {
                    @Serializable
                    data class Image(
                        @SerialName("id")
                        val id: String? = "",
                        @SerialName("resolutions")
                        val resolutions: List<Resolution?>? = listOf(),
                        @SerialName("source")
                        val source: Source? = Source(),
                        @SerialName("variants")
                        val variants: Variants? = Variants()
                    ) {
                        @Serializable
                        data class Resolution(
                            @SerialName("height")
                            val height: Int? = 0,
                            @SerialName("url")
                            val url: String? = "",
                            @SerialName("width")
                            val width: Int? = 0
                        )

                        @Serializable
                        data class Source(
                            @SerialName("height")
                            val height: Int? = 0,
                            @SerialName("url")
                            val url: String? = "",
                            @SerialName("width")
                            val width: Int? = 0
                        )

                        @Serializable
                        class Variants(
                        )
                    }
                }

                @Serializable
                data class SecureMediaEmbed(
                    @SerialName("content")
                    val content: String? = "",
                    @SerialName("height")
                    val height: Int? = 0,
                    @SerialName("media_domain_url")
                    val mediaDomainUrl: String? = "",
                    @SerialName("scrolling")
                    val scrolling: Boolean? = false,
                    @SerialName("width")
                    val width: Int? = 0
                )
            }
        }
    }
}