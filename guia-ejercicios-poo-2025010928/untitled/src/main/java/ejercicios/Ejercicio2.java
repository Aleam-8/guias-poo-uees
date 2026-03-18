package ejercicios;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del titular: ");
        String titular = sc.nextLine();

        System.out.print("Ingrese el saldo inicial: ");
        double saldo = sc.nextDouble();

        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Mostrar saldo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto a depositar: ");
                    double deposito = sc.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito exitoso.");
                    } else {
                        System.out.println("Monto inválido.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el monto a retirar: ");
                    double retiro = sc.nextDouble();
                    if (retiro <= saldo) {
                        saldo -= retiro;
                        System.out.println("Retiro exitoso.");
                    } else {
                        System.out.println("Fondos insuficientes");
                    }
                    break;

                case 3:
                    System.out.println("Titular: " + titular);
                    System.out.println("Saldo actual: $" + saldo);
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