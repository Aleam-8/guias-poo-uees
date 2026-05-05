package ejercicios;

import java.util.Scanner;

class Producto {
    String nombre;
    double precio;
    int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void aplicarDescuento(double porcentaje) {
        precio = precio - (precio * porcentaje / 100);
    }

    public void mostrarInfo() {
        System.out.println("\nInformación del producto:");
        System.out.println("Producto: " + nombre);
        System.out.println("Precio final: $" + precio);
        System.out.println("Stock: " + stock);
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        double precio;

        // Validar precio negativo
        do {
            System.out.print("Ingrese el precio: ");
            precio = sc.nextDouble();

            if (precio < 0) {
                System.out.println("Error: No se permiten precios negativos. Intente nuevamente.");
            }

        } while (precio < 0);

        int stock;

        // Validar stock negativo
        do {
            System.out.print("Ingrese el stock: ");
            stock = sc.nextInt();

            if (stock < 0) {
                System.out.println("Error: No se permiten stocks negativos. Intente nuevamente.");
            }

        } while (stock < 0);

        System.out.print("Ingrese descuento (%): ");
        double descuento = sc.nextDouble();

        Producto p = new Producto(nombre, precio, stock);

        p.aplicarDescuento(descuento);
        p.mostrarInfo();

        sc.close();
    }
}