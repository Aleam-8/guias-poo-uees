package ejercicios.uees;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el radio del cono (cm): ");
        double radio = sc.nextDouble();

        System.out.print("Ingrese la altura del cono (cm): ");
        double altura = sc.nextDouble();

        double generatriz = Math.sqrt(Math.pow(radio, 2) + Math.pow(altura, 2));

        double areaTotal = Math.PI * radio * (radio + generatriz);

        System.out.println("\nResultado:");
        System.out.println("El area total del cono es: " + areaTotal + " cm^2");

        sc.close();
    }
}
