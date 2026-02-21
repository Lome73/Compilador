/* Este es un ejemplo de comentario
de varias lineas */
package arbolito; //prueba automatas 1
import java.io.BufferedReader;
import java.io.File;
public class Arbolito {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char pino, arbol=1;
        String input;
        String palabra = "hola ITI", palabra2="Tecnm";
        int a= 0, b= 10, c, d;
        int a;
        int num, nom=3;
        boolean bandera=true;
        double doble=3.9, pi=3.1416;
        float m= 12.2, r;
        for(int i=0;i<=7;i++){
            for(int j=0;j<=8;j++){
            }//del for interno
        }//del for externo
        //Para empezar a hacer el despliegue
        while (i > 0) {
            System.out.println("i is: " + i);
            i--;
        }
        while (input.equals(palabra2)) {
            System.out.println("You entered: " + input);
        }
        do {
        System.out.println("a: " + a + ", b: " + b);
        c = b;
        b = nom - c;
        a = a + 2;
        num = a + c;
        d = a * b;
        nom = 3 + a - b * c / 4;
        input = palabra;
        palabra = "Palabra";
        pino = "a";
        r = m + a;
        m = nom / num;
        i = c * 3;
        j = i / 2 + a;
        } while (a < 5 && b > 5);
        do {
            System.out.println("Enter text (type exit to quit): ");
            System.out.println("You entered: " + input);
        } while (!input.equals("exit"));
        try {
            int result= 15;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Division by zero.");
        }
    } 
 }
