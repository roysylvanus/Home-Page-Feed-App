package com.roysylva.feedapp.repository


import com.roysylva.feedapp.datasource.local.FeedEntity
import com.roysylva.feedapp.datasource.local.LocalDataSource
import com.roysylva.feedapp.datasource.network.ApiInterface
import javax.inject.Inject


class HomeFeedRepository
@Inject constructor(private val localDataSource: LocalDataSource,private val apiInterface: ApiInterface){


    //in this section we make requests from our local database to confirm if its empty

    suspend fun getHomeFeedResponse(): FeedEntity = localDataSource.ensureIsNotEmpty().all()

    //if the database is empty, home feed is saved on the database

    private suspend fun LocalDataSource.ensureIsNotEmpty() = apply {
        if (isEmpty()){
            val feedEntity = apiInterface.getHomeFeed().body()?.let { FeedEntity(it.page) }
            save(feedEntity)
        }
    }
}