package com.example.dbapp.model

class Automovil(
    id: Int = 0,
    nombre: String = "",
    matricula: String = "",
    tipoVehiculo: String = "Automovil",
    marca: String = "",
    placa: String = ""
) : Alumno(id, nombre, matricula, tipoVehiculo, marca, placa)
