package Minicompilador;

//Este es un comentario de linea
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
Esta clase lee un archivo de código Java, le quita los comentarios y
escribe el resultado en otro archivo.
*/
public class QuitarComentarios1 {
String nomArchivoEntrada;
String nomArchivoSalida;
/**
* Este constructor inicializa los atributos de la clase e invoca a los
* metodos que abren el archivo fuente, borran los comentarios y
* escriben el resultado en otro archivo.
*
* para nomArchivoEntrada Nombre del archivo con el codigo fuente
* en java
* param nomArchivoSalida Nombre del archivo con los resultados
*/
public QuitarComentarios1(String nomArchivoEntrada, String nomArchivoSalida) {
    String fuenteCC, fuenteSC,fuenteNSC;
    this.nomArchivoEntrada = nomArchivoEntrada;
    this.nomArchivoSalida = nomArchivoSalida;
    // Lee el archivo con el codigo fuente
    fuenteCC = leeArchivo();
    // Borra los comentarios
    fuenteSC = borraComentarios(fuenteCC);
    // Escribe los resultados en un archivo texto
    escribeArchivo(fuenteSC);
}
/**
* Este metodo abre el archivo con el codigo fuente, lo lee linea por
* linea, las guarda en una cadena de tipo String.
* @return Una cadena con el contenido del archivo de entrada
*/
public String leeArchivo() {
    FileReader fileReader;
    BufferedReader bufferedReader;
    String linea;
    StringBuffer fuente = new StringBuffer();
    // Abre el archivo con el codigo fuente
    try {
        fileReader = new FileReader(nomArchivoEntrada);
    } catch (FileNotFoundException fnfe) {
        System.out.println("Error: No existe el archivo "
        + nomArchivoEntrada);
        return null;
    }
    // Se envuelve el archivo con el codigo fuente con un archivo
    // del tipo BufferedReader para eficientar su acceso
    bufferedReader = new BufferedReader(fileReader);
    try {
        while (true) {
        // Obten la siguiente linea del archivo con el codigo fuente
        linea = bufferedReader.readLine();
        // Si ya no hay lineas, termina el ciclo
        if (linea == null) {
        break;
        }
        // Agrega la línea al Stringbuffer
        fuente.append(linea);
        // Agrega un salto de línea al Stringbuffer
        fuente.append("\n");
        }
        bufferedReader.close();
        fileReader.close();
        return fuente.toString();
    } catch (IOException ioe) {
        System.out.println("Error al procesar el archivo"
        + nomArchivoEntrada);
        return null;
    }
}
/**
* Este metodo escribe en un archivo texto, el contenido del archivo
* fuente de Java de entrada sin los comentarios
* para fuenteSC Archivo fuente de Java de entrada sin los
* comentarios
*/
public void escribeArchivo(String fuenteSC) {
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    // Abre el archivo donde se escribiran los resultados
    try {
        fileWriter = new FileWriter(nomArchivoSalida);
    } catch (IOException ioe) {
        System.out.println("Error, no se pudo crear el archivo"
        + nomArchivoSalida);
        return;
    }
    // Se envuelve el archivo donde se escribiran los resultados con un
    // archivo del tipo BufferedWriter para eficientar su acceso
    bufferedWriter = new BufferedWriter(
    (OutputStreamWriter) (fileWriter));
    try {
        bufferedWriter.write(fuenteSC);
        bufferedWriter.close();
        fileWriter.close();
    } catch (IOException ioe) {
        System.out.println("Error al escribir al archivo"
        + nomArchivoSalida);
    }
}
/**
* Este metodo borra los comentarios de línea, multilínea y de
* documentación de archivos con código Java.
* Falla si una cadena literal contiene dos diagonales seguidas
*/
public String borraComentarios(String fuenteCC) {
    // Crea una expresión regular que elimine los comentarios
    String exReg = "(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*$)";
    // Compila la expression regular en un patron
    Pattern p = Pattern.compile(exReg, Pattern.MULTILINE);
    // Crea un ajustador para el texto del archivo
    Matcher m = p.matcher(fuenteCC);
    // Reemplaza los comentarios por una cadena vacia
    return m.replaceAll("");
}
} 

