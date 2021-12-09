package com.roysylva.feedapp.model

import com.google.gson.annotations.SerializedName

data class AttributesX(
    @SerializedName("font")
    val font: FontX,
    @SerializedName("text_color")
    val text_color: String
)