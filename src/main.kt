fun main() {
    var concesionario = Factory.Factoria().crearConcesionario()

    println("Todos los vehículos: ${concesionario.obtenerTodos().contentToString()}")
    println("\nPromedio de kilómetros de los coches eléctricos: ${concesionario.promedioPor({ it.kilometros.toDouble() }, { it is Models.CocheElectrico })}")
    println("\nVehículo con menos kilómetros: ${concesionario.minimoPor { it.kilometros }}")
    println("\nCoche eléctrico con mayor autonomía y menos kilómetros: ${concesionario.obtenerElectricoMayorAutonomiaMenosKm()}")
    println("\nTodas las bicicletas: ${concesionario.filtrarPor { it is Models.Bicicleta }.contentToString()}")
    println("\nPromedio de potencia de los coches de gasolina: ${concesionario.promedioPor({ (it as? Models.CocheGasolina)?.calcularPotencia()?.toDouble() ?: 0.0 },{ it is Models.CocheGasolina })}")
}