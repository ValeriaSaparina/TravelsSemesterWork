package com.example.travels.data.user.mapper

import com.example.travels.data.user.remote.response.UserResponse
import com.example.travels.domain.user.UserModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDomainMapper @Inject constructor() {
    fun toDomainModel(response: UserResponse?): UserModel {
        return response?.run {
            UserModel(
                id = id,
                email = email,
                firstname = firstname,
                lastname = lastname
            )
        } ?: UserModel(
            id = -1,
            email = "",
            firstname = "",
            lastname = ""
        )
    }


}