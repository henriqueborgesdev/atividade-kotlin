package com.aula.appsbasicos.ui.screens.exercicios

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * EXERCÍCIO 2 (2º horário) — Login com Navegação, Tela 2.
 *
 * Esta tela já está pronta: recebe "nome" como parâmetro da rota
 * BoasVindasLogin e exibe a mensagem de boas-vindas.
 *
 * Desafio extra (opcional): adicione aqui um botão "Sair" que use
 * navController.popBackStack() (no NavGraph) para retornar à tela de login.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoasVindasLoginScreen(
    nome: String,
    aoVoltar: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Boas-vindas") },
                navigationIcon = {
                    TextButton(onClick = aoVoltar) {
                        Text("Sair")
                    }
                },
            )
        },
    ) { paddingInterno ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .padding(16.dp),
        ) {
            Text(
                text = "Bem-vindo(a), $nome!",
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}
