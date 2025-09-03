package com.example.ciclodevidaapp

import android.app.Activity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Button
import android.widget.AdapterView
import android.content.SharedPreferences
import android.util.Log
import android.content.Intent


class PreferenciasActivity : Activity() {

    private val TAG = "PreferenciasActivity"
    private lateinit var newsletterCheckBox: CheckBox
    private lateinit var temaSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate chamado")
        setContentView(R.layout.activity_preferencias)

        newsletterCheckBox = findViewById(R.id.newsletterCheckBox)
        temaSpinner = findViewById(R.id.temaSpinner)

        // Carregar dados salvos (se existirem)
        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
        newsletterCheckBox.isChecked = sharedPreferences.getBoolean("newsletter", false)
        val tema = sharedPreferences.getString("tema", "Claro")
        val temas = resources.getStringArray(R.array.temas)
        temaSpinner.setSelection(temas.indexOf(tema))

        // Salvar dados assim que houver alterações
        newsletterCheckBox.setOnCheckedChangeListener { _, isChecked ->
            savePreferences("newsletter", isChecked)
        }

        // Usar AdapterView.OnItemSelectedListener corretamente
        temaSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: android.view.View?, position: Int, id: Long) {
                val selectedTema = temaSpinner.selectedItem.toString()
                savePreferences("tema", selectedTema)
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                // Não faz nada quando nada é selecionado
            }
        }

        // Botão Próximo
        findViewById<Button>(R.id.btnProximo).setOnClickListener {
            val newsletter = newsletterCheckBox.isChecked
            val tema = temaSpinner.selectedItem.toString()

            // Salvar dados em SharedPreferences
            savePreferences("newsletter", newsletter)
            savePreferences("tema", tema)

            // Navegar para ResumoActivity
            val intent = Intent(this, ResumoActivity::class.java)
            startActivity(intent)
        }

        // Botão Voltar
        findViewById<Button>(R.id.btnVoltar).setOnClickListener {
            finish() // Voltar para a tela anterior
        }
    }

    private fun savePreferences(key: String, value: Any) {
        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            when (value) {
                is Boolean -> putBoolean(key, value)
                is String -> putString(key, value)
            }
            apply()
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
