package com.example.dbapp.model

/**
 * Representa un alumno con datos personales y su vehículo.
 */
data class Alumno(
    val matricula: String,          // Será el ID
    val nombre: String,
    val apellidoPaterno: String,
    val apellidoMaterno: String,
    val tipoVehiculo: String,       // "Moto" o "Automóvil"
    val modelo: String,
    val placa: String
) {
    init {
        require(matricula.isNotBlank()) { "La matrícula no puede estar vacía." }
        require(nombre.isNotBlank()) { "El nombre no puede estar vacío." }
        require(placa.isNotBlank()) { "La placa no puede estar vacía." }
    }
}
