package com.bharathwaj.composeapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.bharathwaj.composeapp.R

@Composable
fun ProfileScreen(){
    Column(
        Modifier.fillMaxSize().background(Color.Black),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Icon(
            painterResource(id = R.drawable.user),
            "profile",
            tint = Color.Yellow
        )
        Text("Profile", color = Color.Yellow)
    }
}