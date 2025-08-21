package com.example.ciclodevidaapp
import com.example.ciclodevidaapp.R


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : Activity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate chamado")
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnToSecond).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    override fun onStart()   { super.onStart();   Log.i(TAG, "onStart chamado") }
    override fun onResume()  { super.onResume();  Log.i(TAG, "onResume chamado") }
    override fun onPause()   { super.onPause();   Log.i(TAG, "onPause chamado") }
    override fun onStop()    { super.onStop();    Log.i(TAG, "onStop chamado") }
    override fun onRestart() { super.onRestart(); Log.i(TAG, "onRestart chamado") }
    override fun onDestroy() { super.onDestroy(); Log.i(TAG, "onDestroy chamado") }
}
