package com.roysylva.feedapp.model

import com.google.gson.annotations.SerializedName


data class HomeFeedResponse(
    @SerializedName("page")
    val page: Page
)