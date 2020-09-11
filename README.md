# Exercicio1 - Calculadora

Esta tarefa envolve os conceitos básicos de projetos Android, desde a criação do projeto, desenho da tela e programação básica em Kotlin. Faça um clone ou fork deste projeto e adicione a sua solução.

Construa uma calculadora simples que lê uma string de um `EditText` e mostra o resultado em um `TextView`. Você pode implementar a sua própria avaliação de expressões matemáticas ou utilizar alguma biblioteca ou código pronto.

Indique quais partes completou e descreva as dificuldades que teve

## Etapas

Abaixo segue alguns passos sugeridos para criar a aplicação:

1. Abra o Android Studio e crie um projeto Android com uma "Empty Activity"
2. Abra o layout `activity_main`, crie os botões numéricos (0-9), de operações (+, -, *, /), avaliar expressão (+) e limpar (c). Atente para o posicionamento, configurando as _chains_  corretamente.
3. Associe os listeners para que, ao apertar os botões, seja inserido o texto correspondente.
4. Associe o listener do botão de avaliação "=" da expressão para obter a expressão, realizar o cálculo e, enfim, escrever a resposta no `TextView`
5. Caso a expressão seja inválida, evite que a aplicação quebre exibindo um `Toast` ou `Dialog`

## Orientações

- Comente o código desenvolvido explicando o que fez em cada passo
- Caso não tenha dificuldades, procure incrementar a calculadora com mais operações, botão de apagar, entre outros

## Status

| Passo | Completou? |
| ----- | ---------- |
|   1. Projeto            | **sim/não** |
|   2. Layout             |            |
|   3. Button Listeners   |            |
|   4. Avaliar Expressão  |            |
|   5. Alertar inválido   |            |

----------
## Dificuldades

Explique de forma resumida as dificuldades que teve e como resolveu.

> Escreva: "não tive dificuldades" se for o caso e apague o resto

1. **Importar biblioteca X**
   - Não consegui importar a biblioteca X por conta disso e daquilo.
   - Resolvi fazendo X, Y e Z...
2. **Avaliação de expressão**
   - Resolvi implementar minha própria e por não conhecer Kotlin demorei bastante...
