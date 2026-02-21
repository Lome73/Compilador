/* Este es un ejemplo de comentario
de varias lineas */
package arbolito; //prueba automatas 1
public class Arbolito {
    public static void main(String[] args) {
        char pino[][]= new char [8][9];
        for(int i=0;i<=7;i++){
            for(int j=0;j<=8;j++){
                if(i==0 && j==4)//Para el pico
                    pino[i][j]='@';
                if((j==3 || j==4 || j==5) && (i!=0))//Para el cuerpo
                   pino[i][j]='@';
                if(i==2 && (j==2 || j== 6))
                    pino[i][j]='@';
                 if(i==3 && (j>=1 && j<= 7))
                    pino[i][j]='@';               
                 if(i==4)
                    pino[i][j]='@'; 
            }//del for interno
        }//del for externo
        //Para empezar a hacer el despliegue
        for(int i=0;i<=7;i++){
            for(int j=0;j<=8;j++){
                System.out.print(pino[i][j]);
            }//del for interno
            System.out.print("\n");
        }//del for externo
    }
}
