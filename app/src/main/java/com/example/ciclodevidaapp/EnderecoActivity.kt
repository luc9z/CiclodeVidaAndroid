package com.example.ciclodevidaapp

import android.app.Activity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.content.SharedPreferences
import android.util.Log
import android.content.Intent


class EnderecoActivity : Activity() {

    private val TAG = "EnderecoActivity"
    private lateinit var ruaEditText: EditText
    private lateinit var cidadeEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate chamado")
        setContentView(R.layout.activity_endereco)

        ruaEditText = findViewById(R.id.ruaEditText)
        cidadeEditText = findViewById(R.id.cidadeEditText)

        // Carregar dados salvos (se existirem)
        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
        ruaEditText.setText(sharedPreferences.getString("rua", ""))
        cidadeEditText.setText(sharedPreferences.getString("cidade", ""))

        // Botão Próximo
        findViewById<Button>(R.id.btnProximo).setOnClickListener {
            val rua = ruaEditText.text.toString()
            val cidade = cidadeEditText.text.toString()

            if (rua.isNotEmpty() && cidade.isNotEmpty()) {
                // Salvar dados em SharedPreferences
                val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
                with(sharedPreferences.edit()) {
                    putString("rua", rua)
                    putString("cidade", cidade)
                    apply()
                }

                // Navegar para PreferenciasActivity
                val intent = Intent(this, PreferenciasActivity::class.java)
                startActivity(intent)
            }
        }

        // Botão Voltar
        findViewById<Button>(R.id.btnVoltar).setOnClickListener {
            finish() // Voltar para a tela anterior
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
