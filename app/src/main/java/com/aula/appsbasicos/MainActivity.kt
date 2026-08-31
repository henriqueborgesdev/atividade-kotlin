package com.aula.appsbasicos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aula.appsbasicos.navigation.AppNavGraph
import com.aula.appsbasicos.ui.theme.AppsBasicosTheme

/**
 * Única Activity do app — todas as telas (exemplos e exercícios) são
 * funções @Composable navegadas pelo AppNavGraph, dentro deste mesmo
 * setContent { }.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppsBasicosTheme {
                AppNavGraph()
            }
        }
    }
}
