package com.baubap.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baubap.common.repositories.User
import com.baubap.profile.domain.GetUserUseCase
import com.baubap.profile.domain.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCase: GetUserUseCase,
    private val logoutUseCase: LogoutUseCase,
) : ViewModel() {

    sealed class State {
        data object IsLoading : State()
        data class Idle(val user: User) : State()
        data object LoggedOut : State()
    }

    private val _state: MutableStateFlow<State> by lazy { MutableStateFlow(State.IsLoading) }
    val state: StateFlow<State>
        get() = _state

    fun getUser() {
        _state.value = State.IsLoading
        viewModelScope.launch {
            val user = useCase.exec()
            _state.value = State.Idle(user)
        }
    }

    fun logout() {
        viewModelScope.launch {
            _state.value = State.IsLoading
            logoutUseCase.exec()
            _state.value = State.LoggedOut
        }
    }
}