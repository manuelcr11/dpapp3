package com.example.dbapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UniversidadDBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "UniversidadDB"
        const val DATABASE_VERSION = 2   // Súbelo cuando hagas cambios
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
            CREATE TABLE vehiculo (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                alumno TEXT NOT NULL,
                matricula TEXT NOT NULL,
                tipo TEXT NOT NULL,
                marca TEXT NOT NULL,
                placa TEXT NOT NULL
            );
            """
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS vehiculo")
        onCreate(db)
    }
}

