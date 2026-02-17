package ejercicios.uees;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double suma = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Ingrese la nota " + i + ": ");
            suma += sc.nextDouble();
        }

        double promedio = suma / 5;

        System.out.println("\nEl promedio es: " + promedio);

        sc.close();
    }
}
