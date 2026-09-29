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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {


    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()



    init{
        loadData()
    }

    fun loadData(){
        loadRating()
        loadSkills()
        loadUser()
    }

    fun loadRating(){
        viewModelScope.launch {
            try {
                val res = NetworkModule.api.getMyRating()
                if (res.success == true){
                    _uiState.update { it.copy(ratingUser = res.data) }
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
                    _uiState.update { it.copy(skills = res.data!!) }
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
                    _uiState.update { it.copy(user = res.data) }

                }
            } catch (ex: Exception){
                Log.e("MainViewModel", "loadUser FAILED", ex)
            }
        }
    }
}