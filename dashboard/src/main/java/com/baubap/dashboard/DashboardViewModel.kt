package com.baubap.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baubap.common.Response
import com.baubap.dashboard.domain.AccountData
import com.baubap.dashboard.domain.GetAccountStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getAccountStateUseCase: GetAccountStateUseCase
) : ViewModel() {

    sealed class State {
        data object IsLoading : State()
        data class Loaded(val data: AccountData) : State()
        data object Error : State()
    }

    private val _state: MutableStateFlow<State> by lazy { MutableStateFlow(State.IsLoading) }
    val state: StateFlow<State>
        get() = _state

    fun getAccountState() {
        _state.value = State.IsLoading
        viewModelScope.launch {
            when (val response = getAccountStateUseCase.exec()) {
                is Response.Success -> {
                    _state.value = State.Loaded(response.data)
                }

                is Response.Failure -> {
                    _state.value = State.Error
                }
            }
        }

    }
}