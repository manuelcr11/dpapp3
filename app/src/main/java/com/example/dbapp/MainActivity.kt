package com.example.dbapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dbapp.dao.VehiculoDAO
import com.example.dbapp.model.Alumno

class MainActivity : AppCompatActivity() {

    private lateinit var txtId: EditText
    private lateinit var txtNombre: EditText
    private lateinit var txtMatricula: EditText
    private lateinit var txtTipo: EditText
    private lateinit var txtMarca: EditText
    private lateinit var txtPlaca: EditText
    private lateinit var lista: TextView

    private lateinit var dao: VehiculoDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dao = VehiculoDAO(this)

        txtId = findViewById(R.id.txtId)
        txtNombre = findViewById(R.id.txtNombre)
        txtMatricula = findViewById(R.id.txtMatricula)
        txtTipo = findViewById(R.id.txtTipo)
        txtMarca = findViewById(R.id.txtMarca)
        txtPlaca = findViewById(R.id.txtPlaca)
        lista = findViewById(R.id.txtLista)

        findViewById<Button>(R.id.btnAgregar).setOnClickListener { agregar() }
        findViewById<Button>(R.id.btnMostrar).setOnClickListener { mostrar() }
        findViewById<Button>(R.id.btnActualizar).setOnClickListener { actualizar() }
        findViewById<Button>(R.id.btnEliminar).setOnClickListener { eliminar() }
    }

    private fun agregar() {
        val alumno = Alumno(
            nombre = txtNombre.text.toString(),
            matricula = txtMatricula.text.toString(),
            tipoVehiculo = txtTipo.text.toString(),
            marca = txtMarca.text.toString(),
            placa = txtPlaca.text.toString()
        )
        val exito = dao.insertar(alumno)
        Toast.makeText(this, if (exito) "Registro agregado" else "Error al agregar", Toast.LENGTH_SHORT).show()
        mostrar()
    }

    private fun mostrar() {
        val datos = dao.obtenerTodos()
        var texto = ""
        for (a in datos) {
            texto += "${a.id} | ${a.nombre} | ${a.matricula} | ${a.tipoVehiculo} | ${a.marca} | ${a.placa}\n"
        }
        lista.text = texto
    }

    private fun actualizar() {
        val alumno = Alumno(
            id = txtId.text.toString().toInt(),
            nombre = txtNombre.text.toString(),
            matricula = txtMatricula.text.toString(),
            tipoVehiculo = txtTipo.text.toString(),
            marca = txtMarca.text.toString(),
            placa = txtPlaca.text.toString()
        )
        val exito = dao.actualizar(alumno)
        Toast.makeText(this, if (exito) "Registro actualizado" else "Error al actualizar", Toast.LENGTH_SHORT).show()
        mostrar()
    }

    private fun eliminar() {
        val idText = txtId.text.toString()

        // Validar que no esté vacío
        if (idText.isEmpty()) {
            Toast.makeText(this, "Ingresa el ID a eliminar", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val id = idText.toInt()
            val exito = dao.eliminar(id)
            Toast.makeText(this, if (exito) "Registro eliminado" else "Error al eliminar", Toast.LENGTH_SHORT).show()
            mostrar()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "ID inválido", Toast.LENGTH_SHORT).show()
        }
    }

}
