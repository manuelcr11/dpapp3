package com.example.dbapp.model

/**
 * Representa un alumno que posee una motocicleta.
 */
class Motocicleta(
    id: Int = 0,
    nombre: String = "",
    matricula: String = "",
    marca: String = "",
    placa: String = ""
) : Alumno(
    id = id,
    nombre = nombre,
    matricula = matricula,
    tipoVehiculo = "Motocicleta",
    marca = marca,
    placa = placa
)

