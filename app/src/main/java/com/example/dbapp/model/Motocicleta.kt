package com.example.dbapp.model

class Motocicleta(
    id: Int = 0,
    nombre: String = "",
    matricula: String = "",
    tipoVehiculo: String = "Motocicleta",
    marca: String = "",
    placa: String = ""
) : Alumno(id, nombre, matricula, tipoVehiculo, marca, placa)
