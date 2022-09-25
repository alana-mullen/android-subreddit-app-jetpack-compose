package co.uk.thewirelessguy.androidsubredditcompose.data

import co.uk.thewirelessguy.androidsubredditcompose.model.api.SubredditResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("hot.json?limit=10")
    suspend fun getData(
        @Query("after") after: Int? = null
    ): SubredditResponse
}