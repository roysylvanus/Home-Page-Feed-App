package com.roysylva.feedapp.model

import com.google.gson.annotations.SerializedName

data class AttributesXX(
    @SerializedName("font")
    val font: FontXX,
    @SerializedName("text_color")
    val text_color: String
)