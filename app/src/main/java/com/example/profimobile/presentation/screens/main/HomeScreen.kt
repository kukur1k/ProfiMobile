package com.example.profimobile.presentation.screens.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LineAxis
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.keepScreenOn
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(viewModel: MainViewModel){
    val uiState by viewModel.uiState.collectAsState()


    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(15.dp)) {
        Text(
            text = "Навыки",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }

    Spacer(modifier = Modifier.height(10.dp))

    Column(modifier = Modifier.fillMaxSize()) {
        val currentUser = uiState.user
        if (currentUser == null) {
            Text("Загрузка профиля...", modifier = Modifier.padding(20.dp))
        } else{
            Column(modifier = Modifier
                .padding(10.dp, 20.dp)
                .fillMaxWidth()){
                currentUser.skills.forEach { skill ->
                    Row(modifier = Modifier.padding(10.dp)) {
                        Text(text = "${skill.technology}    ${skill.level}/10  ",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold)
                        if(skill.hasConfirms){
                            Row() {
                                repeat(skill.confirmsCount){
                                    Icon(Icons.Default.Check, null)
                                }
                            }

                        }
                    }

                }
            }


            Spacer(modifier = Modifier.height(15.dp))
            Column(modifier = Modifier
                .padding(10.dp, 20.dp)) {
                Row() {
                    Icon(Icons.Default.LineAxis, null)
                    Text(
                        text = "  Уровень доверия  ${uiState.user?.rating?.trustLevel}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                LinearProgressIndicator(progress = {
                    ((uiState.user?.rating?.trustLevel?.toFloat() ?: 0f) / 10f)
                }, modifier = Modifier.height(10.dp))
            }

            Column(modifier = Modifier
                .padding(10.dp, 20.dp)) {
                Row() {
                    Icon(Icons.Default.LineAxis, null)
                    Text(
                        text = "  Рейтинг компетенций  ${uiState.user?.rating?.competencyIndex} %",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                LinearProgressIndicator(progress = {
                    ((uiState.user?.rating?.competencyIndex?.toFloat() ?: 0f) / 10f)
                }, modifier = Modifier.height(10.dp))
            }

            Spacer(modifier = Modifier.height(10.dp))


            currentUser.confirmations.forEach { confirm ->
                Row() {
                    Text(
                        text = "  ${confirm.name}:  ${confirm.technology}   [${confirm.dateConfirm.toShortDateSkills()}]",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            uiState.notifications?.forEach { notification ->
                Row(modifier = Modifier.padding(5.dp)) {
                    Text(
                        text = "  ${notification.title}  ${notification.body}   [${notification.createdAt.toShortDateNotif()}]",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

        }





    }






}







