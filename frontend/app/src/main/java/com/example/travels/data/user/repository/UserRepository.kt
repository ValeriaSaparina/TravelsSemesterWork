package com.example.travels.data.user.repository

import android.util.Log
import com.example.travels.data.user.remote.MyApi
import com.example.travels.data.user.remote.request.AuthRequest
import com.example.travels.data.user.remote.request.UserRequest
import com.example.travels.data.user.remote.response.TokenResponse
import com.example.travels.domain.user.TokenManager
import com.example.travels.domain.user.UserModel
import com.example.travels.domain.user.UserRepository
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val tokenManager: TokenManager,
    private val api: MyApi
) : UserRepository {

    override suspend fun signUp(
        email: String,
        firstname: String,
        lastname: String,
        password: String
    ) {
        val tokens = api.register(
            UserRequest(
                email, password, firstname, lastname
            )
        )
        saveTokens(tokens)
    }

    private fun saveTokens(tokens: TokenResponse?) {
        Log.d("AUTH", "${tokens?.refreshToken};\n${tokens?.accessToken} ")
        if (tokens != null) {
            tokenManager.saveTokens(tokens.accessToken!!, tokens.refreshToken!!)
        }
    }

    override suspend fun signIn(email: String, password: String) {
        val tokens = api.auth(AuthRequest(email, password))
        saveTokens(tokens)
    }

    override suspend fun demo(): String {
        return api.demo().demo
    }

    override fun getCurrentUserId(): Long {
        return api.getCurrentUser().id
    }


    override suspend fun getUserById(uId: String): UserModel {
        TODO("Impl")
//        return UserModel("", "", "", "")
    }

    override suspend fun getAllUsers(): List<UserModel> {
        TODO("Impl")
//        return api.getAllUsers()
    }

}