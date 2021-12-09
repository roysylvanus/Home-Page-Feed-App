package com.roysylva.feedapp



import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.roysylva.feedapp.datasource.local.FeedDatabase
import com.roysylva.feedapp.datasource.local.FeedEntity
import com.roysylva.feedapp.datasource.local.LocalDataSource
import com.roysylva.feedapp.datasource.network.ApiInterface
import com.roysylva.feedapp.helper.Constants
import com.roysylva.feedapp.model.*
import com.roysylva.feedapp.repository.HomeFeedRepository
import com.roysylva.feedapp.viewmodel.HomeFeedViewModel
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class HomeFeedViewModelTest : TestCase(){

    private lateinit var viewModel: HomeFeedViewModel
    private lateinit var apiInterface: ApiInterface
    private lateinit var repository: HomeFeedRepository
    private lateinit var dataSource: LocalDataSource

    //setup Home feed view model
    @Before
    public override fun setUp() {
        super.setUp()

        val context  = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.inMemoryDatabaseBuilder(context, FeedDatabase::class.java)
            .allowMainThreadQueries().build()

         dataSource = LocalDataSource(db)
         repository = HomeFeedRepository(dataSource, apiInterface)
        viewModel = HomeFeedViewModel(repository)


    }

    //test view model by reading home feed value
    //failed test case, still trying to figure out how to use state flows on test
    @Test
    fun testHomeFeedInViewModel() = runBlocking{
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

        dataSource.save(feedEntity)
        viewModel.load()
        val feed = viewModel.homeFeed.value.size

        //assert if feed is not null

        assertThat(feed).isNotEqualTo(null)

    }







}