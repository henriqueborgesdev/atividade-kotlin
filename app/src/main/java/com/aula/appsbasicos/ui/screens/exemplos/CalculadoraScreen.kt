package com.aula.appsbasicos.ui.screens.exemplos

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

/**
 * EXEMPLO 1 (1º horário) — Calculadora Simples.
 *
 * Demonstra o essencial de Compose para esta aula:
 *  - estado local com remember { mutableStateOf(...) };
 *  - captura de entrada do usuário com OutlinedTextField;
 *  - validação com toDoubleOrNull() e feedback com Toast.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculadoraScreen(aoVoltar: () -> Unit) {
    var valor1 by remember { mutableStateOf("") }
    var valor2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Calculadora Simples") },
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
                value = valor1,
                onValueChange = { valor1 = it },
                label = { Text("Valor 1") },
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = valor2,
                onValueChange = { valor2 = it },
                label = { Text("Valor 2") },
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
            )

            Button(
                onClick = {
                    val n1 = valor1.toDoubleOrNull()
                    val n2 = valor2.toDoubleOrNull()
                    if (n1 != null && n2 != null) {
                        resultado = "Resultado: ${n1 + n2}"
                    } else {
                        Toast.makeText(context, "Digite valores válidos", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Text("Somar")
            }

            Text(
                text = resultado,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 16.dp),
            )
        }
    }
}
