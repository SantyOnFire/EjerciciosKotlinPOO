fun main() {

    val listaLibros = mutableListOf<Libro>()

    val libro1 = Libro("La Tregua", "Mario Bennedetti", "1234567890", 203, 25.99, 10)
    listaLibros.add(libro1)

    var opcion = 0
    do {
        println("\n---- MENÚ DE BIBLIOTECA ----")
        println("1. Mostrar todos los libros")
        println("2. Prestar un libro")
        println("3. Devolver un libro")
        println("4. Crear un nuevo libro")
        println("5. Modificar libro por ISBN")
        println("6. Buscar libro por ISBN")
        println("0. Salir")
        print("Seleccione una opción: ")

        try {
            opcion = readLine()?.toInt() ?: 0

            when (opcion) {
                1 -> {
                    println("\nListado de libros:")
                    for (libro in listaLibros) {
                        libro.mostrarInfo()
                        println("-----------------------")
                    }
                }
                2 -> {
                    print("Ingrese el ISBN del libro a prestar: ")
                    val isbn = readLine() ?: ""
                    var encontrado = false

                    for (libro in listaLibros) {
                        if (libro.Isbm == isbn) {
                            encontrado = true
                            if (libro.prestarLibro()) {
                                println("Libro prestado con éxito.")
                            } else {
                                println("No se pudo prestar el libro.")
                            }
                            break
                        }
                    }

                    if (!encontrado) {
                        println("Libro no encontrado en la biblioteca.")
                    }
                }
                3 -> {
                    print("Ingrese el ISBN del libro a devolver: ")
                    val isbn = readLine() ?: ""
                    var encontrado = false

                    for (libro in listaLibros) {
                        if (libro.Isbm == isbn) {
                            encontrado = true
                            libro.devolverLibro()
                            break
                        }
                    }

                    if (!encontrado) {
                        println("Libro no encontrado en la biblioteca.")
                    }
                }
                4 -> {

                    if (listaLibros.size >= 4) {
                        println("Ya has creado el máximo de libros permitidos (4).")
                    } else {
                        val nuevoLibro = crearNuevoLibro()
                        listaLibros.add(nuevoLibro)
                        println("Libro agregado correctamente.")
                    }
                }
                5 -> {
                    print("Ingrese el ISBN del libro a modificar: ")
                    val isbn = readLine() ?: ""
                    var encontrado = false

                    for (libro in listaLibros) {
                        if (libro.Isbm == isbn) {
                            encontrado = true
                            modificarLibro(libro)
                            break
                        }
                    }

                    if (!encontrado) {
                        println("Libro no encontrado en la biblioteca.")
                    }
                }
                6 -> {
                    print("Ingrese el ISBN del libro a buscar: ")
                    val isbn = readLine() ?: ""
                    var encontrado = false

                    for (libro in listaLibros) {
                        if (libro.Isbm == isbn) {
                            encontrado = true
                            println("Libro encontrado:")
                            libro.mostrarInfo()
                            break
                        }
                    }

                    if (!encontrado) {
                        println("Libro no encontrado en la biblioteca.")
                    }
                }
                0 -> println("Saliendo del programa...")
                else -> println("Opción no válida. Intente de nuevo.")
            }

        } catch (e: Exception) {
            println("Error: Ingrese un número válido.")
            opcion = -1
        }

    } while (opcion != 0)
}


fun crearNuevoLibro(): Libro {
    println("Ingrese los datos del nuevo libro:")

    print("Título: ")
    val titulo = readLine() ?: ""

    print("Autor: ")
    val autor = readLine() ?: ""

    print("ISBN: ")
    val isbn = readLine() ?: ""

    print("Número de páginas: ")
    val paginas = readLine()?.toIntOrNull() ?: 0

    print("Precio: ")
    val precio = readLine()?.toDoubleOrNull() ?: 0.0

    print("Cantidad disponible: ")
    val cantidad = readLine()?.toIntOrNull() ?: 0

    return Libro(titulo, autor, isbn, paginas, precio, cantidad)
}


fun modificarLibro(libro: Libro) {
    println("Modificando libro con ISBN: ${libro.Isbm}")
    println("Deje en blanco para mantener el valor actual")

    print("Título (${libro.titulo}): ")
    val titulo = readLine() ?: ""
    if (titulo.isNotEmpty()) libro.titulo = titulo

    print("Autor (${libro.Autor}): ")
    val autor = readLine() ?: ""
    if (autor.isNotEmpty()) libro.Autor = autor

    print("Número de páginas (${libro.numeroPaginas}): ")
    val paginasStr = readLine() ?: ""
    if (paginasStr.isNotEmpty()) {
        libro.numeroPaginas = paginasStr.toIntOrNull() ?: libro.numeroPaginas
    }

    print("Precio (${libro.precio}): ")
    val precioStr = readLine() ?: ""
    if (precioStr.isNotEmpty()) {
        libro.precio = precioStr.toDoubleOrNull() ?: libro.precio
    }

    print("Cantidad disponible (${libro.cantidadDisponible}): ")
    val cantidadStr = readLine() ?: ""
    if (cantidadStr.isNotEmpty()) {
        libro.cantidadDisponible = cantidadStr.toIntOrNull() ?: libro.cantidadDisponible
    }

    println("Libro modificado correctamente.")
}