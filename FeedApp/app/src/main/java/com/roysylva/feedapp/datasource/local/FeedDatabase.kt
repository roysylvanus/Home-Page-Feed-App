package com.roysylva.feedapp.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

//in this class database we define the database and its type converter class which converts feedEntity data to String and vice versa
@Database(entities = [FeedEntity::class], version = 1, exportSchema = true)
@TypeConverters(FeedTypeConverter::class)
abstract class FeedDatabase :RoomDatabase() {
    abstract fun feedDao():FeedDao
}