package com.aula.appsbasicos.ui.screens.exercicios

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
import java.util.Locale

/**
 * EXERCÍCIO 1 (2º horário) — Conversor de Temperatura.
 * Veja o enunciado completo na apostila de exercícios.
 *
 * A tela e os estados já estão prontos; falta implementar a lógica do
 * botão "Converter" — procure pelos comentários TODO abaixo.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversorTemperaturaScreen(aoVoltar: () -> Unit) {
    var celsius by remember { mutableStateOf("") }
    var fahrenheit by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exercício 1 — Conversor de Temperatura") },
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
            // Para o desafio extra, irei definir ambos os campos (Fahrenheit e Celsius como OutlinedText) para ficar mais agradavel visualmente.
            OutlinedTextField(
                value = celsius,
                onValueChange = { celsius = it },
                label = { Text("Temperatura em Celsius") },
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = fahrenheit,
                onValueChange = { fahrenheit = it },
                label = { Text("Temperatura em Fahrenheit") },
                modifier = Modifier.fillMaxWidth(),
            )

            Button(
                onClick = {
                    // TODO 1: converta "celsius" para Double com celsius.toDoubleOrNull().
                    // TODO 2: se o valor for válido, calcule Fahrenheit com a fórmula
                    //         F = C * 9/5 + 32 e atualize o estado "fahrenheit"
                    //         (dica: use String.format("%.2f °F", valor) para 2 casas decimais).
                    // TODO 3: se o valor for inválido (null), exiba um Toast pedindo um
                    //         valor válido — use LocalContext.current, como no exemplo
                    //         da Calculadora Simples.

                    var celsiusRecebido = celsius.toDoubleOrNull();
                    if(celsiusRecebido != null) {
                        var fahrenheitConvertido = celsiusRecebido * 9/5 + 32;
                        fahrenheit = String.format(
                            Locale.getDefault(),
                            "%.2f", fahrenheitConvertido);
                        celsius = ""
                    }
                    if(celsiusRecebido == null) {
                        Toast.makeText(context, "Valor Inválido, digite novamente", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Text("Converter de °C para °F")
            }

            Button(
                onClick = {
                    var fahrenheitRecebido = fahrenheit.toDoubleOrNull();
                    if(fahrenheitRecebido != null) {
                        var celsiusConvertido = (fahrenheitRecebido - 32) * 5/9;
                        celsius = String.format(
                            Locale.getDefault(),
                            "%.2f", celsiusConvertido);
                        fahrenheit = ""
                    }
                    if(fahrenheitRecebido == null) {
                        Toast.makeText(context, "Valor Inválido, digite novamente", Toast.LENGTH_SHORT).show()
                    }
                }

            ) {
                Text("Converter de °F para °C")
            }


//            Text(
//                text = fahrenheit,
//                style = MaterialTheme.typography.titleMedium,
//                modifier = Modifier.padding(top = 16.dp),
//            )

            // Desafio extra (opcional): adicione um segundo botão que faça a
            // conversão inversa, de Fahrenheit para Celsius, usando a fórmula
            // C = (F - 32) * 5/9.
        }
    }
}
