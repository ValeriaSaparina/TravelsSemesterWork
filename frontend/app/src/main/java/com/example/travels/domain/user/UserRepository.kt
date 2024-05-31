package com.example.travels.domain.user

interface UserRepository {
    suspend fun signUp(email: String, firstname: String, lastname: String, password: String)
    suspend fun signIn(email: String, password: String)
    suspend fun getUserById(uId: String): UserModel
    suspend fun getAllUsers() : List<UserModel>
    suspend fun demo(): String
    fun getCurrentUserId(): Long
}