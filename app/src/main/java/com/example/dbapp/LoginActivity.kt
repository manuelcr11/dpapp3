package com.example.dbapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtNombre = findViewById<EditText>(R.id.txtUser)
        val txtMatricula = findViewById<EditText>(R.id.txtPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val nombre = txtNombre.text.toString().trim()
            val matricula = txtMatricula.text.toString().trim()

            val matriculaValida = matricula.length == 9 && matricula.all { it.isDigit() }

            if (nombre.isNotEmpty() && matriculaValida) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Nombre o matrícula inválidos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
