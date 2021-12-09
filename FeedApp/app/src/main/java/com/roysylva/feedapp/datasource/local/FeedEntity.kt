package com.roysylva.feedapp.datasource.local


import androidx.room.Entity
import androidx.room.PrimaryKey

import com.roysylva.feedapp.model.Page
//this is the the our database
@Entity(tableName = "feed_table")
class FeedEntity(var page:Page){

    @PrimaryKey(autoGenerate = false)
    var id:Int = 0

}
