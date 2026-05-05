package Ejercicios;

import java.util.Scanner;

abstract class Habitacion {
    protected double precioPorNoche;

    public Habitacion(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public abstract double calcularCosto(int noches);
    public abstract void mostrarBeneficios();
}

// Habitación simple
class HabitacionSimple extends Habitacion {

    public HabitacionSimple() {
        super(50);
    }

    @Override
    public double calcularCosto(int noches) {
        return noches * precioPorNoche;
    }

    @Override
    public void mostrarBeneficios() {
        System.out.println("Habitación estándar sin servicios adicionales.");
    }
}

// Habitación premium (servicio adicional)
class HabitacionPremium extends Habitacion {

    public HabitacionPremium() {
        super(100);
    }

    @Override
    public double calcularCosto(int noches) {
        return noches * precioPorNoche;
    }

    @Override
    public void mostrarBeneficios() {
        System.out.println("Incluye desayuno y acceso a la piscina.");
    }
}

// Suite (cargo extra)
class Suite extends Habitacion {

    public Suite() {
        super(150);
    }

    @Override
    public double calcularCosto(int noches) {
        double cargoExtra = 50;
        return (noches * precioPorNoche) + cargoExtra;
    }

    @Override
    public void mostrarBeneficios() {
        System.out.println("Incluye un jacuzzi privado.");
    }
}

public class Ejercicio5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;
        Habitacion habitacion = null;

        do {
            System.out.println("\nSeleccione tipo de habitación:");
            System.out.println("1. Habitación Simple");
            System.out.println("2. Habitación Premium");
            System.out.println("3. Suite");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch(opcion) {
                case 1:
                    habitacion = new HabitacionSimple();
                    break;
                case 2:
                    habitacion = new HabitacionPremium();
                    break;
                case 3:
                    habitacion = new Suite();
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while(opcion < 1 || opcion > 3);

        System.out.print("Ingrese cantidad de noches: ");
        int noches = sc.nextInt();

        double total = habitacion.calcularCosto(noches);

        System.out.println("\nResumen de reserva:");
        habitacion.mostrarBeneficios();
        System.out.println("Costo total: $" + total);

        sc.close();
    }
}