package com.example.dbapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dbapp.utils.Conexion

class ConfigIPActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config_ip)

        val txtIp = findViewById<EditText>(R.id.txtIp)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        txtIp.setText(Conexion.getIp(this))

        btnGuardar.setOnClickListener {
            val ip = txtIp.text.toString().trim()
            if (ip.isNotEmpty()) {
                Conexion.setIp(this, ip)
                Toast.makeText(this, "IP guardada", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Ingresa una IP", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
