package com.aula.appsbasicos.ui.screens.exemplos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * EXEMPLO 2 (1º horário) — App de Cadastro, Tela 1.
 *
 * Demonstra Navigation Compose: ao clicar em "Continuar", navegamos para a
 * rota BoasVindas levando nome e idade como parâmetros da própria rota —
 * sem Intents e sem uma segunda Activity.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen(
    aoContinuar: (nome: String, idade: String) -> Unit,
    aoVoltar: () -> Unit,
) {
    var nome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cadastro") },
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
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = idade,
                onValueChange = { idade = it },
                label = { Text("Idade") },
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
            )

            Button(
                onClick = { aoContinuar(nome, idade) },
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Text("Continuar")
            }
        }
    }
}
