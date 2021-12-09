package com.roysylva.feedapp.ui.theme.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import com.roysylva.feedapp.helper.Constants
import com.roysylva.feedapp.ui.theme.bars.MainTopBar
import kotlinx.coroutines.CoroutineScope


@Composable
fun LoadingUi(scaffoldState: ScaffoldState, isNetworkAvailable: Boolean) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { MainTopBar() },
        content = {
            //loading indicator function is initiated
            LoadingIndicator()

            //network availability boolean is passed to a composable function
            ConnectivityMonitor(isNetworkAvailable = isNetworkAvailable,scaffoldState)
        },
    )
}

//load circular progress indicator is displayed
@Composable
fun LoadingIndicator() {

    //Indicator layout is created
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = Color.Black, modifier = Modifier.testTag(Constants.CIRCULAR_PROGRESS_TEST))
    }
}