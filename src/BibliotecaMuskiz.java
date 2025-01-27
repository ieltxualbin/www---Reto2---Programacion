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
                System.out.println("  1) Ejercicio 1");
                System.out.println("  2) Revisión de Entrega");
                System.out.println("  3) Contabilición de Libros");
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
                        System.out.println("1");
                        break;

                    case 2:
                        System.out.println("Revisión de Entrega");
                        System.out.println("-------------------");
                        break;

                    case 3:
                        System.out.println("Contabilición de Libros");
                        System.out.println("-----------------------");
                        ejercicio3b(teclado);
                        break;

                    case 4:
                        System.out.println("Revisión de Inventario");
                        System.out.println("----------------------");
                        ejercicio4(teclado);
                        break;

                    default:
                        System.out.println("Error: valor fuera de rango (Valores validos 0 a 4)");
                        break;
                }
            } while (option != 0);
        } catch (Exception e) {
            System.out.println("Error: caracter no valido (Valores validos 0 a 4)");
            main();
        } finally {
            teclado.close();
        }
    }

    public static void ejercicio3b(Scanner teclado) {
        String titulo = "", titMax = "", titmin = "";
        int pag = 0, totPag = 0, pagMax = 0, pagMin = Integer.MAX_VALUE, cantLib = 0, cantLib300 = 0;
        try {
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

    public static void ejercicio4(Scanner teclado) {
        // Se declara variables y se les da un valor inicial
        int totLibros = 4500, numLibros = 0;
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
