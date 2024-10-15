package com.example.practicainvestigacion.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DemoViewModel : ViewModel() {
    private  val _uiState = MutableStateFlow(DemoUiState())
    val uiState: StateFlow<DemoUiState> = _uiState.asStateFlow()


    fun updateDemoState(apellido: String){
        _uiState.update { currentState ->
            currentState.copy( apellido = apellido)
        }
    }

}