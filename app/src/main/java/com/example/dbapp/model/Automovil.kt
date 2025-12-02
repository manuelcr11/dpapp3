package com.example.dbapp.model

/**
 * Representa un alumno que posee un automóvil.
 */
class Automovil(
    id: Int = 0,
    nombre: String = "",
    matricula: String = "",
    marca: String = "",
    placa: String = ""
) : Alumno(
    id = id,
    nombre = nombre,
    matricula = matricula,
    tipoVehiculo = "Automóvil",
    marca = marca,
    placa = placa
)

