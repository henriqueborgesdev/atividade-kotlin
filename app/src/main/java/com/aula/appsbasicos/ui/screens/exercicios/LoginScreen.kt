package com.aula.appsbasicos.ui.screens.exercicios

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.widget.Toast

/**
 * EXERCÍCIO 2 (2º horário) — Login com Navegação, Tela 1.
 * Veja o enunciado completo na apostila de exercícios.
 *
 * A navegação para a tela de boas-vindas (BoasVindasLoginScreen) já está
 * ligada através do parâmetro "aoEntrar" — falta implementar a validação
 * do campo antes de chamá-lo. Procure pelos comentários TODO abaixo.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    aoEntrar: (nome: String) -> Unit,
    aoVoltar: () -> Unit,
) {
    var usuario by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exercício 2 — Login") },
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
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Nome de usuário") },
                modifier = Modifier.fillMaxWidth(),
            )

            Button(
                onClick = {
                    // TODO 1: verifique se "usuario" está em branco
                    //         (dica: usuario.isBlank()).
                    // TODO 2: se estiver em branco, exiba um Toast pedindo o
                    //         preenchimento do campo (use LocalContext.current,
                    //         já disponível na variável "context").
                    // TODO 3: se estiver preenchido, chame aoEntrar(usuario) para
                    //         navegar até a tela de boas-vindas com o nome digitado.

                    if(usuario.isBlank()) {
                        Toast.makeText(context, "Campo de usuário inválido, digite novamente", Toast.LENGTH_SHORT).show()
                    }
                    if(!usuario.isBlank()) {
                       aoEntrar(usuario)
                    }

                },
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Text("Entrar")
            }

            // Dica: siga o mesmo padrão do exemplo "Cadastro com Navegação"
            // do 1º horário — aoEntrar já está ligado a
            // navController.navigate(BoasVindasLogin(nome = ...)) no NavGraph.
        }
    }
}
