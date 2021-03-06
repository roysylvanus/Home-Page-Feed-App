package com.roysylva.feedapp.model

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("font")
    val font: Font,
    @SerializedName("text_color")
    val text_color: String
)