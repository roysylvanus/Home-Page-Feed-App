package com.roysylva.feedapp.ui


import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import coil.annotation.ExperimentalCoilApi
import com.roysylva.feedapp.CallApi
import com.roysylva.feedapp.MainActivity
import com.roysylva.feedapp.helper.Constants
import com.roysylva.feedapp.model.*
import com.roysylva.feedapp.ui.theme.feature.HomePageContent
import com.roysylva.feedapp.ui.theme.feature.LoadingIndicator
import org.junit.Rule
import org.junit.Test


import org.junit.runner.RunWith


@ExperimentalMaterialApi
@ExperimentalCoilApi
@RunWith(AndroidJUnit4::class)
class FeedComposeTest {


    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    //test that app title is displayed
    @Test
    fun testAppTitleIsDisplayed(){
        composeTestRule.onNode(hasTestTag(Constants.TEST_APP_TITLE_TAG),true).assertIsDisplayed()
    }

    //test that snackBar is displayed
    @Test
    fun testSnackBarIsDisplayed(){
        composeTestRule.setContent {

            CallApi(isNetworkAvailable = true)

        }
        composeTestRule.onNodeWithText("There is a problem with your network connection. Please check your settings.").assertExists()


    }

    //test that list view is empty on home page ui
    @Test
    fun testHomeFeedListUiIfListIsEmpty(){
        
        composeTestRule.setContent {
            HomePageContent(feedList = emptyList())
        }

        composeTestRule.onNodeWithTag(Constants.HOME_FEED_LIST_TAG).onChildren().assertCountEquals(0)
    }

    //test that list is not empty on home page ui
    @Test
    fun testHomeFeedIfListIsNotEmpty(){

        val fontXX = FontXX(Constants.FONT_TEST)
        val attrXX = AttributesXX(fontXX,Constants.TEXT_COLOR_TEST)
        val fontX = FontX(Constants.FONT_TEST)
        val attrX = AttributesX(fontX,Constants.TEXT_COLOR_TEST)
        val size = Size(Constants.SIZE_TEST,Constants.SIZE_TEST)
        val font = Font(Constants.FONT_TEST)
        val title = Title(attrXX,Constants.TITLE_VALUE_TEST)
        val image = Image(size, Constants.IMAGE_URL_TEST)
        val description = Description(attrX,Constants.DESC_VALUE_TEST)
        val attr = Attributes(font,Constants.TEXT_COLOR_TEST)
        val cardX = CardX(attr,description,image,title,Constants.TITLE_VALUE_TEST)
        val card = Card(cardX,Constants.CARD_TYPE_TEST)
        val cards = listOf(card)

        composeTestRule.setContent {
            HomePageContent(cards)
        }

        composeTestRule.onNodeWithTag(Constants.HOME_FEED_LIST_TAG).onChildren().assertCountEquals(1)

    }

    //test circular progress indicator is displayed

    @Test
    fun testCircularProgressIndicatorIsDisplayed(){
        composeTestRule.setContent {
            LoadingIndicator()
        }
        composeTestRule.onNode(hasTestTag(Constants.CIRCULAR_PROGRESS_TEST),true).assertIsDisplayed()
    }







}