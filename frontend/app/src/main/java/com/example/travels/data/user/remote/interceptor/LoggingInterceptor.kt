package com.example.travels.data.user.remote.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        Log.d("LOG", "${chain.request()}; ${chain.request().body}")
        val response = chain.proceed(chain.request())
        Log.d("LOG", "${response}; ${response.body}")
        return response
    }
}