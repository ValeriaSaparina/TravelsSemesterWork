package com.example.travels.di

import com.example.travels.BuildConfig
import com.example.travels.data.places.remote.PlacesApi
import com.example.travels.data.routes.remote.RoutesApi
import com.example.travels.data.user.remote.MyApi
import com.example.travels.data.user.remote.interceptor.AccessTokenInterceptor
import com.example.travels.data.user.remote.interceptor.LoggingInterceptor
import com.example.travels.data.user.remote.interceptor.RefreshTokenInterceptor
import com.example.travels.domain.user.TokenManager
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideApiKeyInterceptor(): LoggingInterceptor = LoggingInterceptor()

    @Provides
    fun provideAccessTokenInterceptor(tokenManager: TokenManager): AccessTokenInterceptor =
        AccessTokenInterceptor(tokenManager)

    @Provides
    fun provideRefreshInterceptor(api: MyApi, tokenManager: TokenManager): RefreshTokenInterceptor =
        RefreshTokenInterceptor(tokenManager, api)

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: LoggingInterceptor,
        accessTokenInterceptor: AccessTokenInterceptor,
//        refreshTokenInterceptor: RefreshTokenInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(accessTokenInterceptor)
//            .addInterceptor(refreshTokenInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthApi(
        okHttpClient: OkHttpClient,
    ): MyApi {
        val networkJson = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl(BuildConfig.PLACES_API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .build().create(MyApi::class.java)
    }

    @Singleton
    @Provides
    fun providePlacesApi(
        okHttpClient: OkHttpClient,
    ): PlacesApi {
        val networkJson = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl("${BuildConfig.PLACES_API_BASE_URL}places/")
            .client(okHttpClient)
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .build().create(PlacesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRoutesApi(
        okHttpClient: OkHttpClient,
    ): RoutesApi {
        val networkJson = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl("${BuildConfig.PLACES_API_BASE_URL}routes/")
            .client(okHttpClient)
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .build().create(RoutesApi::class.java)
    }

}