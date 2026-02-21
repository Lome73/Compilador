/* Este es un ejemplo de comentario
de varias lineas */
package arbolito; //prueba automatas 1
import java.io.BufferedReader;
import java.io.File;
public class Arbolito {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char pino=1;
        String input;
        String palabra = "hola";
        int a = 0, 9b = 10;
        boolean 9bandera=true;
        double doble=3.9;
        int[] 2f = {1, 2, 3};
        for(int i=0;i<=7;i++{
            for(int j=0;j<=8;j++){
            }//del for interno
        }//del for externo
        //Para empezar a hacer el despliegue
        while (i > 0) {
            System.out.println("i is: " + i;
            i--;
        }
        while (!(input = scanner.nextLine()).equals("exit")) {
            System.out.println("You entered: " + input);
        }
        do {
        System.out.println("a: " + a + ", b: " + b);
        a++;
        b--;
        } while (a < 5 && b > 5);
        do {
            System.out.println("Enter text (type exit to quit): ");
            input = scanner.nextLine();
            System.out.println("You entered: " + input);
        } while (!input.equals("exit"));
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e {
            System.out.println("ArithmeticException: Division by zero.");
        }
    } 
}