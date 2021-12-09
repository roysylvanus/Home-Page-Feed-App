package com.roysylva.feedapp.ui.theme.feature

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.roysylva.feedapp.helper.Constants
import com.roysylva.feedapp.model.Card
import com.roysylva.feedapp.model.Description
import com.roysylva.feedapp.model.Image
import com.roysylva.feedapp.model.Title

//Each item on the list is displayed according to the variable "card type"
//we have 3 sections; "text", "title_description" and "image_title_description"
// All of these sections have different variables and adjust dynamically in regards to the contents they bear

@ExperimentalCoilApi
@Composable
fun HomeFeedListItem(card: Card) {

        Surface() {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                // card type is queried to display the items in their right positions

                    when (card.card_type) {

                        //text type

                        Constants.CARD_TYPE_TEXT -> {

                            HomeTitle(card.card)

                        }
                        //title_description

                        Constants.CARD_TYPE_TEXT_DESCRIPTION -> {
                            HomeFeedDescription(card.card)

                        }
                        //image_title_description

                       Constants.CARD_TYPE_IMAGE -> {

                            val image: Image = card.card.image
                            val title: Title = card.card.title
                            val description: Description = card.card.description

                            ImageCard(image = image, title = title, description = description)

                        }
                    }


            }

    }

}
//text size unit is converted from into to sp

@Composable
fun Int.dp() = with(LocalDensity.current) {  Dp(this@dp.toFloat()).toSp()  }











