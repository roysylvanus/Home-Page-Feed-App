package com.roysylva.feedapp.datasource.local

import javax.inject.Inject


// this is the local database source file that we use to save and receive data to and from our repository

class LocalDataSource
@Inject constructor(feedDatabase: FeedDatabase){
    private val feedEntity = feedDatabase.feedDao()

    //read all data in the database

    fun all(): FeedEntity = feedEntity.readFeed()

    //save data tp database

    suspend fun save(feedEntity: FeedEntity?){
        feedEntity?.let { this.feedEntity.insertFeed(it) }
    }

    //check if database is empty

    suspend fun isEmpty(): Boolean = feedEntity.count() == 0L

}