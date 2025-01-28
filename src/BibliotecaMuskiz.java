import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BibliotecaMuskiz {
    public static void main() {
        // Se inicializa las variables
        int option;
        Scanner teclado = new Scanner(System.in);
        // Se realiza control de errores para que no introduzca ninguna letra
        try {
            // Se realiza bucle para la selección de opciones
            do {
                // Se imprime menu
                System.out.println("Gestión de la Biblioteca de Muskiz");
                System.out.println("----------------------------------");
                System.out.println("  1) Votación de Género");
                System.out.println("  2) Revisión de Entrega");
                System.out.println("  3) Estadisticas de Libros");
                System.out.println("  4) Revisión de Inventario");
                System.out.println("  0) Salir");
                System.out.print("Escoge una de las opciones: ");
                // Recoge numero que se introduce por teclado
                option = teclado.nextInt();
                // Se realiza limpieza de teclado para evitar los bugs que provocan utilizar el
                // teclado en otras funciones
                teclado.nextLine();
                // Se comprueba que opción se ha escogido y se llama a la funcion a la que
                // corresponda
                switch (option) {
                    case 0:
                        System.out.println("Gracias por Usar el Programa");
                        break;

                    case 1:
                        System.out.println("Votación de Género");
                        System.out.println("------------------");
                        votacion(teclado);
                        break;

                    case 2:
                        System.out.println("Revisión de Entrega");
                        System.out.println("-------------------");
                        revision(teclado);
                        break;

                    case 3:
                        System.out.println("Estadisticas de Libros");
                        System.out.println("-----------------------");
                        estadisticas(teclado);
                        break;

                    case 4:
                        System.out.println("Revisión de Inventario");
                        System.out.println("----------------------");
                        inventario(teclado);
                        break;

                    default:
                        System.out.println("Error: valor fuera de rango (Valores validos 0 a 4)");
                        break;
                }
            } while (option != 0);
        } catch (Exception e) {
            System.out.println("Error: carácter no valido (Valores validos 0 a 4)");
            main();
        } finally {
            teclado.close();
        }
    }

    public static void votacion(Scanner teclado) {
        // Variables para el primer ejercicio (estadísticas de género)
        int cont = 0;
        int op;
        int contPolitica = 0;
        int contNarrativa = 0;
        int contDrama = 0;
        int contTerror = 0;
        int votos1 = 0;
        int votos2 = 0;
        int votos3 = 0;
        int votos4 = 0;
        String genero1 = "";
        String genero2 = "";
        String genero3 = "";
        String genero4 = "";

        try {
            // Menú para preguntar al usuario cuál es su género favorito
            while (cont < 100) {
                System.out.println("Indica cuál es tu género favorito:");
                System.out.println("1- Teoría Política");
                System.out.println("2- Narrativa Fantástica");
                System.out.println("3- Terror Espacial");
                System.out.println("4- Drama Coreano");
                System.out.print("Escoge su opción: ");
                op = teclado.nextInt();

                switch (op) {
                    case 1:
                        contPolitica++;
                        cont++;
                        break;
                    case 2:
                        contNarrativa++;
                        cont++;
                        break;
                    case 3:
                        contDrama++;
                        cont++;
                        break;
                    case 4:
                        contTerror++;
                        cont++;
                        break;
                    default:
                        System.out.println("Este número no corresponde a ningún género, inténtelo de nuevo");
                        break;
                }

            }
            // Encontrar cuántos votos ha obtenido cada género, cuál es el más votado y
            // ordenarlos de mayor a menor votado
            if (contPolitica >= contNarrativa && contPolitica >= contTerror && contPolitica >= contDrama) {
                votos1 = contPolitica;
                genero1 = "Teoría Política";
                if (contNarrativa >= contTerror && contNarrativa >= contDrama) {
                    votos2 = contNarrativa;
                    genero2 = "Narrativa Fantástica";
                    if (contTerror >= contDrama) {
                        votos3 = contTerror;
                        genero3 = "Terror Espacial";
                        votos4 = contDrama;
                        genero4 = "Drama Coreano";
                    } else {
                        votos3 = contDrama;
                        genero3 = "Drama Coreano";
                        votos4 = contTerror;
                        genero4 = "Terror Espacial";
                    }
                } else if (contTerror >= contNarrativa && contTerror >= contDrama) {
                    votos2 = contTerror;
                    genero2 = "Terror Espacial";
                    if (contNarrativa >= contDrama) {
                        votos3 = contNarrativa;
                        genero3 = "Narrativa Fantástica";
                        votos4 = contDrama;
                        genero4 = "Drama Coreano";
                    } else {
                        votos3 = contDrama;
                        genero3 = "Drama Coreano";
                        votos4 = contNarrativa;
                        genero4 = "Narrativa Fantástica";
                    }
                } else if (contDrama >= contNarrativa && contDrama >= contTerror) {
                    votos2 = contDrama;
                    genero2 = "Narrativa Fantástica";
                    if (contNarrativa >= contTerror) {
                        votos3 = contNarrativa;
                        genero3 = "Narrativa Fantástica";
                        votos4 = contTerror;
                        genero4 = "Terror Espacial";
                    } else {
                        votos3 = contTerror;
                        genero3 = "Terror Espacial";
                        votos4 = contNarrativa;
                        genero4 = "Narrativa Fantástica";
                    }
                }
            } else if (contNarrativa >= contPolitica && contNarrativa >= contTerror && contNarrativa >= contDrama) {
                votos1 = contNarrativa;
                genero1 = "Narrativa Fantástica";
                if (contPolitica >= contTerror && contPolitica >= contDrama) {
                    votos2 = contPolitica;
                    genero2 = "Teoría Política";
                    if (contTerror >= contDrama) {
                        votos3 = contTerror;
                        genero3 = "Terror Espacial";
                        votos4 = contDrama;
                        genero4 = "Drama Coreano";
                    } else {
                        votos3 = contDrama;
                        genero3 = "Dreama Coreano";
                        votos4 = contTerror;
                        genero4 = "Terror Espacial";
                    }
                } else if (contTerror >= contPolitica && contTerror >= contDrama) {
                    votos2 = contTerror;
                    genero2 = "Terror Espacial";
                    if (contPolitica >= contDrama) {
                        votos3 = contPolitica;
                        genero3 = "Teoría Política";
                        votos4 = contDrama;
                        genero4 = "Drama Coreano";
                    } else {
                        votos3 = contDrama;
                        genero3 = "Drama Coreano";
                        votos4 = contPolitica;
                        genero4 = "Teoría Política";
                    }
                } else if (contDrama >= contPolitica && contDrama >= contTerror) {
                    votos2 = contDrama;
                    genero2 = "Drama Coreano";
                    if (contPolitica >= contTerror) {
                        votos3 = contPolitica;
                        genero3 = "Teoría Política";
                        votos4 = contTerror;
                        genero4 = "Terror Espacial";
                    } else {
                        votos3 = contTerror;
                        genero3 = "Terror Espacial";
                        votos4 = contPolitica;
                        genero4 = "Teoría Política";
                    }
                }
            } else if (contTerror >= contPolitica && contTerror >= contNarrativa && contTerror >= contDrama) {
                votos1 = contTerror;
                genero1 = "Terror Espacial";
                if (contPolitica >= contNarrativa && contPolitica >= contDrama) {
                    votos2 = contPolitica;
                    genero2 = "Teoría Política";
                    if (contNarrativa >= contDrama) {
                        votos3 = contNarrativa;
                        genero3 = "Narrativa Fantástica";
                        votos4 = contDrama;
                        genero4 = "Drama Coreano";
                    } else {
                        votos3 = contDrama;
                        genero3 = "Drama Coreano";
                        votos4 = contNarrativa;
                        genero4 = "Narrativa Fantástica";
                    }
                } else if (contNarrativa >= contPolitica && contNarrativa >= contDrama) {
                    votos2 = contNarrativa;
                    genero2 = "Narrativa Fantástica";
                    if (contPolitica >= contDrama) {
                        votos3 = contPolitica;
                        genero3 = "Teoría Política";
                        votos4 = contDrama;
                        genero4 = "Drama Coreano";
                    } else {
                        votos3 = contDrama;
                        genero3 = "Drama Coreano";
                        votos4 = contPolitica;
                        genero4 = "Teoría Política";
                    }
                } else if (contDrama >= contPolitica && contDrama >= contNarrativa) {
                    votos2 = contDrama;
                    genero2 = "Drama Coreano";
                    if (contPolitica >= contNarrativa) {
                        votos3 = contPolitica;
                        genero3 = "Teoría Política";
                        votos4 = contNarrativa;
                        genero4 = "Narrativa Fantástica";
                    } else {
                        votos3 = contNarrativa;
                        genero3 = "Narrativa Fantástica";
                        votos4 = contPolitica;
                        genero4 = "Teoría Política";
                    }
                }
            } else {
                votos1 = contDrama;
                genero1 = "Drama Coreano";
                if (contPolitica >= contNarrativa && contPolitica >= contTerror) {
                    votos2 = contPolitica;
                    genero2 = "Teoría Política";
                    if (contNarrativa >= contTerror) {
                        votos3 = contTerror;
                        genero3 = "Terror Espacial";
                        votos4 = contDrama;
                        genero4 = "Drama Coreano";
                    } else {
                        votos3 = contDrama;
                        genero3 = "Drama Coreano";
                        votos4 = contTerror;
                        genero4 = "Terror Espacial";
                    }
                } else if (contNarrativa >= contPolitica && contNarrativa >= contTerror) {
                    votos2 = contNarrativa;
                    genero2 = "Narrativa Fantástica";
                    if (contPolitica >= contTerror) {
                        votos3 = contPolitica;
                        genero3 = "Teoría Política";
                        votos4 = contTerror;
                        genero4 = "Terror Espacial";
                    } else {
                        votos3 = contTerror;
                        genero3 = "Terror Espacial";
                        votos4 = contPolitica;
                        genero4 = "Teoría Política";
                    }
                } else if (contTerror >= contPolitica && contTerror >= contNarrativa) {
                    votos2 = contTerror;
                    genero2 = "Terror Espacial";
                    if (contPolitica >= contNarrativa) {
                        votos3 = contPolitica;
                        genero3 = "Teoría Política";
                        votos4 = contNarrativa;
                        genero4 = "Narrativa Fantástica";
                    } else {
                        votos3 = contNarrativa;
                        genero3 = "Narrativa Fantástica";
                        votos4 = contPolitica;
                        genero4 = "Teoría Política";
                    }
                }
            }
            // Género más votadoo
            System.out.println("El género más votado ha sido " + genero1 + ", con " + votos1 + " votos.");
            // Géneros ordenados de mayor a menor
            System.out.println("El orden de géneros má votados es: " + genero1 + " con " + votos1 + " votos, " + genero2
                    + " con " + votos2 + " votos, " + genero3 + " con " + votos3 + " votos y " + genero4 + " con "
                    + votos4 + " votos.");

        } catch (Exception e) {
            // Se indica el error que se ha sucedido
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }

    public static void revision(Scanner teclado) {

        // Configuración del formato de fecha
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Captura de errores
        try {
            // Entrada de datos
            System.out.print("Ingrese la fecha de reserva del libro (formato: AAAA-MM-DD): ");
            String fechaEntregaStr = teclado.nextLine();

            System.out.print("Ingrese el número máximo de días de reserva: ");
            int diasMaximos = teclado.nextInt();

            // Obtener la fecha actual
            LocalDate fechaActual = LocalDate.now();

            // Parsear la fecha de entrega
            LocalDate fechaEntrega = LocalDate.parse(fechaEntregaStr, formatoFecha);

            // Calcular la fecha límite de reserva
            LocalDate fechaLimite = fechaEntrega.plusDays(diasMaximos);

            // Validar si se ha pasado la fecha
            if (fechaActual.isAfter(fechaLimite)) {
                System.out.println("Se ha pasado de fecha.");
                System.out.println("Se debe penalizar al usuario");
            } else {
                System.out.println("La fecha está dentro de plazo.");
            }
        } catch (Exception e) {
            // Se indica el error que se ha sucedido
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

    }

    public static void estadisticas(Scanner teclado) {
        // Se declara variables iniciales
        String titulo = "", titMax = "", titmin = "";
        int pag = 0, totPag = 0, pagMax = 0, pagMin = Integer.MAX_VALUE, cantLib = 0, cantLib300 = 0;
        // Se realiza capturas de errores
        try {
            // Realizamos un bucle en el cual se saldra cuando ponga Termine
            // Se le pedira titulo del libro y su numero de paginas para hayar la media de
            // paginas, cuantos son más de 300 pags y el libro con más y con menos paginas
            while (!titulo.equals("Termine")) {
                System.out.print("Introduce titulo del libro (Introduzca \"Termine\" para acabar): ");
                titulo = teclado.nextLine();
                if (titulo.equals("Termine")) {
                    break;
                }
                System.out.print("Introduce numero de paginas del libro " + titulo + ": ");
                pag = teclado.nextInt();
                teclado.nextLine();
                totPag += pag;
                cantLib++;
                if (pag > pagMax) {
                    pagMax = pag;
                    titMax = titulo;
                }
                if (pag < pagMin) {
                    pagMin = pag;
                    titmin = titulo;
                }
                if (pag >= 300) {
                    cantLib300++;
                }
            }
            // Segun cuantos datos haya introducido, se le mostrara un mensaje distinto
            if (cantLib == 0) {
                System.out.println("No se ha introducido ningun libro");
            } else {
                System.out.println("Media de páginas de todos los libros: " + (totPag / cantLib));
                if (pagMax == 0) {
                    System.out.println("No se ha introducido ningun libro con más de 0 paginas");
                } else {
                    System.out.println("Título del libro con más páginas: " + titMax);
                }
                if (pagMin == Integer.MAX_VALUE) {
                    System.out.println(
                            "No se ha introducido ningun libro con menos paginas que el numero más alto que el Integer en Java");
                } else {
                    System.out.println("Título del libro con menos páginas: " + titmin);
                }
                if (cantLib300 == 0) {
                    System.out.println("No se ha introducido ningun libro con más de 300 paginas");
                } else {
                    System.out.println("Cantidad de libros que tienen 300 páginas o más: " + cantLib300);
                }
            }
        } catch (Exception e) {
            // Se indica el error que se ha sucedido
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }

    public static void inventario(Scanner teclado) {
        // Se declara variables y se les da un valor inicial
        int totLibros = 45000, numLibros = 0;
        String titLibros;
        // Se realiza una captura de errores
        try {
            // Se realiza un bucle en el que se van pidiendo nombres de libros, en el cual
            // se comprueba el inventario
            do {
                System.out.print("Indica nombre del libro: ");
                titLibros = teclado.nextLine();
                if (titLibros.isEmpty() != true) {
                    numLibros++;
                }
            } while (numLibros < totLibros && titLibros.isEmpty() == false);
            // Se comprueba si esta el inventario correcto y si no esta, indican cuantos
            // libros faltan
            if (numLibros == totLibros) {
                System.out.println("El inventario esta correcto");
            } else {
                System.out.println("Faltan " + (totLibros - numLibros) + " libros");
            }
        } catch (Exception e) {
            // Se indica el error que se ha sucedido
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }
}
