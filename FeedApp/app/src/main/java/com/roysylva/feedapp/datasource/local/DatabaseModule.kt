package com.roysylva.feedapp.datasource.local

import android.content.Context
import androidx.room.Room
import com.roysylva.feedapp.helper.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    //I have created a singleton object to provide database once when the app is created

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context,
    FeedDatabase::class.java, Constants.HOME_FEED_DB).build()

    @Singleton
    @Provides
    fun provideDao(database: FeedDatabase) = database.feedDao()


}