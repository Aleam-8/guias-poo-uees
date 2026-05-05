package Ejercicios;

import java.util.Scanner;

abstract class Sensor {
    protected String nombre;

    public Sensor(String nombre) {
        this.nombre = nombre;
    }

    public abstract void detectar();
}

// Sensor de temperatura
class SensorTemperatura extends Sensor {
    private final double temperatura;

    public SensorTemperatura(double temperatura) {
        super("Sensor de Temperatura");
        this.temperatura = temperatura;
    }

    @Override
    public void detectar() {
        System.out.println("\n" + nombre);

        if (temperatura > 35) {
            System.out.println("ALERTA: Temperatura muy alta.");
        }
        if (temperatura <= 15) {
            System.out.print("Temperatura baja.");
        }
        else {
            System.out.println("Temperatura normal.");
        }
    }
}

// Sensor de movimiento
class SensorMovimiento extends Sensor {
    private final boolean movimiento;

    public SensorMovimiento(boolean movimiento) {
        super("Sensor de Movimiento");
        this.movimiento = movimiento;
    }

    @Override
    public void detectar() {
        System.out.println("\n" + nombre);

        if (movimiento) {
            System.out.println("ALERTA: Movimiento detectado.");
        }
        else {
            System.out.println("Sin movimiento.");
        }
    }
}

// Sensor de humo
class SensorHumo extends Sensor {
    private final int nivelHumo;

    public SensorHumo(int nivelHumo) {
        super("Sensor de Humo");
        this.nivelHumo = nivelHumo;
    }

    @Override
    public void detectar() {
        System.out.println("\n" + nombre);

        if (nivelHumo > 50) {
            System.out.println("ALERTA: Posible incendio.");
        }
        else {
            System.out.println("Nivel de humo normal.");
        }
    }
}

public class Ejercicio6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Sensor sensor = null;
        int opcion;

        do {
            System.out.println("\nSeleccione tipo de sensor:");
            System.out.println("1. Temperatura");
            System.out.println("2. Movimiento");
            System.out.println("3. Humo");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch(opcion) {
                case 1:
                    System.out.print("Ingrese temperatura actual: ");
                    double temp = sc.nextDouble();
                    sensor = new SensorTemperatura(temp);
                    break;

                case 2:
                    System.out.print("¿Hay movimiento? (1=Sí / 0=No): ");
                    int mov = sc.nextInt();
                    sensor = new SensorMovimiento(mov == 1);
                    break;

                case 3:
                    System.out.print("Ingrese nivel de humo: ");
                    int humo = sc.nextInt();
                    sensor = new SensorHumo(humo);
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while(opcion < 1 || opcion > 3);

        sensor.detectar();

        sc.close();
    }
}