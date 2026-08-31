package com.aula.appsbasicos.navigation

import kotlinx.serialization.Serializable

/**
 * Rotas de navegação do app, no estilo type-safe do Navigation Compose:
 * cada tela é representada por um object (sem parâmetros) ou uma data class
 * (quando a tela recebe dados), anotados com @Serializable.
 *
 * Isso substitui as antigas rotas em String — o compilador garante que os
 * tipos e nomes dos parâmetros passados na navegação estejam corretos.
 */

@Serializable
object Home

// ---------- Exemplos (1º horário) ----------

@Serializable
object Calculadora

@Serializable
object Cadastro

@Serializable
data class BoasVindas(val nome: String, val idade: String)

// ---------- Exercícios (2º horário) ----------

@Serializable
object ConversorTemperatura

@Serializable
object Login

@Serializable
data class BoasVindasLogin(val nome: String)

@Serializable
object CalculadoraImc
