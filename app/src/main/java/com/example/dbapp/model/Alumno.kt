package com.example.dbapp.model

/**
 * Modelo de Alumno con validaciones básicas.
 */
data class Alumno(
    val id: Int = 0,
    val nombre: String,
    val matricula: String,
    val tipoVehiculo: String,
    val marca: String,
    val placa: String
) {
    init {
        require(nombre.isNotBlank()) { "El nombre no puede estar vacío." }
        require(matricula.isNotBlank()) { "La matrícula no puede estar vacía." }
        require(placa.isNotBlank()) { "La placa no puede estar vacía." }
    }
}

