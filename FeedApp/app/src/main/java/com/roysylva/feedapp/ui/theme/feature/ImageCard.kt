package com.roysylva.feedapp.ui.theme.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.roysylva.feedapp.model.Description
import com.roysylva.feedapp.model.Image
import com.roysylva.feedapp.model.Title

//Image card ui is created
//Each of its parameters are passed to the relevant section it should make changes dynamically

@ExperimentalCoilApi
@Composable
fun ImageCard(image: Image, title: Title, description: Description) {

    Card(modifier = Modifier.fillMaxSize()) {



           Box(modifier = Modifier.fillMaxSize()) {
               Image(
                   painter = rememberImagePainter(image.url),
                   contentDescription = null,
                   contentScale = ContentScale.FillBounds,

                   //height and width are retrieved from image size parameters
                   modifier = Modifier
                       .height(image.size.height.dp)
                       .width(image.size.width.dp)
               )

                   Column(modifier = Modifier.fillMaxWidth().align(Alignment.BottomStart).padding(15.dp),
                       verticalArrangement = Arrangement.Bottom) {

                       //title and description attributes are passed respectively
                       Text(text = title.value,
                           color = Color.White,
                           fontSize = title.attributes.font.size.dp())


                       Text(text = description.value,
                           color = Color.White,
                           fontSize = description.attributes.font.size.dp())
                   }

           }






    }
}


