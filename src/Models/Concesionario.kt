package Models

class Concesionario {
    private var vehiculos = arrayOf<Vehiculo>()

    fun obtenerTodos(): Array<Vehiculo> = vehiculos

    fun obtenerPorId(id: Int): Vehiculo? {
        return vehiculos.find { it.id == id }
    }

    fun guardar(vehiculo: Vehiculo) {
        if (vehiculos.any { it.id == vehiculo.id }) {
            println("El vehículo con ID ${vehiculo.id} ya existe.")
        } else {
            vehiculos += vehiculo
        }
    }

    fun actualizar(id: Int, vehiculoActualizado: Vehiculo) {
        vehiculos = vehiculos.map {
            if (it.id == id) vehiculoActualizado else it
        }.toTypedArray()
    }

    fun eliminar(id: Int) {
        vehiculos = vehiculos.filter { it.id != id }.toTypedArray()
    }

    fun filtrarPor(predicado: (Vehiculo) -> Boolean = { true }): Array<Vehiculo> {
        return vehiculos.filter(predicado).toTypedArray()
    }

    fun promedioPor(selector: (Vehiculo) -> Double, predicado: (Vehiculo) -> Boolean = { true }): Double {
        val filtrados = vehiculos.filter(predicado)
        return if (filtrados.isNotEmpty()) filtrados.map(selector).reduce { acc, d -> acc + d } / filtrados.size else 0.0
    }

    fun contarPor(predicado: (Vehiculo) -> Boolean = { true }): Int {
        return vehiculos.count(predicado)
    }

    fun maximoPor(selector: (Vehiculo) -> Int): Vehiculo? {
        return vehiculos.maxByOrNull(selector)
    }

    fun minimoPor(selector: (Vehiculo) -> Int): Vehiculo? {
        return vehiculos.minByOrNull(selector)
    }

    fun obtenerElectricoMayorAutonomiaMenosKm(): CocheElectrico? {
        return vehiculos
            .filter { it is CocheElectrico }
            .map { it as CocheElectrico }
            .minWithOrNull(compareBy({ it.kilometros }, { -it.calcularAutonomia() }))
    }
}