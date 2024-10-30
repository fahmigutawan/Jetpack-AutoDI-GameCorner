package com.example.autodigamecorner.presentation.guide

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autodigamecorner.data.Repository
import com.example.autodigamecorner.model.SingleGuideStepResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){
    val guides = mutableStateListOf<SingleGuideStepResponse>()

    init {
        viewModelScope.launch {
            repository.getAllGuide().collect{
                guides.addAll(it.data.sortedBy { it.order })
            }
        }
    }
}