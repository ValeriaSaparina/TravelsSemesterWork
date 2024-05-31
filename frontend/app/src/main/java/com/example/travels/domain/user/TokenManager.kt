package com.example.travels.domain.user

import android.content.Context
import android.content.SharedPreferences
import com.example.travels.data.user.remote.entity.TokensEntity
import com.example.travels.data.user.remote.response.TokenResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(
    @ApplicationContext context: Context
) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("tokens", Context.MODE_PRIVATE)

    fun saveTokens(accessToken: String, refreshToken: String) {
        val editor = sharedPreferences.edit()
        editor.putString("accessToken", accessToken)
        editor.putString("refreshToken", refreshToken)
        editor.apply()
    }

    fun getAccessToken(): String? {
        return sharedPreferences.getString("accessToken", null)
    }

    fun getRefreshToken(): String? {
        return sharedPreferences.getString("refreshToken", null)
    }

    fun clearTokens() {
        val editor = sharedPreferences.edit()
        editor.remove("accessToken")
        editor.remove("refreshToken")
        editor.apply()
    }

    fun getTokens(): TokenResponse? {
        val refresh = getRefreshToken()
        val access = getAccessToken()
        return if (refresh != null && access != null) {
            TokenResponse(accessToken = access, refreshToken = refresh)
        } else {
            null
        }
    }

    fun updateTokens(tokensEntity: TokensEntity) {
        clearTokens()
        saveTokens(tokensEntity.access!!, tokensEntity.refresh!!)
    }

}
