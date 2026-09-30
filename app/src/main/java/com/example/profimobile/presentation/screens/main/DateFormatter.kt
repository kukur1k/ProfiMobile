package com.example.profimobile.presentation.screens.main

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
private val shortDateFormatter = DateTimeFormatter.ofPattern("dd.MM")

@RequiresApi(Build.VERSION_CODES.O)
fun String.toShortDateSkills(): String = try {
    OffsetDateTime.parse(this).format(shortDateFormatter)
} catch (e: Exception) {
    this
}


@RequiresApi(Build.VERSION_CODES.O)
fun String.toShortDateNotif(): String = try {
    LocalDateTime.parse(this).format(shortDateFormatter)
} catch (e: Exception) {
    this
}