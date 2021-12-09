package com.roysylva.feedapp.model

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("card")
    val card: CardX,
    @SerializedName("card_type")
    val card_type: String
)