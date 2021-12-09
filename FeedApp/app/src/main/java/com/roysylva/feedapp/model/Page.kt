package com.roysylva.feedapp.model

import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("cards")
    val cards: List<Card>
)