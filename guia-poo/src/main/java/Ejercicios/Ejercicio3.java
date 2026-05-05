package Ejercicios;

import java.util.Scanner;

abstract class Transporte {
    public abstract double calcularTarifa(double valor);
}

// Bus: tarifa fija
class Bus extends Transporte {
    public double calcularTarifa(double valor) {
        return 0.35;
    }
}

// Taxi: según distancia
class Taxi extends Transporte {
    public double calcularTarifa(double distancia) {
        return distancia * 0.75;
    }
}

// Bicicleta: primeros 30 minutos gratis
class Bicicleta extends Transporte {
    public double calcularTarifa(double minutos) {
        if (minutos <= 30) {
            return 0;
        } else {
            return (minutos - 30) * 0.10;
        }
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;
        double tarifa = 0;
        Transporte transporte = null;

        do {
            System.out.println("\nSeleccione transporte:");
            System.out.println("1. Bus");
            System.out.println("2. Taxi");
            System.out.println("3. Bicicleta");
            System.out.print("Ingrese una opción: ");

            opcion = sc.nextInt();

            switch(opcion) {
                case 1:
                    transporte = new Bus();
                    tarifa = transporte.calcularTarifa(0);
                    break;

                case 2:
                    System.out.print("Ingrese distancia recorrida: ");
                    double distancia = sc.nextDouble();

                    transporte = new Taxi();
                    tarifa = transporte.calcularTarifa(distancia);
                    break;

                case 3:
                    System.out.print("Ingrese minutos de uso: ");
                    double minutos = sc.nextDouble();

                    transporte = new Bicicleta();
                    tarifa = transporte.calcularTarifa(minutos);
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while(opcion < 1 || opcion > 3);

        System.out.println("Tarifa total: $" + tarifa);

        sc.close();
    }
}