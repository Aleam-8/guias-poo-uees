package ejercicios;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la mascota: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el tipo de mascota: ");
        String tipo = sc.nextLine();

        System.out.print("Ingrese la edad de la mascota: ");
        int edad = sc.nextInt();

        System.out.println("\nInformación de la Mascota:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo: " + tipo);
        System.out.println("Edad: " + edad + " años");

        System.out.println(nombre + " está comiendo.");
        System.out.println(nombre + " está durmiendo.");

        sc.close();
    }
}