package com.bharathwaj.composeapp.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import com.bharathwaj.composeapp.R
import com.bharathwaj.composeapp.data.BottomNavItem

object Constants {
    val bottomNavItems = listOf(
        BottomNavItem(
            "Home",
            R.drawable.home,
            "home"
        ),
        BottomNavItem(
            "Message",
            R.drawable.chat,
            "message"
        ),
        BottomNavItem(
            "Map",
            R.drawable.map,
            "map"
        ),
        BottomNavItem(
            "Profile",
            R.drawable.user,
            "profile"
        )
    )
}