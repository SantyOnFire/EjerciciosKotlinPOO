// Archivo: Libro.kt

class Libro {
    var titulo: String = ""
    var Autor: String = ""
    var Isbm: String = ""
    var numeroPaginas: Int = 0
    var precio: Double = 0.0
    var cantidadDisponible: Int = 0

    constructor()

    constructor(
        titulo: String,
        Autor: String,
        Isbm: String,
        numeroPaginas: Int,
        precio: Double,
        cantidadDisponible: Int
    ) {
        this.titulo = titulo
        this.Autor = Autor
        this.Isbm = Isbm
        this.numeroPaginas = numeroPaginas
        this.precio = precio
        this.cantidadDisponible = cantidadDisponible
    }

    fun prestarLibro(): Boolean {
        if (cantidadDisponible <= 0) {
            println("No hay ejemplares disponibles para préstamo.")
            return false
        }

        cantidadDisponible--
        println("El libro ha sido prestado")
        return true
    }

    fun devolverLibro() {
        cantidadDisponible++
        println("Libro devuelto correctamente. Cantidad disponible: $cantidadDisponible")
    }

    fun mostrarInfo() {
        println("Título: $titulo")
        println("Autor: $Autor")
        println("ISBN: $Isbm")
        println("Número de páginas: $numeroPaginas")
        println("Precio: $precio €")
        println("Cantidad disponible: $cantidadDisponible")
    }

    override fun toString(): String {
        return "Libro(titulo='$titulo', Autor='$Autor', Isbm='$Isbm', numeroPaginas=$numeroPaginas, precio=$precio, cantidadDisponible=$cantidadDisponible)"
    }
}