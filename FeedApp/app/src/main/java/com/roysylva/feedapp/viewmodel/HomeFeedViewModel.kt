package com.roysylva.feedapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roysylva.feedapp.model.Card
import com.roysylva.feedapp.repository.HomeFeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeFeedViewModel
@Inject constructor(private val homeFeedRepository: HomeFeedRepository) : ViewModel() {

    //we use state flows to collect values on current state
    private val _isLoading = MutableStateFlow(true)
    val isLoading:StateFlow<Boolean> = _isLoading

    private val _homeFeed = MutableStateFlow(emptyList<Card>())
    val homeFeed: StateFlow<List<Card>> = _homeFeed


    //in this section we load values from our repository

    fun load() = effect {

        //here we confirm the state of our network request
        _isLoading.value = true
        try {

            //a list of cards is retrieved from the home feed
            _homeFeed.value = homeFeedRepository.getHomeFeedResponse().page.cards

        } catch (e: Exception) {

            Log.d("ERROR", "unknown error view model response: ${e.localizedMessage}")

        }
        _isLoading.value = false

    }

    private fun effect(block: suspend () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) { block() }
    }

}


