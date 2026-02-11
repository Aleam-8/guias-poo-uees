package sv.uees;

import java.util.Scanner;

public class JavaRepetitiveFlow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos números quiere ingresar? ");
        int cantidad = sc.nextInt();

        int suma = 0;
        int i = 0;

        while (i < cantidad){
            System.out.print("Ingrese número: " + (i + 1) + ": ");
            int num = sc.nextInt();

            suma += num; //operador de asignación compuesto
            i++;
        }

        System.out.println("\nTotal de la suma: " + suma);

        //Uso de for para contar regresivamente
        System.out.println("Contando hacia atrás desde " + cantidad);
        for (int j = cantidad; j >= 1; j--) {
            System.out.println(j);
        }

        sc.close();
    }
}
