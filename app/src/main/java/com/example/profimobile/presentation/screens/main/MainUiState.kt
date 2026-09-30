package com.example.profimobile.presentation.screens.main

import com.example.profimobile.data.dtos.Confirmation
import com.example.profimobile.data.dtos.Notification
import com.example.profimobile.data.dtos.RatingUser
import com.example.profimobile.data.dtos.Skill
import com.example.profimobile.data.dtos.UserProfile

data class MainUiState(
    val ratingUser: RatingUser? = null,
    val skills: List<Skill> = emptyList(),
    val user: UserProfile? = null,
    val confirmations: List<Confirmation>? = null,
    val notifications: List<Notification>? = null,
    val errors: String = "",
    val isLoading: Boolean = false
)