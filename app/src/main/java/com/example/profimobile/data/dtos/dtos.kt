package com.example.profimobile.data.dtos

import android.os.Message
import android.provider.ContactsContract
import java.util.logging.Level

data class ApiResponse<T>(
    val success: Boolean?,
    val message: String?,
    val errorCode: String?,
    val data: T?
)

data class LoginRequest(val email: String, val password: String)

data class AuthResponse(
    val accessToken:  String,
    val refreshToken: String,
    val role:         String
)
data class RefreshRequest(val refreshToken: String)

data class Notification(
    val id: Int,
    val body: String,
    val createdAt: String,
    val isRead: Boolean,
    val relatedId: Any,
    val title: String,
    val type: String,
    val userId: Int
)

data class RatingUser(
    val calculateAt: String,
    val competencyIndex: Double,
    val confirmsCount: Int,
    val trustLevel: Double
)

data class ConfirmationsIncoming(
    val count: Int,
    val items: List<Confirmation>
)
data class Confirmation(
    val createdAt: String,
    val id: Int,
    val requesterId: Int,
    val requesterName: String,
    val skillLevel: Int,
    val technology: String,
    val status: String? = ""
)

data class resConfirm(
    val id: Int,
    val status: String? = "",
    val respondedAt: String,
)

data class Skill(
    val technology: String,
    val level: Int,
    val confirmsCount: Int,
    val hasConfirms: Boolean = false
)

data class ConfirmationsUser(
    val name: String,
    val technology: String,
    val dateConfirm: String
)

data class UserProfile(
    val id: Int,
    val lastName: String,
    val firstName: String,
    val middleName: String,
    val email: String,
    val phone: String?,
    val registeredAt: String,
    val rating: RatingUser,
    val skills: List<Skill>,
    val confirmations: List<ConfirmationsUser>,
    val role: String,
)
