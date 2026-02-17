package ejercicios.uees;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese su sexo (M/F): ");
        char sexo = sc.next().toUpperCase().charAt(0);

        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();

        System.out.println("\nResultado:");

        if (sexo == 'M') {
            if (edad >= 60) {
                System.out.println("El empleado " + nombre + " ya tiene edad para jubilarse.");
            } else {
                System.out.println("El empleado " + nombre + " aún no tiene edad para jubilarse.");
            }
        }

        if (sexo != 'F') {
            return;
        }
        if (edad >= 54) {
            System.out.println("La empleada " + nombre + " ya tiene edad para jubilarse.");
        } else {
            System.out.println("La empleada " + nombre + " aún no tiene edad para jubilarse.");
        }

        sc.close();

    }
}