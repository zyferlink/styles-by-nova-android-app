package novalogics.android.styles.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import novalogics.android.styles.data.repository.HomeRepositoryOffline
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRepository(): HomeRepositoryOffline {
        return HomeRepositoryOffline()
    }
}
