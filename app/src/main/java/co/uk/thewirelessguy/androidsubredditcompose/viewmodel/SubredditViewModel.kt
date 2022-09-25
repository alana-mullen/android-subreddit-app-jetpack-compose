package co.uk.thewirelessguy.androidsubredditcompose.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.uk.thewirelessguy.androidsubredditcompose.data.ResponseHandler
import co.uk.thewirelessguy.androidsubredditcompose.di.DispatcherModule
import co.uk.thewirelessguy.androidsubredditcompose.model.State
import co.uk.thewirelessguy.androidsubredditcompose.model.app.PostsSummary
import co.uk.thewirelessguy.androidsubredditcompose.repository.RedditRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SubredditViewModel @Inject constructor(
    private val repository: RedditRepository,
    private val savedStateHandle: SavedStateHandle,
    @DispatcherModule.IODispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _postsListUIState = MutableStateFlow<State<List<PostsSummary>>>(State.empty())
    val postsListUIState = _postsListUIState.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()

    suspend fun fetchPostsList(refresh: Boolean = false) {
        Timber.d("fetchPostsList")
        if (refresh) _isRefreshing.value = true
        viewModelScope.launch(dispatcher) {
            try {
                _postsListUIState.value = repository.getPosts()
            } catch (ex: Exception) {
                Timber.e(ex)
                val responseHandler = ResponseHandler()
                _postsListUIState.value = responseHandler.handleException(ex)
            }
            _isRefreshing.value = false
        }
    }
}