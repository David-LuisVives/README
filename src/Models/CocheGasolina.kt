package Models

import kotlin.random.Random

class CocheGasolina(
    id: Int,
    matricula: String,
    kilometros: Int,
    fechaMatriculacion: String
) : Models.Vehiculo(id, matricula, kilometros, fechaMatriculacion) {

    fun calcularPotencia(): Int {
        return Random.nextInt(100, 400)
    }

    override fun toString(): String {
        return ("\nCocheGasolina: (id: $id, matricula: $matricula, kilometros: $kilometros)")
    }
}