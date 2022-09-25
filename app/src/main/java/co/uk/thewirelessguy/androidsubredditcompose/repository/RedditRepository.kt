package co.uk.thewirelessguy.androidsubredditcompose.repository

import co.uk.thewirelessguy.androidsubredditcompose.model.State
import co.uk.thewirelessguy.androidsubredditcompose.model.app.PostsSummary

interface RedditRepository {

    suspend fun getPosts(): State<List<PostsSummary>>
}