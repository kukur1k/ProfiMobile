package com.example.profimobile.data

import com.example.profimobile.data.dtos.ApiResponse
import com.example.profimobile.data.dtos.AuthResponse
import com.example.profimobile.data.dtos.LoginRequest
import com.example.profimobile.data.dtos.Notification
import com.example.profimobile.data.dtos.RatingUser
import com.example.profimobile.data.dtos.RefreshRequest
import com.example.profimobile.data.dtos.Skill
import com.example.profimobile.data.dtos.UserProfile
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @POST("auth/login")
    suspend fun login(@Body b: LoginRequest
    ): ApiResponse<AuthResponse>

    @POST("auth/refresh")
    suspend fun refresh(@Body request: RefreshRequest): ApiResponse<AuthResponse>

    @GET("notifications")
    suspend fun getNotifications(): ApiResponse<List<Notification>>

    @GET("users/me/rating")
    suspend fun getMyRating(): ApiResponse<RatingUser>

    @GET("users/me")
    suspend fun getProfileInform(): ApiResponse<UserProfile>

    @GET("users/me/skills")
    suspend fun getSkills(): ApiResponse<List<Skill>>
}