package Ejercicios;

import java.util.Scanner;

abstract class Estudiante {
    protected String nombre;
    protected double notaFinal;

    public Estudiante(String nombre, double notaFinal) {
        this.nombre = nombre;
        this.notaFinal = notaFinal;
    }

    public abstract boolean puedeGraduarse();
    public abstract void mostrarTipo();

    public void mostrarReporte() {
        System.out.println("\nReporte Académico:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Nota final: " + notaFinal);

        if (puedeGraduarse()) {
            System.out.println("Estado: Puede graduarse");
        } else {
            System.out.println("Estado: No puede graduarse");
        }
    }
}

// Pregrado
class Pregrado extends Estudiante {

    public Pregrado(String nombre, double notaFinal) {
        super(nombre, notaFinal);
    }

    @Override
    public boolean puedeGraduarse() {
        return notaFinal >= 6.0;
    }

    @Override
    public void mostrarTipo() {
        System.out.println("Tipo: Estudiante de Pregrado");
    }
}

// Posgrado
class Posgrado extends Estudiante {

    public Posgrado(String nombre, double notaFinal) {
        super(nombre, notaFinal);
    }

    @Override
    public boolean puedeGraduarse() {
        return notaFinal >= 8.0;
    }

    @Override
    public void mostrarTipo() {
        System.out.println("Tipo: Estudiante de Posgrado");
    }
}

public class Ejercicio7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese nombre del estudiante: ");
        String nombre = sc.nextLine();

        double nota;

        do {
            System.out.print("Ingrese nota final (0.0 - 10.0): ");
            nota = sc.nextDouble();

            if (nota < 0 || nota > 10) {
                System.out.println("Nota inválida. Debe estar entre 0.0 y 10.0");
            }

        } while (nota < 0 || nota > 10);

        int opcion;
        Estudiante estudiante = null;

        do {
            System.out.println("\nSeleccione tipo de estudiante:");
            System.out.println("1. Pregrado");
            System.out.println("2. Posgrado");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch(opcion) {
                case 1:
                    estudiante = new Pregrado(nombre, nota);
                    break;

                case 2:
                    estudiante = new Posgrado(nombre, nota);
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while(opcion < 1 || opcion > 2);

        estudiante.mostrarTipo();
        estudiante.mostrarReporte();

        sc.close();
    }
}