package Ejercicios;

import java.util.Scanner;

abstract class Drone {
    protected double capacidadMaxima;
    protected double bateria;
    protected double rendimientoBase; // km por cada 1% de batería

    public Drone(double capacidadMaxima, double bateria, double rendimientoBase) {
        this.capacidadMaxima = capacidadMaxima;
        this.bateria = bateria;
        this.rendimientoBase = rendimientoBase;
    }

    public abstract void realizarEntrega(double pesoPaquete, double distancia);
}

// Drone ligero
class DroneLigero extends Drone {

    public DroneLigero(double bateria) {
        super(5, bateria, 2.0);
        // Puede recorrer 2 km por cada 1% de batería
    }

    @Override
    public void realizarEntrega(double pesoPaquete, double distancia) {

        if (pesoPaquete > capacidadMaxima) {
            System.out.println("Error: el paquete excede la capacidad del Drone Ligero.");
            return;
        }

        double factorPeso = pesoPaquete * 0.1;
        double distanciaMaxima = bateria * (rendimientoBase - factorPeso);

        if (distanciaMaxima < distancia) {
            System.out.println("Error: batería insuficiente.");
            System.out.println("Puede recorrer máximo: " + distanciaMaxima + " km");
        } else {
            System.out.println("Entrega realizada con Drone Ligero.");
        }
    }
}

// Drone pesado
class DronePesado extends Drone {

    public DronePesado(double bateria) {
        super(20, bateria, 1.5);
        // Al ser más pesado solo recorre 1.5 km por 1% de batería
    }

    @Override
    public void realizarEntrega(double pesoPaquete, double distancia) {

        if (pesoPaquete > capacidadMaxima) {
            System.out.println("Error: el paquete excede la capacidad del Drone Pesado.");
            return;
        }

        double factorPeso = pesoPaquete * 0.05;
        double distanciaMaxima = bateria * (rendimientoBase - factorPeso);

        if (distanciaMaxima < distancia) {
            System.out.println("Error: batería insuficiente.");
            System.out.println("Puede recorrer como máximo: " + distanciaMaxima + " km");
        } else {
            System.out.println("Entrega realizada con Drone Pesado.");
        }
    }
}

public class Ejercicio8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese peso del paquete (kg): ");
        double peso = sc.nextDouble();

        double bateria;

        do {
            System.out.print("Ingrese nivel de batería (0-100): ");
            bateria = sc.nextDouble();

            if (bateria < 0 || bateria > 100) {
                System.out.println("Batería inválida.");
            }

        } while (bateria < 0 || bateria > 100);

        System.out.print("Ingrese distancia de entrega (km): ");
        double distancia = sc.nextDouble();

        Drone drone = null;
        int opcion;

        do {
            System.out.println("\nSeleccione tipo de drone:");
            System.out.println("1. Drone Ligero");
            System.out.println("2. Drone Pesado");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch(opcion) {
                case 1:
                    drone = new DroneLigero(bateria);
                    break;

                case 2:
                    drone = new DronePesado(bateria);
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while(opcion < 1 || opcion > 2);

        drone.realizarEntrega(peso, distancia);

        sc.close();
    }
}