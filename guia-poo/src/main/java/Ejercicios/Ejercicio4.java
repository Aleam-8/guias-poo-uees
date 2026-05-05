package Ejercicios;

import java.util.Scanner;

abstract class Personaje {
    protected String nombre;
    protected int vida;

    public Personaje(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    public abstract void ataque();
    public abstract void habilidadEspecial();
    public abstract void desventaja();
}

// Guerrero
class Guerrero extends Personaje {

    public Guerrero(String nombre) {
        super(nombre, 120);
    }

    @Override
    public void ataque() {
        System.out.println("Ataque: " + nombre + " ataca con su espada.");
    }

    @Override
    public void habilidadEspecial() {
        System.out.println("Habilidad Especial: " + nombre + " usa Golpe Brutal y causa daño extra.");
    }

    @Override
    public void desventaja() {
        System.out.println("Desventaja: " + nombre + " solo puede atacar a corta distancia.");
    }
}

// Mago
class Mago extends Personaje {

    public Mago(String nombre) {
        super(nombre, 80);
    }

    @Override
    public void ataque() {
        System.out.println("Ataque: " + nombre + " lanza una bola de fuego.");
    }

    @Override
    public void habilidadEspecial() {
        System.out.println("Habilidad Especial: " + nombre + " usa Tormenta Arcana y afecta a múltiples enemigos.");
    }

    @Override
    public void desventaja() {
        System.out.println("Desventaja: " + nombre + " debe recargar su energia.");
    }
}

// Arquero
class Arquero extends Personaje {

    public Arquero(String nombre) {
        super(nombre, 90);
    }

    @Override
    public void ataque() {
        System.out.println("Ataque: " + nombre + " dispara una flecha.");
    }

    @Override
    public void habilidadEspecial() {
        System.out.println("Habilidad Especial: " + nombre + " usa Flecha Explosiva y hace daño en area.");
    }

    @Override
    public void desventaja() {
        System.out.println("Desventaja: " + nombre + " tiene un número limitado de flechas.");
    }
}

public class Ejercicio4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del personaje: ");
        String nombre = sc.nextLine();

        int opcion;
        Personaje personaje = null;

        do {
            System.out.println("\nSeleccione tipo de personaje:");
            System.out.println("1. Guerrero");
            System.out.println("2. Mago");
            System.out.println("3. Arquero");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch(opcion) {
                case 1:
                    personaje = new Guerrero(nombre);
                    break;
                case 2:
                    personaje = new Mago(nombre);
                    break;
                case 3:
                    personaje = new Arquero(nombre);
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while(opcion < 1 || opcion > 3);

        System.out.println("\nPersonaje creado:");
        System.out.println("Nombre: " + personaje.nombre);
        System.out.println("Vida: " + personaje.vida);

        personaje.ataque();
        personaje.habilidadEspecial();
        personaje.desventaja();

        sc.close();
    }
}