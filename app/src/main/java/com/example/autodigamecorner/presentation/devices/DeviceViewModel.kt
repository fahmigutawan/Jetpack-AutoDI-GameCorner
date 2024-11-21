package com.example.autodigamecorner.presentation.devices
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autodigamecorner.data.Repository
import com.example.autodigamecorner.model.SingleDeviceResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DeviceViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    val devices = mutableStateListOf<SingleDeviceResponse>()
    val shownDeviceId = mutableStateOf("")
    init {
        viewModelScope.launch {
            repository.getAllDevice().collect{
                devices.addAll(it.data)
            }
        }
    }
}