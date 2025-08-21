Aqui está o **README.md** revisado, organizado e pronto para colar:

---

# Ciclo de Vida — Android (Kotlin, XML)

Projeto exemplo com **duas Activities** usando **layouts em XML** (**sem AppCompat / sem Compose**) para demonstrar as **chamadas do ciclo de vida** no Logcat.

## ✅ Objetivo

Observar no **Logcat** a sequência real dos métodos:

* `onCreate`, `onStart`, `onResume`
* `onPause`, `onStop`, `onRestart`, `onDestroy`

Cenários a testar:

* Abrir o app
* Navegar entre telas
* Minimizar e voltar
* Fechar o app

## 🧱 Tecnologias

* **Kotlin**
* **Activities do framework** (`android.app.Activity`)
* **XML layouts**
* **Tema:** `@android:style/Theme.Material.Light.NoActionBar`
* **Sem AppCompat / Sem Compose**

## 📁 Estrutura do projeto

```text
app/
└─ src/
   └─ main/
      ├─ AndroidManifest.xml
      ├─ java/
      │  └─ com/example/ciclodevidaapp/
      │     ├─ MainActivity.kt
      │     └─ SecondActivity.kt
      └─ res/
         ├─ layout/
         │  ├─ activity_main.xml
         │  └─ activity_second.xml
         └─ values/
            ├─ strings.xml
            └─ styles.xml
```

## ▶️ Como executar

1. Abra o projeto no **Android Studio**.
2. Selecione um **emulador** ou **dispositivo físico** (USB com depuração).
3. Clique em **Run** (▶️).

## 🔎 Onde ver as chamadas (Logcat)

1. **View → Tool Windows → Logcat** (atalho: `Alt+6`).
2. Selecione o **dispositivo** e marque **Show only selected application**.
3. Filtros sugeridos:

   * Por TAG: `tag:MainActivity` ou `tag:SecondActivity`
   * Para ambas (Regex): habilite *Regex* e use `tag:(MainActivity|SecondActivity)`
4. Nível: **Info**.
