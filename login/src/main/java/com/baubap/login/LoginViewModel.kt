package com.baubap.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baubap.login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    sealed class State {
        data object Idle : State()
        data object IsLoading : State()
        data object LoggedIn : State()
        data object LoginFailed : State()
    }

    private val _state: MutableStateFlow<State> by lazy { MutableStateFlow(State.Idle) }
    val state: StateFlow<State>
        get() = _state

    fun login(email: String, password: String) {
        _state.value = State.IsLoading
        viewModelScope.launch {
            val response = loginUseCase.login(email, password)
            when (response) {
                is com.baubap.common.Response.Success -> {
                    _state.value = State.LoggedIn
                }

                is com.baubap.common.Response.Failure -> {
                    _state.value = State.LoginFailed
                }
            }
        }

    }
}