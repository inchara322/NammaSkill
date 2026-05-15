package com.example.nammaselfskill

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.nammaselfskill.ui.theme.NammaSelfSkillTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NammaSelfSkillTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    var isLoggedIn by remember { mutableStateOf(false) }

    if (isLoggedIn) {
        MainScreen()
    } else {
        LoginScreen(onLoginSuccess = { isLoggedIn = true })
    }
}

sealed class Screen(val title: String, val icon: ImageVector) {
    object Courses : Screen("Courses", Icons.Default.Home)
    object Centers : Screen("Centers", Icons.Default.Place)
    object Stories : Screen("Stories", Icons.Default.Star)
}

@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Courses) }
    val items = remember { listOf(Screen.Courses, Screen.Centers, Screen.Stories) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                tonalElevation = 8.dp
            ) {
                items.forEach { screen ->
                    val selected = currentScreen == screen
                    NavigationBarItem(
                        icon = { 
                            Icon(
                                screen.icon, 
                                contentDescription = screen.title,
                                tint = if (selected) MaterialTheme.colorScheme.primary else Color.Gray
                            ) 
                        },
                        label = { 
                            Text(
                                screen.title,
                                color = if (selected) MaterialTheme.colorScheme.primary else Color.Gray
                            ) 
                        },
                        selected = selected,
                        onClick = { currentScreen = screen },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            when (currentScreen) {
                is Screen.Courses -> CourseListScreen()
                is Screen.Centers -> CenterMapScreen()
                is Screen.Stories -> SuccessStoriesScreen()
            }
        }
    }
}
