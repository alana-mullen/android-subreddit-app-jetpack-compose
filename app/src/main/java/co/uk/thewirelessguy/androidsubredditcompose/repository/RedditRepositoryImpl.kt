package co.uk.thewirelessguy.androidsubredditcompose.repository

import co.uk.thewirelessguy.androidsubredditcompose.data.ApiInterface
import co.uk.thewirelessguy.androidsubredditcompose.data.ResponseHandler
import co.uk.thewirelessguy.androidsubredditcompose.di.DispatcherModule
import co.uk.thewirelessguy.androidsubredditcompose.model.State
import co.uk.thewirelessguy.androidsubredditcompose.model.app.PostsSummary
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class RedditRepositoryImpl @Inject constructor(
    private val client: ApiInterface,
    @DispatcherModule.IODispatcher private val dispatcher: CoroutineDispatcher,
) : RedditRepository {

    override suspend fun getPosts(): State<List<PostsSummary>> {
        val responseHandler = ResponseHandler()

        return withContext(dispatcher) {
            try {
                Timber.d("getPosts")
                val response = client.getData()
                val summary = PostsSummary.from(response)
                return@withContext responseHandler.handleSuccess(summary)
            } catch (ex: Exception) {
                Timber.e(ex)
                return@withContext responseHandler.handleException(ex)
            }
        }
    }
}