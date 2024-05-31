package com.example.travels.ui.signIn

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travels.domain.user.usecase.auth.SignInUserUseCase
import com.example.travels.domain.user.UserRepository
import com.example.travels.utils.AuthErrors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUserUserCase: SignInUserUseCase,
    private val repo: UserRepository
) : ViewModel() {

    private val _signingIn = MutableStateFlow(false)

    private val _error = MutableStateFlow<AuthErrors?>(null)
    val error: StateFlow<AuthErrors?> get() = _error

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> get() = _success

    fun onSignUpClick(email: String, password: String) {
        if (!_signingIn.value) {
            signIn(email, password)
        } else {
            _error.value = AuthErrors.WAIT
        }
    }

    fun demo() {
        viewModelScope.launch { Log.d("AUTH", "${repo.demo()}") }
    }

    private fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _signingIn.value = true
            val result = signInUserUserCase.invoke(email, password)
            result.onFailure {
                Log.d("AUTH", "$it")
                _error.value = AuthErrors.UNEXPECTED
            }.onSuccess {
                _success.value = true
            }
            _signingIn.value = false
        }
    }

}