package com.bharathwaj.composeapp.utils

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

    const val ACCESS_TOKEN = "563492ad6f917000010000012782a65b83864153ba4d37c81de225c7"
    const val BASE_URL = "https://api.pexels.com"
}