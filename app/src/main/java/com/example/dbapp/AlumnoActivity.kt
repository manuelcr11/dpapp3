package com.example.dbapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dbapp.model.Alumno

class AlumnoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumno)

        val etMatricula = findViewById<EditText>(R.id.etMatricula)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellidoPaterno = findViewById<EditText>(R.id.etApellidoPaterno)
        val etApellidoMaterno = findViewById<EditText>(R.id.etApellidoMaterno)
        val etModelo = findViewById<EditText>(R.id.etModelo)
        val etPlaca = findViewById<EditText>(R.id.etPlaca)
        val cbAutomovil = findViewById<CheckBox>(R.id.cbAutomovil)
        val cbMoto = findViewById<CheckBox>(R.id.cbMoto)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            val tipoVehiculo = when {
                cbAutomovil.isChecked -> "Automóvil"
                cbMoto.isChecked -> "Moto"
                else -> "No especificado"
            }

            val alumno = Alumno(
                matricula = etMatricula.text.toString(),
                nombre = etNombre.text.toString(),
                apellidoPaterno = etApellidoPaterno.text.toString(),
                apellidoMaterno = etApellidoMaterno.text.toString(),
                tipoVehiculo = tipoVehiculo,
                modelo = etModelo.text.toString(),
                placa = etPlaca.text.toString()
            )

            Toast.makeText(this, "Alumno registrado: $alumno", Toast.LENGTH_LONG).show()
        }
    }
}
