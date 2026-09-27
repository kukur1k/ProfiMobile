package com.example.profimobile.presentation.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(viewModel: MainViewModel){
    val rating by viewModel.rating.collectAsState()
    val skills by viewModel.skills.collectAsState()
    val user by viewModel.user.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        val currentUser = user
        if (currentUser == null) {
            Text("Загрузка профиля...", modifier = Modifier.padding(20.dp))
        } else{
            Row(modifier = Modifier
                .padding(10.dp, 20.dp)
                .fillMaxWidth()){
                currentUser.skills.forEach { skill ->
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(text = "${skill.technology} -- ${skill.level}/10")
                        if(skill.hasConfirms){
                            Text(text = "Подтверждений: ${skill.confirmsCount}")
                        }
                    }

                }
            }
        }


    }

}


