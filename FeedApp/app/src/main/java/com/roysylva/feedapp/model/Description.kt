package com.roysylva.feedapp.model

import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("attributes")
    val attributes: AttributesX,
    @SerializedName("value")
    val value: String
)