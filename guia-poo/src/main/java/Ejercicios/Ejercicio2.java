package Ejercicios;

import java.util.Scanner;

abstract class Cuenta {
    protected double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public abstract void retirar(double monto);

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito realizado correctamente.");
        } else {
            System.out.println("Monto inválido.");
        }
    }

    public void mostrarSaldo() {
        System.out.println("Saldo actual: $" + saldo);
    }
}

class CuentaAhorro extends Cuenta {

    public CuentaAhorro(double saldo) {
        super(saldo);
    }

    @Override
    public void retirar(double monto) {
        if (monto <= saldo && monto > 0) {
            saldo -= monto;
            System.out.println("Retiro realizado correctamente.");
        } else {
            System.out.println("Error: fondos insuficientes o monto inválido.");
        }
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        CuentaAhorro cuenta = new CuentaAhorro(saldoInicial);

        int opcion;

        while (true) {
            System.out.println("\n--- MENU BANCARIO ---");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese monto a depositar: ");
                double monto = sc.nextDouble();
                cuenta.depositar(monto);

            } else if (opcion == 2) {
                System.out.print("Ingrese monto a retirar: ");
                double monto = sc.nextDouble();
                cuenta.retirar(monto);

            } else if (opcion == 3) {
                System.out.println("Saliendo del sistema...");
                break;

            } else {
                System.out.println("Error: operación inválida. Intente nuevamente.");
            }

            cuenta.mostrarSaldo();
        }

        sc.close();
    }
}