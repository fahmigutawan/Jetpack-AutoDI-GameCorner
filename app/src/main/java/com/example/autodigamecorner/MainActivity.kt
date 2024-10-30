package com.example.autodigamecorner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.autodigamecorner.presentation.devices.DevicesScreen
import com.example.autodigamecorner.presentation.guide.GuideScreen
import com.example.autodigamecorner.presentation.mainmenu.MainMenuScreen
import com.example.autodigamecorner.ui.theme.AutoDIGameCornerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AutoDIGameCornerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = "main"
                    ) {
                        composable("main") {
                            MainMenuScreen(
                                onGuideClick = {
                                    navController.navigate("guide")
                                },
                                onDeviceClick = {
                                    navController.navigate("device")
                                }
                            )
                        }

                        composable("guide") {
                            GuideScreen(
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }

                        composable("device") {
                            DevicesScreen(
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}