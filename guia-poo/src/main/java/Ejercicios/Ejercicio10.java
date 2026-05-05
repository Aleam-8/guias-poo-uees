package Ejercicios;

import java.util.Scanner;

abstract class Unidad {
    protected int totalUnidades;
    protected String[] prioridadesActivas;

    public Unidad(int totalUnidades) {
        this.totalUnidades = totalUnidades;
        prioridadesActivas = new String[totalUnidades];

        for (int i = 0; i < totalUnidades; i++) {
            prioridadesActivas[i] = "Libre";
        }
    }

    public abstract void atenderEmergencia(String prioridad);

    public int valorPrioridad(String prioridad) {
        switch (prioridad) {
            case "Alta":
                return 3;
            case "Media":
                return 2;
            case "Baja":
                return 1;
            default:
                return 0;
        }
    }

    public int buscarUnidadLibre() {
        for (int i = 0; i < prioridadesActivas.length; i++) {
            if (prioridadesActivas[i].equals("Libre")) {
                return i;
            }
        }
        return -1;
    }

    public int buscarMenorPrioridad() {
        int menor = 999;
        int posicion = -1;

        for (int i = 0; i < prioridadesActivas.length; i++) {
            int valor = valorPrioridad(prioridadesActivas[i]);

            if (valor < menor) {
                menor = valor;
                posicion = i;
            }
        }

        return posicion;
    }

    public void mostrarEstado() {
        System.out.println("\nEstado de unidades:");

        for (int i = 0; i < prioridadesActivas.length; i++) {
            System.out.println("Unidad " + (i+1) + ": " + prioridadesActivas[i]);
        }
    }

    public void manejarEmergencia(String prioridad, String nombreUnidad, String tiempo) {

        int libre = buscarUnidadLibre();

        if (libre != -1) {
            prioridadesActivas[libre] = prioridad;

            System.out.println(nombreUnidad + " enviada.");
            System.out.println("Tiempo estimado: " + tiempo);
        }
        else {
            int reemplazo = buscarMenorPrioridad();

            if (valorPrioridad(prioridad) > valorPrioridad(prioridadesActivas[reemplazo])) {

                System.out.println("No hay unidades libres.");
                System.out.println("Se cancela emergencia de prioridad "
                        + prioridadesActivas[reemplazo]
                        + " para atender emergencia de prioridad "
                        + prioridad);

                prioridadesActivas[reemplazo] = prioridad;

                System.out.println(nombreUnidad + " reasignada.");
                System.out.println("Tiempo estimado: " + tiempo);

            } else {
                System.out.println("No hay unidades disponibles para esta emergencia.");
            }
        }

        mostrarEstado();
    }
}

// Ambulancia
class Ambulancia extends Unidad {

    public Ambulancia(int totalUnidades) {
        super(totalUnidades);
    }

    @Override
    public void atenderEmergencia(String prioridad) {

        String tiempo;

        if (prioridad.equals("Alta"))
            tiempo = "5 minutos";
        else if (prioridad.equals("Media"))
            tiempo = "10 minutos";
        else
            tiempo = "20 minutos";

        manejarEmergencia(prioridad, "Ambulancia", tiempo);
    }
}

// Bomberos
class Bomberos extends Unidad {

    public Bomberos(int totalUnidades) {
        super(totalUnidades);
    }

    @Override
    public void atenderEmergencia(String prioridad) {

        String tiempo;

        if (prioridad.equals("Alta"))
            tiempo = "7 minutos";
        else if (prioridad.equals("Media"))
            tiempo = "15 minutos";
        else
            tiempo = "25 minutos";

        manejarEmergencia(prioridad, "Bomberos", tiempo);
    }
}

// Policía
class Policia extends Unidad {

    public Policia(int totalUnidades) {
        super(totalUnidades);
    }

    @Override
    public void atenderEmergencia(String prioridad) {

        String tiempo;

        if (prioridad.equals("Alta"))
            tiempo = "4 minutos";
        else if (prioridad.equals("Media"))
            tiempo = "8 minutos";
        else
            tiempo = "15 minutos";

        manejarEmergencia(prioridad, "Policía", tiempo);
    }
}

public class Ejercicio10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Ambulancia ambulancia = new Ambulancia(2);
        Bomberos bomberos = new Bomberos(1);
        Policia policia = new Policia(3);

        int continuar;

        do {
            Unidad unidad = null;

            int tipo;

            do {
                System.out.println("\nTipo de emergencia:");
                System.out.println("1. Médica");
                System.out.println("2. Incendio");
                System.out.println("3. Seguridad");
                System.out.print("Opción: ");

                tipo = sc.nextInt();

                switch(tipo) {
                    case 1:
                        unidad = ambulancia;
                        break;
                    case 2:
                        unidad = bomberos;
                        break;
                    case 3:
                        unidad = policia;
                        break;
                    default:
                        System.out.println("Opción inválida");
                }

            } while(tipo < 1 || tipo > 3);

            int opcionPrioridad;
            String prioridad = "";

            do {
                System.out.println("\nPrioridad:");
                System.out.println("1. Alta");
                System.out.println("2. Media");
                System.out.println("3. Baja");
                System.out.print("Opción: ");

                opcionPrioridad = sc.nextInt();

                switch(opcionPrioridad) {
                    case 1:
                        prioridad = "Alta";
                        break;
                    case 2:
                        prioridad = "Media";
                        break;
                    case 3:
                        prioridad = "Baja";
                        break;
                    default:
                        System.out.println("Opción inválida");
                }

            } while(opcionPrioridad < 1 || opcionPrioridad > 3);

            unidad.atenderEmergencia(prioridad);

            System.out.println("\n¿Registrar otra emergencia?");
            System.out.println("1. Sí");
            System.out.println("2. No");

            continuar = sc.nextInt();

        } while(continuar == 1);

        sc.close();
    }
}