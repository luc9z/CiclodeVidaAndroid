package com.example.ciclodevidaapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ciclodevidaapp.R

class PerfilActivity : Activity() {

    private val TAG = "PerfilActivity"
    private lateinit var nomeEditText: EditText
    private lateinit var emailEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate chamado")
        setContentView(R.layout.activity_perfil)

        nomeEditText = findViewById(R.id.nomeEditText)
        emailEditText = findViewById(R.id.emailEditText)

        // Carregar dados salvos (se existirem) ao iniciar a Activity
        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
        nomeEditText.setText(sharedPreferences.getString("nome", ""))
        emailEditText.setText(sharedPreferences.getString("email", ""))

        // Adicionar InputFilter para o campo Nome (permitir apenas letras e espaços)
        nomeEditText.filters = arrayOf<InputFilter>(InputFilter { source, start, end, dest, dstart, dend ->
            val regex = "[^A-Za-z ]"
            val regexMatcher = source.toString().matches(regex.toRegex())
            if (regexMatcher) {
                // Se a string contiver algo além de letras e espaços, ele vai ignorar.
                return@InputFilter ""
            }
            null
        })

        findViewById<Button>(R.id.btnProximo).setOnClickListener {
            val nome = nomeEditText.text.toString()
            val email = emailEditText.text.toString()

            if (nome.isNotEmpty() && email.isNotEmpty()) {
                // Validação do e-mail
                if (!isValidEmail(email)) {
                    Toast.makeText(this, "Por favor, insira um e-mail válido", Toast.LENGTH_SHORT).show()
                } else {
                    // Enviar dados para a próxima Activity
                    val intent = Intent(this, EnderecoActivity::class.java)
                    intent.putExtra("nome", nome)
                    intent.putExtra("email", email)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Função para validar o formato do e-mail
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
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

        // Salvar dados em SharedPreferences ao sair da Activity
        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString("nome", nomeEditText.text.toString())
            putString("email", emailEditText.text.toString())
            apply()  // Salva os dados de forma assíncrona
        }
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
