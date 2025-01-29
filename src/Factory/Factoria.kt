package Factory

import Models.Concesionario
import kotlin.random.Random

class Factoria {

    // Genera el concesionario y agrega los vehículos.
    fun crearConcesionario(): Concesionario {
        val concesionario = Models.Concesionario()

        repeat(5) { id ->
            val tipoVehiculo = Random.nextInt(1, 5)
            val matricula = generarMatriculaAleatoria()
            val kilometros = Random.nextInt(0, 100_000)
            val fechaMatriculacion = generarFechaAleatoria()

            when (tipoVehiculo) {
                1 -> concesionario.guardar(
                    Models.CocheGasolina(id, matricula, kilometros, fechaMatriculacion)
                )
                2 -> concesionario.guardar(
                    Models.CocheElectrico(id, matricula, kilometros, fechaMatriculacion)
                )
                3 -> concesionario.guardar(
                    Models.Moto(id, matricula, kilometros, fechaMatriculacion)
                )
                4 -> concesionario.guardar(
                    Models.Bicicleta(id, matricula, kilometros, fechaMatriculacion)
                )
            }
        }
        return concesionario
    }

    /**
     * Genera una matrícula aleatoria compuesta por cuatro números y tres letras.
     * @return una cadena con la matrícula generada.
     */
    fun generarMatriculaAleatoria(): String {
        val numeros = (1000..9999).random()
        val letras = (1..3).map { ('A'..'Z').random() }.joinToString("")
        return "$numeros$letras"
    }

    /**
     * Genera una fecha aleatoria con año, mes y día dentro de un rango específico.
     * @return una cadena con la fecha generada en formato Año-Mes-Día.
     */
    fun generarFechaAleatoria(): String {
        val year = Random.nextInt(1980, 2023)
        val month = (1..12).random()
        val day = (1..28).random()
        return "$year-$month-$day"
    }
}