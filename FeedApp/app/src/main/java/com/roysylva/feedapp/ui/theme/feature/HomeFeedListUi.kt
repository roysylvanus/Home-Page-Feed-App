package com.roysylva.feedapp.ui.theme.feature

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import coil.annotation.ExperimentalCoilApi
import com.roysylva.feedapp.helper.Constants
import com.roysylva.feedapp.model.Card
import com.roysylva.feedapp.ui.theme.bars.MainTopBar
import kotlinx.coroutines.CoroutineScope

//home feed list ui is created
@ExperimentalCoilApi
@Composable
fun HomeFeedListUi(
    feedList: List<Card>,
    scaffoldState: ScaffoldState,
    isNetworkAvailable: Boolean
) {

    Scaffold (scaffoldState = scaffoldState, topBar = { MainTopBar()},
        content = {

            //network availability status is passed to ConnectivityMonitor UI
            ConnectivityMonitor(isNetworkAvailable = isNetworkAvailable,scaffoldState)

            //list is passed to homepage content
            HomePageContent(feedList)
    })
}

//lazy column previously known as recyclerview content is created and list parameter is passed to it
@ExperimentalCoilApi
@Composable
fun HomePageContent(feedList: List<Card>) {
    LazyColumn(modifier = Modifier.testTag(Constants.HOME_FEED_LIST_TAG)) {


        itemsIndexed(items = feedList) { _, item ->

        //items in the list are passed to the homeFeedListItem UI per index
            HomeFeedListItem(card = item)

        }
    }
}