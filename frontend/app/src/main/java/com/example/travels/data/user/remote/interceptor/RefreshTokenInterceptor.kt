package com.example.travels.data.user.remote.interceptor

import com.example.travels.data.user.remote.MyApi
import com.example.travels.data.user.remote.entity.TokensEntity
import com.example.travels.data.user.remote.request.RefreshRequest
import com.example.travels.domain.user.TokenManager
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class RefreshTokenInterceptor (
    private val tokenManager: TokenManager,
    private val api: MyApi
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        if (response.code == 403) {
            val tokens = tokenManager.getTokens()
            tokens?.let {
                val refreshRequest = RefreshRequest(tokens.refreshToken)
                val authenticationResponseResult = runBlocking {
                    runCatching {
                        api.refreshToken(refreshRequest)
                    }.getOrNull()
                }
                authenticationResponseResult?.let {
                    val tokensEntity = TokensEntity(
                        access = it.accessToken,
                        refresh = it.refreshToken
                    )
                    tokenManager.updateTokens(tokensEntity)
                    response.close()
                    return chain.proceed(
                        Request.Builder()
                            .url(chain.request().url)
                            .addHeader("Authorization", "Bearer ${tokensEntity.access}")
                            .build()
                    )
                }
            }
        }
        return response
    }}