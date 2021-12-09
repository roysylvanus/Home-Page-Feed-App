package com.roysylva.feedapp.ui.theme.bars

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.roysylva.feedapp.R
//this is our main top bar layout
@Composable
fun MainTopBar(
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(modifier = Modifier.testTag("appTitle"),
        elevation = 4.dp,
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        actions = actions
    )
}