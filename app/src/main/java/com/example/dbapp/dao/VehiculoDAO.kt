package com.example.dbapp.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.dbapp.db.UniversidadDBHelper
import com.example.dbapp.model.Automovil
import com.example.dbapp.model.Motocicleta
import com.example.dbapp.model.Vehiculo

class VehiculoDAO(context: Context) : ICrud<Vehiculo> {

    private val dbHelper = UniversidadDBHelper(context)

    override fun insertar(obj: Vehiculo): Boolean {
        val db = dbHelper.writableDatabase
        val valores = ContentValues().apply {
            put("alumno", obj.nombre)
            put("matricula", obj.matricula)
            put("tipo", obj.tipoVehiculo)
            put("marca", obj.marca)
            put("placa", obj.placa)
        }
        val resultado = db.insert("vehiculo", null, valores)
        db.close()
        return resultado != -1L
    }

    override fun actualizar(obj: Vehiculo): Boolean {
        val db = dbHelper.writableDatabase
        val valores = ContentValues().apply {
            put("alumno", obj.nombre)
            put("matricula", obj.matricula)
            put("tipo", obj.tipoVehiculo)
            put("marca", obj.marca)
            put("placa", obj.placa)
        }
        val resultado = db.update(
            "vehiculo",
            valores,
            "id = ?",
            arrayOf(obj.id.toString())
        )
        db.close()
        return resultado > 0
    }

    override fun eliminar(id: Int): Boolean {
        val db = dbHelper.writableDatabase
        val resultado = db.delete("vehiculo", "id = ?", arrayOf(id.toString()))
        db.close()
        return resultado > 0
    }

    override fun obtenerTodos(): ArrayList<Vehiculo> {
        val lista = ArrayList<Vehiculo>()
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM vehiculo", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val nombre = cursor.getString(1)
                val matricula = cursor.getString(2)
                val tipo = cursor.getString(3)
                val marca = cursor.getString(4)
                val placa = cursor.getString(5)

                val vehiculo = when (tipo.lowercase()) {
                    "automovil" -> Automovil(id, nombre, matricula, tipo, marca, placa)
                    "motocicleta" -> Motocicleta(id, nombre, matricula, tipo, marca, placa)
                    else -> null
                }

                vehiculo?.let { lista.add(it) }

            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return lista
    }
}

