
# Ciclo de Vida — Android (Kotlin, XML)

## Descrição

Este é um projeto Android que demonstra o ciclo de vida das **Activities** e a navegação entre telas, utilizando **Kotlin** e **layouts XML**. O aplicativo coleta informações do usuário passo a passo, passando os dados de uma tela para outra, e salva as informações em **`SharedPreferences`** para que, ao voltar para o app ou navegar entre as telas, os dados sejam mantidos.

### Funcionalidades:

* **4 telas (Activities)** com **navegação entre elas**.
* **Ciclo de vida das Activities** implementado com logs (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onRestart`, `onDestroy`).
* **Persistência de dados** utilizando **`SharedPreferences`**.
* **Validação de e-mail** com **regex** e validação de entrada para o nome.

---

## Objetivo

O aplicativo tem como objetivo demonstrar no **Logcat** a sequência real dos métodos do ciclo de vida das Activities, enquanto o usuário interage com o app e navega entre as telas:

* **Abrir o app**
* **Navegar entre as telas**
* **Minimizar e voltar**
* **Fechar o app**

---

## Telas

1. **PerfilActivity**

   * **Campos**: Nome completo (EditText), E-mail (EditText)
   * **Botão Próximo** → Vai para **EnderecoActivity**.

2. **EnderecoActivity**

   * **Campos**: Rua, Cidade (EditText)
   * **Botões**: **Voltar**, **Próximo** → Vai para **PreferenciasActivity**.

3. **PreferenciasActivity**

   * **Campos**: Receber newsletter (CheckBox), Tema (Spinner: Claro/Escuro)
   * **Botões**: **Voltar**, **Próximo** → Vai para **ResumoActivity**.

4. **ResumoActivity**

   * Exibe todos os dados preenchidos em modo somente leitura (TextView).
   * **Botões**: **Editar Perfil** (volta para **PerfilActivity**), **Finalizar** (salva os dados e exibe um Toast "Salvo com sucesso!").

---

## Fluxo de Dados

* **Passagem de dados entre telas**: Utiliza **`Intent.putExtra`** para enviar dados de uma Activity para outra.
* **Persistência**: Na tela **ResumoActivity**, todos os dados são salvos em **`SharedPreferences`**.
* **Pré-preenchimento**: Cada tela carrega os dados previamente salvos em **`SharedPreferences`**, se existirem.

---

## Ciclo de Vida (Logcat)

Em todas as Activities, os métodos do ciclo de vida são implementados e exibidos no **Logcat** (ou com **Toast**) para acompanhar a execução:

* **`onCreate`** → Configura a tela e carrega dados (quando aplicável).
* **`onStart`** → Indica que a Activity está visível.
* **`onResume`** → Indica que o usuário pode interagir.
* **`onPause`** → Salva temporariamente os dados digitados (ex: em variáveis ou **`SharedPreferences`**).
* **`onStop`** → Loga que a tela não está mais visível.
* **`onRestart`** → Loga quando a Activity volta após ter sido parada.
* **`onDestroy`** → Loga quando a Activity é destruída.

---

## Tecnologias

* **Kotlin** (linguagem de programação)
* **Activities** do framework Android (`android.app.Activity`)
* **XML layouts** para a construção das telas
* **SharedPreferences** para persistência de dados
* **Logcat** para acompanhar o ciclo de vida das Activities

---

## Estrutura do Projeto

```
Estrutura (essencial)
├── app/src/main/
│   ├── AndroidManifest.xml
│   ├── java/com/example/ciclodevidaapp/
│   │   ├── PerfilActivity.kt
│   │   ├── EnderecoActivity.kt
│   │   ├── PreferenciasActivity.kt
│   │   ├── ResumoActivity.kt
│   └── res/
│       ├── layout/
│       │   ├── activity_perfil.xml
│       │   ├── activity_endereco.xml
│       │   ├── activity_preferencias.xml
│       │   ├── activity_resumo.xml
│       ├── values/
│       │   ├── strings.xml
│       │   ├── themes.xml
│       └── mipmap/
│           └── ic_launcher_foreground.xml
└── build.gradle
```

### Arquivos principais:

* **Activities**:

  * **`PerfilActivity.kt`**: Tela de perfil, onde o usuário insere nome e e-mail.
  * **`EnderecoActivity.kt`**: Tela de endereço, onde o usuário insere rua e cidade.
  * **`PreferenciasActivity.kt`**: Tela de preferências, onde o usuário escolhe as preferências e tema.
  * **`ResumoActivity.kt`**: Tela de resumo, onde todos os dados preenchidos são exibidos e salvos.

* **Layouts**: Arquivos XML que definem o layout visual de cada Activity.

* **SharedPreferences**: Usado para salvar os dados preenchidos nas telas.

---

## Como Usar

1. **Abrir o App**: Ao iniciar o aplicativo, o usuário começará na **PerfilActivity**.
2. **Preencher os Dados**: Preencha o nome, e-mail, endereço, cidade e as preferências.
3. **Salvar e Voltar**: Os dados são automaticamente salvos usando **SharedPreferences** e podem ser acessados mesmo se o usuário voltar para a tela anterior.
4. **Ver Resumo**: Na tela **ResumoActivity**, o usuário verá todos os dados preenchidos, podendo finalizar ou editar.

---
