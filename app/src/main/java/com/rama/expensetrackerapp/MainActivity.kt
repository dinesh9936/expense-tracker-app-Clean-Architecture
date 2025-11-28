package com.rama.expensetrackerapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.navigation.compose.rememberNavController
import com.rama.expensetrackerapp.presentation.navigation.AppNavGraph
import com.rama.expensetrackerapp.ui.theme.ExpenseTrackerAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseTrackerAppTheme {
                val navController = rememberNavController()

                AppNavGraph(navController = navController)
            }
        }
    }
}