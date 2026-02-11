package sv.uees;

import java.util.Scanner;

public class JavaBasicConditional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");
        int numero = sc.nextInt();

        // Operador y expresión
        boolean esPar = (numero % 2 == 0);

        // Control de flujo - condicional
        if (esPar) {
            System.out.println("El número " + numero + " es par.");
        } else {
            System.out.println("El número " + numero + " es impar.");
        }


        sc.close();
    }
}
