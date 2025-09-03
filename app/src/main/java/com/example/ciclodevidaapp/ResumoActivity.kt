package com.example.ciclodevidaapp

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.content.SharedPreferences
import android.util.Log
import android.content.Intent
import android.widget.Toast



class ResumoActivity : Activity() {

    private val TAG = "ResumoActivity"
    private lateinit var resumoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate chamado")
        setContentView(R.layout.activity_resumo)

        resumoTextView = findViewById(R.id.resumoTextView)

        // Carregar dados salvos (se existirem)
        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
        val nome = sharedPreferences.getString("nome", "")
        val email = sharedPreferences.getString("email", "")
        val rua = sharedPreferences.getString("rua", "")
        val cidade = sharedPreferences.getString("cidade", "")
        val newsletter = sharedPreferences.getBoolean("newsletter", false)
        val tema = sharedPreferences.getString("tema", "Claro")

        // Convertendo o valor booleano de "newsletter" para "Sim" ou "Não"
        val recebeNewsletter = if (newsletter) "Sim" else "Não"

        // Exibindo os dados no TextView
        resumoTextView.text = """
            Nome: $nome
            E-mail: $email
            Rua: $rua
            Cidade: $cidade
            Receber Newsletter: $recebeNewsletter
            Tema: $tema
        """.trimIndent()

        // Botão Finalizar
        findViewById<Button>(R.id.btnFinalizar).setOnClickListener {
            Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_SHORT).show()
        }

        // Botão Editar
        findViewById<Button>(R.id.btnEditar).setOnClickListener {
            finish() // Voltar para a tela anterior (PerfilActivity)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart chamado")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume chamado")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause chamado")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop chamado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart chamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy chamado")
    }
}
