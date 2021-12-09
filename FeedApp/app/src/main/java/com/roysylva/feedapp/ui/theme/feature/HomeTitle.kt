package com.roysylva.feedapp.ui.theme.feature

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.roysylva.feedapp.model.Attributes
import com.roysylva.feedapp.model.AttributesX
import com.roysylva.feedapp.model.CardX

//Home title card contains the first title of the home feed
//its data is displayed dynamically from the parameters received

@Composable
fun HomeTitle(card: CardX) {
    val attributes: Attributes = card.attributes

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)

        ) {
            Text(text = card.value,modifier = Modifier.padding(10.dp),
//                 color = colorResource(changeStringToColor(card.attributes.text_color)),
                fontFamily = FontFamily.SansSerif,
                fontSize = (attributes.font.size.dp())
            )
        }

}