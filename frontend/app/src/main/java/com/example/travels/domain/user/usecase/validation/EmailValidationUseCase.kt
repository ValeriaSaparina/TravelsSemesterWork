package com.example.travels.domain.user.usecase.validation

import android.util.Patterns
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EmailValidationUseCase @Inject constructor() {
    operator fun invoke(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
}