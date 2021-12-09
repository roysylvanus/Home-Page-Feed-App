package com.roysylva.feedapp.ui.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.roysylva.feedapp.datasource.local.FeedDao
import com.roysylva.feedapp.datasource.local.FeedDatabase
import com.roysylva.feedapp.datasource.local.FeedEntity
import com.roysylva.feedapp.helper.Constants
import com.roysylva.feedapp.model.*
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FeedDatabaseTest : TestCase(){

    private lateinit var db: FeedDatabase
    private lateinit var dao: FeedDao


    //setup database

    @Before
    public override fun setUp(){
        val context  =ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, FeedDatabase::class.java).build()

        dao = db.feedDao()
    }


    //close database after test

    @After
    fun closeDB(){
        db.close()
    }

    //test write and read database

    @Test
    fun writeAndReadDatabase() = runBlocking{
        val fontXX = FontXX(Constants.FONT_TEST)
        val attrXX = AttributesXX(fontXX, Constants.TEXT_COLOR_TEST)
        val fontX = FontX(Constants.FONT_TEST)
        val attrX = AttributesX(fontX, Constants.TEXT_COLOR_TEST)
        val size = Size(Constants.SIZE_TEST, Constants.SIZE_TEST)
        val font = Font(Constants.FONT_TEST)
        val title = Title(attrXX, Constants.TITLE_VALUE_TEST)
        val image = Image(size, Constants.IMAGE_URL_TEST)
        val description = Description(attrX, Constants.DESC_VALUE_TEST)
        val attr = Attributes(font, Constants.TEXT_COLOR_TEST)
        val cardX = CardX(attr,description,image,title, Constants.TITLE_VALUE_TEST)
        val card = Card(cardX, Constants.CARD_TYPE_TEST)
        val cards = listOf(card)
        val page = Page(cards)
        val feedEntity = FeedEntity(page)

        dao.insertFeed(feedEntity)

       val feed = dao.readFeed()

        assertThat(feed.page.cards.contains(card)).isTrue()

    }
}