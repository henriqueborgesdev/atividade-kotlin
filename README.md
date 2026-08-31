# Apps Básicos — Android Studio (Jetpack Compose)

Projeto único do Android Studio para a aula de **Desenvolvimento de Aplicações para
Dispositivos Móveis**, usado para demonstração (1º horário) e prática (2º horário),
sem depender de slides.

Todo o projeto usa **Jetpack Compose** (sem layouts XML) e **Navigation Compose**
com rotas type-safe (`@Serializable`).

## Como abrir

1. Abra o Android Studio.
2. **File > Open...** e selecione a pasta `AppsBasicosAndroidStudio` (a que contém este README).
3. Aguarde o Gradle Sync (a primeira sincronização baixa as dependências e pode
   demorar alguns minutos).
4. Rode o app em um emulador ou dispositivo físico (▶ Run 'app').

Se o Android Studio pedir para atualizar o Gradle/AGP durante o sync, não é
necessário aceitar — as versões deste projeto (tabela abaixo) foram escolhidas
deliberadamente por serem estáveis e amplamente suportadas.

### Se o Run/Debug ("app") não aparecer automaticamente

Este projeto já inclui uma configuração de execução pronta em
`.idea/runConfigurations/app.xml` (visível no seletor "app" ao lado do botão
▶ Run, assim que o Gradle Sync terminar). Enquanto o Gradle Sync não terminar
**sem erros** (aba "Build" na parte inferior do Android Studio), o Android
Studio não consegue ler as configurações de execução do módulo `app` — por
isso, se o Sync falhar, o run config "some".

Uma primeira versão deste projeto usava AGP 9.2.0 + Kotlin 2.3.20 + Gradle
9.4.1 (as versões mais recentes disponíveis quando o projeto foi gerado) e o
sync falhava com o erro `AgpWithBuiltInKotlinAppliedCheck` — uma checagem
interna do plugin do Kotlin relacionada ao suporte experimental a Kotlin
embutido em versões muito recentes do AGP, incompatível com o ambiente da
maioria das instalações atuais do Android Studio. **Este pacote já foi
corrigido**: as versões abaixo foram trocadas por uma combinação estável e
consolidada (AGP 8.7.3 / Kotlin 2.0.21 / Gradle 8.10.2), sem esse problema.

Se, mesmo assim, o Sync falhar na sua máquina:

1. Abra a aba **Build** (ou "Sync") na parte inferior do Android Studio e
   veja a mensagem de erro completa.
2. Um motivo comum é o Android Studio instalado ser mais antigo que o
   necessário para AGP 8.7.x — nesse caso, atualize o Android Studio
   (Help > Check for Updates) ou me envie a mensagem de erro para eu ajustar
   as versões.
3. Como alternativa manual, mesmo sem sync completo: **Run > Edit
   Configurations... > + > Android App**, selecione o módulo `app` e clique
   em OK.

> Este projeto foi escrito à mão, com revisão cuidadosa de sintaxe (chaves,
> parênteses, imports e XML válidos), mas **não foi compilado** neste ambiente
> — o ambiente onde ele foi gerado não tem acesso ao SDK do Android nem aos
> repositórios Maven do Google/Gradle. A primeira sincronização no seu Android
> Studio é o teste real.

## Estrutura

Uma única `MainActivity` com um `NavHost` (veja `navigation/AppNavGraph.kt`) que
navega entre a tela inicial (menu) e cada tela de exemplo/exercício:

```
app/src/main/java/com/aula/appsbasicos/
├── MainActivity.kt                 — ponto de entrada, chama AppNavGraph()
├── navigation/
│   ├── Routes.kt                   — rotas type-safe (@Serializable)
│   └── AppNavGraph.kt              — NavHost, liga rotas às telas
├── ui/theme/                       — tema Compose minimalista (Color/Type/Theme)
└── ui/screens/
    ├── HomeScreen.kt                — menu inicial
    ├── exemplos/                    — 1º horário (prontos, para demonstrar)
    │   ├── CalculadoraScreen.kt         — Exemplo 1: estado + TextField + validação
    │   ├── CadastroScreen.kt            — Exemplo 2, tela 1: envia dados por rota
    │   └── BoasVindasScreen.kt          — Exemplo 2, tela 2: recebe dados da rota
    └── exercicios/                  — 2º horário (esqueleto com TODOs)
        ├── ConversorTemperaturaScreen.kt — Exercício 1
        ├── LoginScreen.kt                — Exercício 2, tela 1
        ├── BoasVindasLoginScreen.kt      — Exercício 2, tela 2 (já pronta)
        └── CalculadoraImcScreen.kt       — Exercício 3 (desafio)
```

### Exemplos (1º horário) — já implementados

- **Calculadora Simples**: estado com `remember { mutableStateOf(...) }`,
  `OutlinedTextField`, validação com `toDoubleOrNull()` e `Toast` via
  `LocalContext.current`.
- **Cadastro com Navegação**: duas telas ligadas por `NavController.navigate(...)`,
  com dados passados como parâmetros de uma rota `@Serializable`
  (`data class BoasVindas(val nome: String, val idade: String)`), recuperados do
  lado da tela de destino com `backStackEntry.toRoute()`.

### Exercícios (2º horário) — esqueleto com `TODO`

Cada tela de exercício já vem com o layout, os estados e a navegação prontos;
falta apenas a lógica dentro do `onClick` de cada botão, marcada com comentários
`TODO` numerados. O enunciado completo de cada exercício (fórmulas, tabela de
classificação do IMC, critérios de conclusão) está na apostila entregue
anteriormente para esta aula.

- **Conversor de Temperatura** — `toDoubleOrNull()`, fórmula `F = C × 9/5 + 32`.
- **Login com Navegação** — validação de campo vazio antes de navegar.
- **Calculadora de IMC** (desafio) — múltiplos campos, cálculo e classificação
  condicional (`if` / `else if`).

## Versões usadas

Combinação estável e consolidada (evita o bug de sync com AGP/Kotlin
excessivamente recentes — veja a seção acima):

| Ferramenta | Versão |
|---|---|
| Android Gradle Plugin (AGP) | 8.7.3 |
| Kotlin | 2.0.21 |
| Gradle (wrapper) | 8.10.2 |
| Compose BOM | 2024.10.01 |
| Navigation Compose | 2.8.7 |
| kotlinx-serialization-json | 1.7.3 |
| compileSdk / targetSdk | 35 |
| minSdk | 26 |
