package com.roysylva.feedapp.ui.theme.feature

import androidx.compose.material.ScaffoldState
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import com.roysylva.feedapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


//SnackBar ui is created

@Composable
fun ConnectivityMonitor(
    isNetworkAvailable: Boolean,
    scaffoldState: ScaffoldState,
){
    val connectionString = stringResource(id = R.string.network_disconnected)

    //check network available parameter so as to pass the relevant connection string
    if (isNetworkAvailable){
        LaunchedEffect(key1 = 5000, block = {
            scaffoldState.snackbarHostState.showSnackbar(connectionString)
        })
    }



}