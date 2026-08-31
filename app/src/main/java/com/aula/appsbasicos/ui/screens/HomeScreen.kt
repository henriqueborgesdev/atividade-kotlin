package com.aula.appsbasicos.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Tela inicial: um menu simples que navega para cada exemplo do 1º horário
 * e para cada exercício (esqueleto) do 2º horário. É o ponto de partida
 * para o professor mostrar o projeto em aula, sem precisar de slides.
 */

data class ItemMenu(
    val titulo: String,
    val descricao: String,
    val aoClicar: () -> Unit,
)

data class SecaoMenu(
    val titulo: String,
    val itens: List<ItemMenu>,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    aoAbrirCalculadora: () -> Unit,
    aoAbrirCadastro: () -> Unit,
    aoAbrirConversorTemperatura: () -> Unit,
    aoAbrirLogin: () -> Unit,
    aoAbrirCalculadoraImc: () -> Unit,
) {
    val secoes = listOf(
        SecaoMenu(
            titulo = "Exemplos — 1º horário",
            itens = listOf(
                ItemMenu(
                    titulo = "Calculadora Simples",
                    descricao = "Estado, TextField e validação de entrada.",
                    aoClicar = aoAbrirCalculadora,
                ),
                ItemMenu(
                    titulo = "Cadastro com Navegação",
                    descricao = "Duas telas conectadas por Navigation Compose.",
                    aoClicar = aoAbrirCadastro,
                ),
            ),
        ),
        SecaoMenu(
            titulo = "Exercícios — 2º horário (esqueleto)",
            itens = listOf(
                ItemMenu(
                    titulo = "Conversor de Temperatura",
                    descricao = "Celsius ↔ Fahrenheit. Contém TODOs a implementar.",
                    aoClicar = aoAbrirConversorTemperatura,
                ),
                ItemMenu(
                    titulo = "Login com Navegação",
                    descricao = "Duas telas + validação. Contém TODOs a implementar.",
                    aoClicar = aoAbrirLogin,
                ),
                ItemMenu(
                    titulo = "Calculadora de IMC (desafio)",
                    descricao = "Cálculo e classificação condicional. Contém TODOs.",
                    aoClicar = aoAbrirCalculadoraImc,
                ),
            ),
        ),
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Apps Básicos — Android Studio") })
        },
    ) { paddingInterno ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            secoes.forEach { secao ->
                item {
                    Text(
                        text = secao.titulo,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                    )
                }
                items(secao.itens) { item ->
                    ItemMenuCard(item)
                }
            }
        }
    }
}

@Composable
private fun ItemMenuCard(item: ItemMenu) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .clickable(onClick = item.aoClicar),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.titulo, style = MaterialTheme.typography.bodyLarge)
            Text(text = item.descricao, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
