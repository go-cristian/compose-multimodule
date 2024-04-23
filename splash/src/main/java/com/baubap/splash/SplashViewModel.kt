package com.baubap.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import androidx.lifecycle.viewModelScope
import com.baubap.splash.domain.CheckLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCase: CheckLoginUseCase,
) : ViewModel() {

    sealed class State {
        data object IsLoading : State()
        data object ContinueToLogin : State()
        data object ContinueWithApp : State()
    }

    private val _state: MutableStateFlow<State> by lazy { MutableStateFlow(State.IsLoading) }
    val state: StateFlow<State>
        get() = _state

    fun checkOnBoarding() {
        _state.value = State.IsLoading
        viewModelScope.launch {
            when (val response = useCase.exec()) {
                false -> {
                    _state.value = State.ContinueToLogin
                }

                true -> {
                    _state.value = State.ContinueWithApp
                }
            }
        }
    }
}