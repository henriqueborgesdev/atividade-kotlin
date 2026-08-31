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
 * EXERCÍCIO 3 — Desafio (2º horário) — Calculadora de IMC.
 * Veja o enunciado completo, incluindo a tabela de classificação, na
 * apostila de exercícios.
 *
 * A tela e os estados já estão prontos; falta implementar a lógica do
 * botão "Calcular" — procure pelos comentários TODO abaixo.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculadoraImcScreen(aoVoltar: () -> Unit) {
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    var classificacao by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exercício 3 — Calculadora de IMC") },
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
                value = peso,
                onValueChange = { peso = it },
                label = { Text("Peso (kg)") },
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = altura,
                onValueChange = { altura = it },
                label = { Text("Altura (m) — ex.: 1.75") },
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
            )

            Button(
                onClick = {
                    // TODO 1: converta "peso" e "altura" para Double com
                    //         toDoubleOrNull() e valide que ambos não sejam nulos
                    //         e sejam maiores que zero.
                    // TODO 2: se algum valor for inválido, exiba um Toast e
                    //         interrompa o cálculo (use "context", já disponível).
                    // TODO 3: calcule o IMC pela fórmula IMC = peso / (altura * altura)
                    //         e atualize "resultado" com 2 casas decimais
                    //         (dica: String.format("IMC: %.2f", imc)).
                    // TODO 4: determine a classificação com uma estrutura
                    //         if / else if e atualize "classificacao":
                    //           IMC < 18.5          -> "Abaixo do peso"
                    //           18.5 <= IMC < 25     -> "Peso normal"
                    //           25 <= IMC < 30        -> "Sobrepeso"
                    //           IMC >= 30              -> "Obesidade"
                    var pesoRecebido = peso.toDoubleOrNull();
                    var alturaRecebida = altura.toDoubleOrNull();
                    if(pesoRecebido != null && alturaRecebida != null && pesoRecebido > 0 && alturaRecebida > 0) {
                        val resultadoRecebido = pesoRecebido / (alturaRecebida * alturaRecebida);
                        resultado = String.format(
                            Locale.getDefault(),
                            "IMC: %.2f: ",
                            resultadoRecebido
                        )
                        if(resultadoRecebido < 18.5) {
                            classificacao = "Abaixo do Peso";
                        } else if(resultadoRecebido >= 18.5 && resultadoRecebido < 25) {
                            classificacao = "Peso Normal";
                        } else if(resultadoRecebido >= 25 && resultadoRecebido < 30) {
                            classificacao = "Sobrepeso";
                        } else {
                            classificacao = "Obesidade";
                        }

                    } else {
                        Toast.makeText(context, "Valor inserido é invalido, digite novamente", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Text("Calcular")
            }

            Text(
                text = resultado,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 16.dp),
            )
            Text(
                text = classificacao,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}
