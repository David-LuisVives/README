package Models

import kotlin.random.Random

class Bicicleta(
    id: Int,
    matricula: String,
    kilometros: Int,
    fechaMatriculacion: String
) : Vehiculo(id, matricula, kilometros, fechaMatriculacion) {

    fun esElectrica(): Boolean {
        return Random.nextBoolean()
    }

    override fun toString(): String {
        return ("\nBicicleta: (id: $id, matricula: $matricula, kilometros: $kilometros)")
    }
}