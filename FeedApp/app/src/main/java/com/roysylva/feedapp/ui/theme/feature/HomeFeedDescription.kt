package com.roysylva.feedapp.ui.theme.feature

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.roysylva.feedapp.model.Attributes
import com.roysylva.feedapp.model.CardX
import com.roysylva.feedapp.model.Description
import com.roysylva.feedapp.model.Title

//text_description card type ui

@Composable
fun HomeFeedDescription(card: CardX) {

    val title: Title = card.title
    val description: Description = card.description
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .height(100.dp)
    ) {
        Text(text = title.value,
            fontSize = (title.attributes.font.size.dp())
        )

        Text(text = description.value,
            fontSize = (description.attributes.font.size.dp()),
            fontStyle = FontStyle.Italic
        )
    }
}