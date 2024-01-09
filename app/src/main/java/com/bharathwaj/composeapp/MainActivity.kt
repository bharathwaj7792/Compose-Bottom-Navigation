package com.bharathwaj.composeapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bharathwaj.composeapp.screens.HomeScreen
import com.bharathwaj.composeapp.screens.MapScreen
import com.bharathwaj.composeapp.screens.MessageScreen
import com.bharathwaj.composeapp.screens.ProfileScreen
import com.bharathwaj.composeapp.ui.theme.ComposeAppTheme
import com.bharathwaj.composeapp.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            ComposeAppTheme {
                val navController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navHostController = navController)
                        }, content = { padding ->
                            NavHostContainer(navHostController = navController, padding = padding)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun NavHostContainer(
    navHostController: NavHostController,
    padding: PaddingValues
){
    NavHost(navHostController, "home", Modifier.padding(paddingValues = padding)){
        composable("home"){
            HomeScreen()
        }

        composable("message"){
            MessageScreen()
        }

        composable("map"){
            MapScreen()
        }

        composable("profile"){
            ProfileScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(navHostController: NavHostController){

    BottomNavigation(backgroundColor = Color.Yellow) {

        //observe backstack
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()

        //observe current route to change the icon
        //color, label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        //Bottom nav items are declared
        Constants.bottomNavItems.forEach{ navItem ->

            //Place the bottom nav items
            BottomNavigationItem(
                currentRoute == navItem.route,
                {
                    navHostController.navigate(navItem.route)
                },
                {
                    Icon(painterResource(id = navItem.icon), contentDescription = navItem.label)
                },
                    selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f)
            )

        }

    }
}