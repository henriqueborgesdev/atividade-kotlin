package com.aula.appsbasicos.ui.screens.exemplos

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
 * EXEMPLO 2 (1º horário) — App de Cadastro, Tela 2.
 *
 * Os dados chegam como parâmetros normais da função composable — não é
 * necessário usar getStringExtra(), como nas Activities tradicionais.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoasVindasScreen(
    nome: String,
    idade: String,
    aoVoltar: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Boas-vindas") },
                navigationIcon = {
                    TextButton(onClick = aoVoltar) {
                        Text("← Voltar")
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
                text = "Olá, $nome! Você tem $idade anos.",
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}
