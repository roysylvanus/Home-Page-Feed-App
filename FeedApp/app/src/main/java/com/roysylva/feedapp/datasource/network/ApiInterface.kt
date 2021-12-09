package com.roysylva.feedapp.datasource.network

import com.roysylva.feedapp.helper.Constants
import com.roysylva.feedapp.model.HomeFeedResponse
import retrofit2.Response
import retrofit2.http.GET
//this is the interface that requests data remotely from our api
interface ApiInterface {

    @GET(Constants.HOME_FEED)
    suspend fun getHomeFeed(): Response<HomeFeedResponse>
}