package com.roysylva.feedapp.datasource.local

import androidx.room.*

//this is an interface that governs the operations on inserting,reading and updating the database
@Dao
interface FeedDao {

    //here we insert the feedEntity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFeed(feedEntity: FeedEntity)

    //here we read the feedEntity
    @Query("SELECT * FROM feed_table")
    fun readFeed(): FeedEntity

    //here we update the feedEntity in the database
    @Update
    suspend fun updateFeed(feedEntity: FeedEntity)

    //here we count the feedEntity in the database
    @Query("select count(*) from feed_table")
    suspend fun count(): Long
}