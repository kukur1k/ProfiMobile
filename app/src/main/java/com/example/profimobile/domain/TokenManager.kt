package com.example.profimobile.domain

import android.content.Context
import android.content.SharedPreferences


class TokenManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("app", Context.MODE_PRIVATE)

    fun saveTokens(access: String, refresh: String, role: String) {
        prefs.edit().putString("access", access).putString("refresh", refresh).putString("role", role).apply()
    }

    fun getAccess(): String? = prefs.getString("access", null)
    fun getRefresh(): String? = prefs.getString("refresh", null)
    fun getRole(): String? = prefs.getString("role", null)

    fun isLoggedIn(): Boolean = getAccess() != null

    fun savePin(pin: String) = prefs.edit().putString("pin", pin).apply()
    fun getPin(): String? = prefs.getString("pin", null)
    fun isPinSet(): Boolean = getPin() != null

    fun clear() = prefs.edit().clear().apply()
    fun checkPin(it: String): Boolean {
        return it== getPin()
    }
}
