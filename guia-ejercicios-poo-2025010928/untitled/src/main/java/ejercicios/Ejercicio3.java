package ejercicios;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el título del libro: ");
        String titulo = sc.nextLine();

        System.out.print("Ingrese el autor del libro: ");
        String autor = sc.nextLine();

        boolean disponible = true;

        int opcion;

        do {
            System.out.println("\n--- MENÚ BIBLIOTECA ---");
            System.out.println("1. Prestar libro");
            System.out.println("2. Devolver libro");
            System.out.println("3. Mostrar estado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if (disponible) {
                        disponible = false;
                        System.out.println("Libro prestado correctamente.");
                    } else {
                        System.out.println("El libro no está disponible.");
                    }
                    break;

                case 2:
                    disponible = true;
                    System.out.println("Libro devuelto correctamente.");
                    break;

                case 3:
                    System.out.println("Título: " + titulo);
                    System.out.println("Autor: " + autor);
                    System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}