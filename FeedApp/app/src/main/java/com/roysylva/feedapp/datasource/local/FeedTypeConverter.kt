package com.roysylva.feedapp.datasource.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.roysylva.feedapp.model.Page

//this is the class that we use to convert the feedEntity(page) to string and vice versa using gson
class FeedTypeConverter {
    val gson = Gson()

    @TypeConverter
    fun pageToString(page: Page):String{
        return gson.toJson(page)
    }

    @TypeConverter
    fun stringToPage(pageString:String):Page{
        val objectType = object: TypeToken<Page>(){}.type
        return gson.fromJson(pageString,objectType)
    }
}