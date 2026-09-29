package com.example.profimobile.data

import android.content.Context
import com.example.profimobile.data.dtos.RefreshRequest
import com.example.profimobile.domain.TokenManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NetworkModule {

//    private lateinit var tokenManager: TokenManager
//    private const val BASE_URL = "http://10.0.2.2:5222/"
//
//    fun init(context: Context) {
//        tokenManager = TokenManager(context)
//    }
//
//    private fun getClientWithToken(): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor { chain ->
//                val request = chain.request().newBuilder()
//                tokenManager.getAccess()?.let {
//                    request.header("Authorization", "Bearer $it")
//                }
//                chain.proceed(request.build())
//            }
//            .build()
//    }
//
//
//    val api: Api by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(getClientWithToken())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(Api::class.java)
//    }
//
//    suspend fun refreshAccessToken(): Boolean {
//        return try {
//            val refresh = tokenManager.getRefresh() ?: return false
//            val response = api.refresh(RefreshRequest(refresh))
//            if (response.success == true && response.data != null) {
//                tokenManager.saveTokens(
//                    response.data.accessToken,
//                    response.data.refreshToken,
//                    tokenManager.getRole() ?: ""
//                )
//                true
//            } else false
//        } catch (e: Exception) {
//            false
//        }
//    }

    private const val BASE_URL = "http://10.0.2.2:5222/"
    private const val TEST_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjEiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiJ0ZXN0QHRlc3QuY29tIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiYWRtaW4iLCJleHAiOjE3OTA3MjEyODksImlzcyI6Iml0cHJvZi1hcGkiLCJhdWQiOiJpdHByb2YtY2xpZW50cyJ9.hoo_-clYqtqSeCCNcoXvTbSfrTb9AkWqiJSc45uBqLg"

    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .header("Authorization", "Bearer $TEST_TOKEN")
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    val api: Api by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    suspend fun refreshAccessToken(): Boolean = false

}