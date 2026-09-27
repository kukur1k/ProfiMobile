package com.example.profimobile.presentation.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profimobile.data.NetworkModule
import com.example.profimobile.data.dtos.RatingUser
import com.example.profimobile.data.dtos.Skill
import com.example.profimobile.data.dtos.UserProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val _rating = MutableStateFlow<RatingUser?>(null)
    val rating = _rating.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val _skills = MutableStateFlow<List<Skill>>(emptyList())
    val skills = _skills.asStateFlow()

    private val _user = MutableStateFlow<UserProfile?>(null)
    val user = _user.asStateFlow()

    init{
        loadRating()
        loadSkills()
        loadUser()
    }

    fun loadRating(){
        viewModelScope.launch {
            try {
                val res = NetworkModule.api.getMyRating()
                if (res.success == true){
                    _rating.value = res.data
                }
            } catch (ex: Exception){

            }
        }
    }

    fun loadSkills(){
        viewModelScope.launch {
            try {
                val res = NetworkModule.api.getSkills()
                if (res.success == true){
                    _skills.value = res.data!!
                }
            } catch (ex: Exception){

            }
        }
    }

    fun loadUser(){
        viewModelScope.launch {
            try {
                val res = NetworkModule.api.getProfileInform()
                Log.d("MainViewModel", "getProfileInform response = $res")
                if (res.success == true){
                    _user.value = res.data
                }
            } catch (ex: Exception){
                Log.e("MainViewModel", "loadUser FAILED", ex)
            }
        }
    }
}