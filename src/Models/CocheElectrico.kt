package Models

import kotlin.random.Random

class CocheElectrico(
    id: Int,
    matricula: String,
    kilometros: Int,
    fechaMatriculacion: String
) : Vehiculo(id, matricula, kilometros, fechaMatriculacion) {

    fun calcularAutonomia(): Double {
        return Random.nextDouble(200.0, 500.0)
    }

    override fun toString(): String {
        return ("\nCocheElectrico: (id: $id, matricula: $matricula, kilometros: $kilometros)")
    }
}