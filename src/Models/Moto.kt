package Models

import kotlin.random.Random

class Moto(
    id: Int,
    matricula: String,
    kilometros: Int,
    fechaMatriculacion: String
) : Vehiculo(id, matricula, kilometros, fechaMatriculacion) {

    fun calcularVelocidadMaxima(): Int {
        return Random.nextInt(80, 250)
    }

    override fun toString(): String {
        return ("\nMoto: (id: $id, matricula: $matricula, kilometros: $kilometros)")
    }
}