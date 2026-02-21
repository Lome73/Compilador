package Minicompilador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Guardar{//se crea el constructor con los atrivutos del string mas el objto que es guardar
    String nomArchivo,textoNuevo;
    
    public Guardar(String nomArchivo,String textoNuevo) {
    this.nomArchivo = nomArchivo;
    this.textoNuevo = textoNuevo;
    // Escribe los resultados en un archivo texto
    escribeArchivo(textoNuevo);
}
//aqui se hace la funcion de buscar la ruta y reescribir pero mientras se hace un archivo temporsal para que sea mas rapido
    public void escribeArchivo(String textoNuevo) {
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    // Abre el archivo donde se escribiran los resultados
    try {
        fileWriter = new FileWriter(nomArchivo);
    } catch (IOException ioe) {
        System.out.println("Error, no se pueden guardar los cambios");
        return;
    }
    // Se envuelve el archivo donde se escribiran los resultados con un
    // archivo del tipo BufferedWriter para eficientar su acceso
    bufferedWriter = new BufferedWriter(
    (OutputStreamWriter) (fileWriter));
    try {
        bufferedWriter.write(textoNuevo);
        bufferedWriter.close();
        fileWriter.close();
    } catch (IOException ioe) {
        System.out.println("Error, no se pueden guardar los cambios");
    }
}
}