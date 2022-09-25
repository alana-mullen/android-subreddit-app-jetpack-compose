package co.uk.thewirelessguy.androidsubredditcompose.di

import co.uk.thewirelessguy.androidsubredditcompose.data.ApiInterface
import co.uk.thewirelessguy.androidsubredditcompose.repository.RedditRepository
import co.uk.thewirelessguy.androidsubredditcompose.repository.RedditRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PostListRepositoryModule {

    @Singleton
    @Provides
    fun providePostsListRepository(
        apiInterface: ApiInterface,
        @DispatcherModule.IODispatcher dispatcher: CoroutineDispatcher
    ) : RedditRepository {
        return RedditRepositoryImpl(
            client = apiInterface,
            dispatcher = dispatcher
        )
    }
}