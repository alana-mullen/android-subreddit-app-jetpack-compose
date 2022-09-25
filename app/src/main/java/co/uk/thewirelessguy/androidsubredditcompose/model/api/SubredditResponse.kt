package co.uk.thewirelessguy.androidsubredditcompose.model.api

import kotlinx.serialization.Serializable

@Serializable
data class SubredditResponse(
    val data: Datum? = Datum(),
) {
    @Serializable
    data class Datum(
        val after: String? = "",
        val before: String? = "",
        val children: List<Children>? = listOf(),
    ) {
        @Serializable
        data class Children(
            val data: Datum? = Datum(),
        ) {
            @Serializable
            data class Datum(
                val author: String? = "",
                val id: String? = "",
                val permalink: String? = "",
                val thumbnail: String? = "",
                val title: String? = "",
            )
        }
    }
}