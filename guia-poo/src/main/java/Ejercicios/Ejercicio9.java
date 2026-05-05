package Ejercicios;

import java.util.Scanner;

// Clase abstracta contenido
abstract class Contenido {
    protected String titulo;

    public Contenido(String titulo) {
        this.titulo = titulo;
    }

    public abstract boolean esPremium();
}

// Película
class Pelicula extends Contenido {
    public Pelicula(String titulo) {
        super(titulo);
    }

    @Override
    public boolean esPremium() {
        return false;
    }
}

// Serie
class Serie extends Contenido {
    public Serie(String titulo) {
        super(titulo);
    }

    @Override
    public boolean esPremium() {
        return false;
    }
}

// Evento premium
class EventoPremium extends Contenido {
    public EventoPremium(String titulo) {
        super(titulo);
    }

    @Override
    public boolean esPremium() {
        return true;
    }
}

// Clase abstracta usuario
abstract class Usuario {
    protected String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public abstract void reproducirContenido(Contenido contenido);
}

// Usuario gratis
class UsuarioGratis extends Usuario {

    public UsuarioGratis(String nombre) {
        super(nombre);
    }

    @Override
    public void reproducirContenido(Contenido contenido) {

        if (contenido.esPremium()) {
            System.out.println("Acceso denegado: contenido exclusivo para usuarios premium.");
            return;
        }

        System.out.println(nombre + " está reproduciendo: " + contenido.titulo);

        if (contenido instanceof Pelicula) {
            System.out.println("...Reproduciendo película...");
            System.out.println("PAUSA PUBLICITARIA #1 (20 segundos)");
            System.out.println("PAUSA PUBLICITARIA #2 (15 segundos)");
            System.out.println("PAUSA PUBLICITARIA #3 (10 segundos)");
            System.out.println("PAUSA PUBLICITARIA #4 (15 segundos)");
        }

        else if (contenido instanceof Serie) {
            System.out.println("...Reproduciendo serie...");
            System.out.println("PAUSA PUBLICITARIA #1 (15 segundos)");
            System.out.println("PAUSA PUBLICITARIA #2 (20 segundos)");
        }

        System.out.println("Contenido finalizado.");
    }
}

// Usuario premium
class UsuarioPremium extends Usuario {

    public UsuarioPremium(String nombre) {
        super(nombre);
    }

    @Override
    public void reproducirContenido(Contenido contenido) {
        System.out.println(nombre + " está reproduciendo: " + contenido.titulo);
        System.out.println("Reproducción sin anuncios.");
        System.out.println("Contenido finalizado.");
    }
}

public class Ejercicio9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese nombre del usuario: ");
        String nombre = sc.nextLine();

        Usuario usuario = null;
        int tipoUsuario;

        do {
            System.out.println("\nSeleccione tipo de usuario:");
            System.out.println("1. Gratis");
            System.out.println("2. Premium");
            System.out.print("Opción: ");

            tipoUsuario = sc.nextInt();

            switch(tipoUsuario) {
                case 1:
                    usuario = new UsuarioGratis(nombre);
                    break;
                case 2:
                    usuario = new UsuarioPremium(nombre);
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while(tipoUsuario < 1 || tipoUsuario > 2);

        sc.nextLine();

        Contenido contenido = null;
        int tipoContenido;

        do {
            System.out.println("\nSeleccione contenido:");
            System.out.println("1. Película");
            System.out.println("2. Serie");
            System.out.println("3. Evento Premium");
            System.out.print("Opción: ");

            tipoContenido = sc.nextInt();
            sc.nextLine();

            System.out.print("Ingrese título: ");
            String titulo = sc.nextLine();

            switch(tipoContenido) {
                case 1:
                    contenido = new Pelicula(titulo);
                    break;
                case 2:
                    contenido = new Serie(titulo);
                    break;
                case 3:
                    contenido = new EventoPremium(titulo);
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while(tipoContenido < 1 || tipoContenido > 3);

        usuario.reproducirContenido(contenido);

        sc.close();
    }
}