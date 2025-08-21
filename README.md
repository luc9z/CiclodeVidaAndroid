Ciclo de Vida — Android (Kotlin, XML)

Projeto exemplo com duas Activities usando layouts em XML (sem AppCompat) para demonstrar as chamadas do ciclo de vida no Logcat.

✅ Objetivo

Observar no Logcat a sequência real dos métodos:
onCreate, onStart, onResume, onPause, onStop, onRestart, onDestroy
ao:

Abrir o app

Navegar entre telas

Minimizar e voltar

Fechar o app

🧱 Tecnologias

Kotlin

Activities do framework (android.app.Activity)

XML layouts

Tema: @android:style/Theme.Material.Light.NoActionBar

Sem AppCompat / Sem Compose

📁 Estrutura (essencial)
app/
└─ src/
   └─ main/
      ├─ AndroidManifest.xml
      ├─ java/
      │  └─ com/
      │     └─ example/
      │        └─ ciclodevidaapp/
      │           ├─ MainActivity.kt
      │           └─ SecondActivity.kt
      └─ res/
         ├─ layout/
         │  ├─ activity_main.xml
         │  └─ activity_second.xml
         └─ values/
            ├─ strings.xml
            └─ styles.xml
