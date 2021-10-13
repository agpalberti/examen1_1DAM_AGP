
fun parimpar(mes:Byte):String{
    return if (mes%2 == 0) "par"
    else "impar"
} //Devuelve si el mes es par o impar
fun rangoedad(edad:Byte):IntRange{
    return when(edad){
        in 6..8 -> 6..8
        in 9..10 -> 9..10
        in 11..12 -> 11..12
        else -> 0..0
    }
} //Devuelve a que rango de edad pertenece según la edad
fun tablascorresp(edad:Byte,mes: Byte):List<Byte>{
    return when (rangoedad(edad)){
        6..8 -> if (parimpar(mes)=="par") listOf(2,4) else listOf(1,3,5)
        9..10 -> if (parimpar(mes)=="par") listOf(6,8,10) else listOf(7,9)
        11..12 -> listOf(11,12,13)
        else -> emptyList()
    }
} //Devuelve una lista de las tablas que le corresponden
fun tablas(param:List<Byte>){
    var counter = 0
    repeat(param.size){
        while (counter<param.size){
            println("TABLA DEL ${param[counter]}")
            println("*".repeat(11))
            for(i in 1..10){
                println("${param[counter]} x $i = ${param[counter]*i}")
            }
            println("\n")
            counter += 1
        }
    }
} //Imprime por pantalla las tablas correspondientes, según la lista proporcionada.


fun main() {
    val entrada: String
    val listaEntrada: List<String>
    val miNombre = "Alejandro González Parra"
    val edad: Byte
    val mes: Byte

    println("Introduzca la configuración del programa en este formato: <edadDelAlumno>,  <mesActual>")
    entrada = readLine() ?: ""
    listaEntrada = entrada.split(",")

    println("*".repeat(80))
    println("PROGRAMA DE GENERACIÓN DE TABLAS: $miNombre")
    println("*".repeat(80))

    if (listaEntrada.size != 2) //Compruebo el tamaño de la lista, si es != 2, finaliza el programa
    {
        println("La entrada no es correcta")
        println("_".repeat(80))
    } else {
        edad = try {listaEntrada[0].trim().toByte()} catch (_: Exception) {-1}
        mes = try {listaEntrada[1].trim().toByte()} catch (_: Exception) {-1}

        if ((edad <= 0) || (mes <= 0)) // Si alguno es menor que -1, finaliza el programa
        {
            println("La entrada no es correcta")
            println("_".repeat(80))
        } else {
            if (mes in 1..12 && edad in 6..12) {
                println("Edad: $edad. El alumno está dentro del rango ${rangoedad(edad).first}-${rangoedad(edad).last}.")
                println("Mes: $mes. El mes es " + parimpar(mes) + ", le corresponden las tablas siguientes: ${tablascorresp(edad, mes)}.")
                println("_".repeat(80) + "\n\n")
                tablas(tablascorresp(edad,mes))

            }
            else {
                if (edad !in 6..12) println("Edad: $edad. No se contempla esta edad")
                if (mes !in 1..12) println("Mes: $mes. El mes es erróneo.")
                println("_".repeat(80))}
        }
    }
    println("*".repeat(80))
}