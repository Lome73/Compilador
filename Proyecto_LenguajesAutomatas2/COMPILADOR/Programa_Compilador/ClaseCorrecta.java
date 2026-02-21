package Prueba;

import java.util.Scanner;

public class ClaseCorrecta {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- CALCULADORA DINAMICA ---");
        
        System.out.print("1. Introduce el primer numero (A): ");
        int a = scanner.nextInt(); 

        System.out.print("2. Introduce el segundo numero (B): ");
        int b = scanner.nextInt();

        
        int suma = a + b;
        int producto = a * b;

        System.out.println(" RESULTADOS");
        System.out.println("SUMA: " + suma);

     
    }
}
