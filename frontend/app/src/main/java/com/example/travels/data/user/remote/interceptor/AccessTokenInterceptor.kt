package com.example.travels.data.user.remote.interceptor

import com.example.travels.domain.user.TokenManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AccessTokenInterceptor(
    private val tokenManager: TokenManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
//        if (request.headers.contains(Pair("Authorization", "true"))) {
            val tokens = tokenManager.getAccessToken()
            tokens?.let {
                val newRequest = request.newBuilder()
                    .header("Authorization", "Bearer ${it}")
                    .build()
                return chain.proceed(newRequest)
            }
//        }
        return chain.proceed(request)
    }
}