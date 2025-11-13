package com.example.dbapp.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.dbapp.db.UniversidadDBHelper
import com.example.dbapp.model.Alumno
import com.example.dbapp.model.Automovil
import com.example.dbapp.model.Motocicleta

class VehiculoDAO(context: Context) : ICrud<Alumno> {

    private val dbHelper = UniversidadDBHelper(context)

    override fun insertar(obj: Alumno): Boolean {
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

    override fun actualizar(obj: Alumno): Boolean {
        val db = dbHelper.writableDatabase
        val valores = ContentValues().apply {
            put("alumno", obj.nombre)
            put("matricula", obj.matricula)
            put("tipo", obj.tipoVehiculo)
            put("marca", obj.marca)
            put("placa", obj.placa)
        }
        val resultado = db.update("vehiculo", valores, "id = ?", arrayOf(obj.id.toString()))
        db.close()
        return resultado > 0
    }

    override fun eliminar(id: Int): Boolean {
        val db = dbHelper.writableDatabase
        val resultado = db.delete("vehiculo", "id = ?", arrayOf(id.toString()))
        db.close()
        return resultado > 0
    }

    override fun obtenerTodos(): ArrayList<Alumno> {
        val lista = ArrayList<Alumno>()
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM vehiculo", null)

        if (cursor.moveToFirst()) {
            do {
                val tipo = cursor.getString(3)
                val alumno = if (tipo.lowercase() == "automovil") {
                    Automovil(
                        id = cursor.getInt(0),
                        nombre = cursor.getString(1),
                        matricula = cursor.getString(2),
                        tipoVehiculo = tipo,
                        marca = cursor.getString(4),
                        placa = cursor.getString(5)
                    )
                } else {
                    Motocicleta(
                        id = cursor.getInt(0),
                        nombre = cursor.getString(1),
                        matricula = cursor.getString(2),
                        tipoVehiculo = tipo,
                        marca = cursor.getString(4),
                        placa = cursor.getString(5)
                    )
                }
                lista.add(alumno)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return lista
    }
}
