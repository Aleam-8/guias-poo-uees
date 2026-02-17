package ejercicios.uees;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Elija el area a calcular:");
        System.out.println("1. Rectangulo");
        System.out.println("2. Triangulo");
        System.out.println("3. Circulo");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();

        double area;

        switch (opcion) {

            case 1:
                System.out.print("Ingrese base: ");
                double baseR = sc.nextDouble();
                System.out.print("Ingrese altura: ");
                double alturaR = sc.nextDouble();
                area = baseR * alturaR;
                System.out.println("Area del rectangulo: " + area);
                break;

            case 2:
                System.out.print("Ingrese base: ");
                double baseT = sc.nextDouble();
                System.out.print("Ingrese altura: ");
                double alturaT = sc.nextDouble();
                area = (baseT * alturaT) / 2;
                System.out.println("Area del triangulo: " + area);
                break;

            case 3:
                System.out.print("Ingrese radio: ");
                double radio = sc.nextDouble();
                area = Math.PI * Math.pow(radio, 2);
                System.out.println("Area del circulo: " + area);
                break;

            default:
                System.out.println("Opción no valida.");
        }

        sc.close();
    }
}
