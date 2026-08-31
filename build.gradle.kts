// Arquivo de build de nível raiz — declara os plugins usados pelos módulos,
// mas não os aplica aqui (cada módulo aplica o que precisa em seu próprio build.gradle.kts).
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.serialization) apply false
}
