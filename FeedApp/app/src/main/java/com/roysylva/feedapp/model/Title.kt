package com.roysylva.feedapp.model

import com.google.gson.annotations.SerializedName

data class Title(
    @SerializedName("attributes")
    val attributes: AttributesXX,
    @SerializedName("value")
    val value: String
)