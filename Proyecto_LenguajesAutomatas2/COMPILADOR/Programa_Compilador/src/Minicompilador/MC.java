package Minicompilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
//tabla simbolos
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import javax.swing.table.DefaultTableModel; 

public class MC extends javax.swing.JFrame {
    String fechaarchivo,fechalexer;
    public int dobleDo;
    public int dobleTry;
    public int dobleWh;
    public int dobleCatch;
    public int errores;
    public int ID=1;
    String[] vector = new String[5];
    DefaultTableModel model;
    
    private List<Simbolo> tablaSimbolos = new ArrayList<>();
    private int simboloId = 1; // Contador para la columna NO.
    
    // Clase para representar un registro en la Tabla de Símbolos
    public class Simbolo {
        public int id;
        public String nombre; // Será la columna 'ID' en tu tabla
        public int linea;
        public String tipoDato;
        public String valor;
        public String clase;

        public Simbolo(int id, String nombre, int linea, String tipo, String valor, String clase) {
            this.id = id;
            this.nombre = nombre;
            this.linea = linea;
            this.tipoDato = tipo;
            this.valor = valor;
            this.clase = clase;
        }
    }
    public MC() {
   initComponents();
   quitar.setVisible(false);
   AnalizarLex.setVisible(false);
   AnalizarSint.setVisible(false);
   Guardar.setVisible(false);
   limpiar.setVisible(false);
   this.setExtendedState(JFrame.MAXIMIZED_BOTH);
   LimpiarTabla.setVisible(false);
   CrearTabla.setVisible(false);
   CrearClass.setVisible(true);
   model = (DefaultTableModel) Tabla.getModel();
   AnalizarSem.setVisible(false); // Ocultar el botón al arrancar la aplicación
   AnalizarSem.setText("Analisis Semantico");
   AnalizarSem.setVisible(false);
   Ejecutar.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ruta = new javax.swing.JTextField();
        abrir = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CF = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        CC = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        quitar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        AL = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        AnalizarLex = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Output = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        AnalizarSint = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        CrearTabla = new javax.swing.JButton();
        LimpiarTabla = new javax.swing.JButton();
        CrearClass = new javax.swing.JButton();
        Ejecutar = new javax.swing.JButton();
        AnalizarSem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Codigo Fuente:");

        ruta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        abrir.setBackground(new java.awt.Color(51, 51, 0));
        abrir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        abrir.setForeground(new java.awt.Color(255, 255, 255));
        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });

        limpiar.setBackground(new java.awt.Color(51, 204, 0));
        limpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        limpiar.setForeground(new java.awt.Color(255, 255, 255));
        limpiar.setText("Limpiar Todo");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(153, 0, 0));
        salir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Minicompilador");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Ruta:");

        CF.setColumns(20);
        CF.setRows(5);
        jScrollPane1.setViewportView(CF);

        CC.setColumns(20);
        CC.setRows(5);
        jScrollPane2.setViewportView(CC);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Codigo Fuente Sin Comentarios:");

        quitar.setBackground(new java.awt.Color(0, 51, 255));
        quitar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quitar.setForeground(new java.awt.Color(255, 255, 255));
        quitar.setText("Quitar Comentarios");
        quitar.setPreferredSize(new java.awt.Dimension(60, 26));
        quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarActionPerformed(evt);
            }
        });

        AL.setColumns(20);
        AL.setRows(5);
        jScrollPane3.setViewportView(AL);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Tokens:");

        AnalizarLex.setBackground(new java.awt.Color(0, 0, 0));
        AnalizarLex.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AnalizarLex.setForeground(new java.awt.Color(255, 255, 255));
        AnalizarLex.setText("Analisis Lexico");
        AnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarLexActionPerformed(evt);
            }
        });

        Output.setColumns(20);
        Output.setRows(5);
        jScrollPane4.setViewportView(Output);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Output:");

        AnalizarSint.setBackground(new java.awt.Color(0, 0, 0));
        AnalizarSint.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AnalizarSint.setForeground(new java.awt.Color(255, 255, 255));
        AnalizarSint.setText("Analisis Sintactico");
        AnalizarSint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarSintActionPerformed(evt);
            }
        });

        Guardar.setBackground(new java.awt.Color(51, 204, 0));
        Guardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Guardar.setForeground(new java.awt.Color(255, 255, 255));
        Guardar.setText("Guardar Cambios");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO.", "ID", "Linea", "TipoDeDato", "Valor", "Clase"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(Tabla);

        CrearTabla.setBackground(new java.awt.Color(0, 51, 255));
        CrearTabla.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CrearTabla.setForeground(new java.awt.Color(255, 255, 255));
        CrearTabla.setText("Crear Tabla");
        CrearTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearTablaActionPerformed(evt);
            }
        });

        LimpiarTabla.setBackground(new java.awt.Color(51, 204, 0));
        LimpiarTabla.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LimpiarTabla.setForeground(new java.awt.Color(255, 255, 255));
        LimpiarTabla.setText("Limpiar Tabla");
        LimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarTablaActionPerformed(evt);
            }
        });

        CrearClass.setBackground(new java.awt.Color(51, 204, 0));
        CrearClass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CrearClass.setForeground(new java.awt.Color(255, 255, 255));
        CrearClass.setText("Crear Class");
        CrearClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearClassActionPerformed(evt);
            }
        });

        Ejecutar.setBackground(new java.awt.Color(51, 204, 0));
        Ejecutar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Ejecutar.setForeground(new java.awt.Color(255, 255, 255));
        Ejecutar.setText("Ejecutar");
        Ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EjecutarActionPerformed(evt);
            }
        });

        AnalizarSem.setBackground(new java.awt.Color(0, 0, 0));
        AnalizarSem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AnalizarSem.setForeground(new java.awt.Color(255, 255, 255));
        AnalizarSem.setText("Analisis Semantico");
        AnalizarSem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarSemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(612, 612, 612)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quitar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AnalizarLex, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AnalizarSint, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CrearTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LimpiarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CrearClass, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Ejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AnalizarSem, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(salir)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(abrir)))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(abrir)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(quitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(AnalizarLex)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AnalizarSint)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AnalizarSem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Guardar)
                                .addGap(13, 13, 13)
                                .addComponent(CrearTabla)
                                .addGap(13, 13, 13)
                                .addComponent(LimpiarTabla)
                                .addGap(13, 13, 13)
                                .addComponent(CrearClass)
                                .addGap(13, 13, 13)
                                .addComponent(Ejecutar)
                                .addGap(13, 13, 13)
                                .addComponent(limpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(salir))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    //EL COD DE ABAJO ES PARA AGREGAR LOS TIPOS DE ARCHIVOS QUE SE PUEDEN ENCONTRAR CON UN "" SE AGREGAN EJEMPLO "TXT"
    FileNameExtensionFilter Filtro = new FileNameExtensionFilter("Archivos Java", "java", "jar");//solo identificamos esas extenciones, se pueden agregar de todo tipo
    fileChooser.setFileFilter(Filtro);
    LocalDateTime ahora = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    fechaarchivo = ahora.format(formato);
int seleccion = fileChooser.showOpenDialog(null);
if (seleccion == JFileChooser.APPROVE_OPTION)
{
    File fichero = fileChooser.getSelectedFile();
    ruta.setText(fichero.getPath());
    try {
        FileReader fr = new FileReader(ruta.getText());
        BufferedReader br = new BufferedReader(fr);
        String linea;
        CF.setText("");
        while ((linea = br.readLine()) != null) {
        CF.append(linea + "\n");
                                                }
        br.close();
        fr.close();
                    } catch (IOException ex) {
                      ex.printStackTrace();
                    }
    Output.setText("Archivo abierto el "+fechaarchivo+"\n");
    quitar.setVisible(true);
    Guardar.setVisible(true);
    limpiar.setVisible(true);
}
    }//GEN-LAST:event_abrirActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);//boton para salir del programa
    }//GEN-LAST:event_salirActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
//metodo de limpieza del contenido y funciones para guardar y limpiar al mismo tiempo.
        CF.setText("");
        ruta.setText("");
        CC.setText("");
        AL.setText("");
        Output.setText("");
        quitar.setVisible(false);
   AnalizarLex.setVisible(false);
   AnalizarSint.setVisible(false);
   Guardar.setVisible(false);
   limpiar.setVisible(false);
   CrearTabla.setVisible(false);
   LimpiarTabla.setVisible(false);
   this.LimpiarTablaActionPerformed(evt);
   AnalizarSem.setVisible(false); 
   Ejecutar.setVisible(false);

    }//GEN-LAST:event_limpiarActionPerformed

    private void quitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarActionPerformed
        String ruta1=ruta.getText();
        QuitarComentarios1 borraComentarios = new QuitarComentarios1(ruta1,"SinComentarios.java");
        int i = 1;
        try {
                        FileReader fr = new FileReader("SinComentarios.java");
                        BufferedReader br = new BufferedReader(fr);
                        String linea;
                        CC.setText("");
                        while ((linea = br.readLine()) != null) {
                            CC.append(i+" "+linea + "\n");
                            i++;
                        }
                        br.close();
                        fr.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
        String out=Output.getText();
        Output.setText(out+"Comentarios quitados \n");
        AnalizarLex.setVisible(true);
        Guardar.setVisible(true);
    }//GEN-LAST:event_quitarActionPerformed

    private void AnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarLexActionPerformed
        try{
        probarLexerFile();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    LocalDateTime ahora = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    fechalexer = ahora.format(formato); 
    String out=Output.getText();
    out=out+"Analizador lexico finalizado el "+fechalexer+"\n";
    Output.setText(out);
    AnalizarLex.setVisible(false);
    quitar.setVisible(false);
    }//GEN-LAST:event_AnalizarLexActionPerformed

    private void AnalizarSintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarSintActionPerformed
//se inician los contadores y errores 
//Inicialización de variables, contador de validaciones
        dobleTry=0; //Se reinician en 0 cada vez que presionas el botón
        dobleDo=0;
        dobleCatch=0;
        dobleWh=0;
        errores=0;
        
//Guarda la fecha y hora en que se ejecuta el análisis        
    LocalDateTime ahora = LocalDateTime.now();//Obtiene la fecha y hora actual del sistema
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");//Define un formato personalizado
    fechalexer = ahora.format(formato);//Convierte la fecha y hora (ahora) al formato que definiste
    Output.append("Inicio analizador sintactico el "+fechalexer+"\n");//al final imprime el formato 
        
//Lee línea por línea el archivo SinComentarios (ya limpio de comentarios).        
    try (BufferedReader br = new BufferedReader(new FileReader("SinComentarios.java"))) {//Abre el archivo SinComentarios.java para leerlo
//FileReader abre el archivo, y BufferedReader permite leerlo de forma eficiente, línea por línea.    
    String line; //Declara una variable temporal line que guardará cada línea leída del archivo.
    StringBuilder content = new StringBuilder();//Se crea un acumulador de texto llamado content.
    while ((line = br.readLine()) != null) {//Bucle que lee línea por línea hasta que ya no haya nada que leer (readLine)
    content.append(line).append(System.lineSeparator());//System.lineSeparator() añade el salto de línea del sistema operativo
    }    
    String textoSC=content.toString();//Convierte el contenido acumulado en StringBuilder a un String.
                                      //Ahora textoSC contiene todo el código del archivo SinComentarios.java
                                      //en una sola cadena de texto, listo para ser procesado en el análisis sintáctico.

//Divide el archivo en un arreglo de líneas (partes) y recorres cada línea con un ciclo for.                
    String[] partes= textoSC.split("\n"); //empiezacpor el 0 en la cadena del arreglo
    for (int i = 0; i < partes.length; i++) {//i es el índice de la línea actual.
//Esto permite que en el análisis sintáctico revises cada línea del archivo de forma independiente, 
//buscando estructuras como try, catch, while, do, etc.


//Dentro del for, se llaman a varios métodos que buscan estructuras de Java            
            EncuentraPackage(partes,i);
            EncuentraImport(partes,i);
            EncuentraInt(partes,i);
            EncuentraVectorInt(partes,i);
            EncuentraString(partes,i);
            EncuentraBoolean(partes,i); 
            EncuentraDouble(partes,i);
            EncuentraSout(partes,i);
            EncuentraScanner(partes,i); 
            EncuentraCharRegex(partes,i);
            EncuentraShort(partes,i);
            
//Y si las llaves { } son congruentes (verificadas con Llaves()), entonces también revisas:            
            if (Llaves(partes,i)) {
            EncuentraPublicClass(partes,i);
            EncuentraPublicStaticvoidmain(partes,i);
            EncuentraFor(partes,i);
            EncuentraWhile(partes,i);
            EncuentraDoWhile(partes,i);
            EncuentraTryCatch(partes,i);
            
//En caso de que las llaves estén mal balanceadas ({ y } no coinciden), marcas error y detienes el análisis:            
            }else{
            Output.append("Numero de llaves incongruente");
            errores++;
            break;
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

    if (errores == 0) {
        Output.append("Analizador sintactico finalizado sin errores el " + fechalexer + "\n");
        
        // --- AQUÍ SE HABILITA EL BOTÓN SEMÁNTICO ---
        AnalizarSem.setVisible(true);
        
    } else {
        Output.append("Analizador sintactico finalizado con " + errores + " errores el " + fechalexer + "\n");
    }
        AnalizarSint.setVisible(false);
        CrearTabla.setVisible(true);
         
    }//GEN-LAST:event_AnalizarSintActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
//Ignorar esta parte de codigo ya que se omitio para reducir el uso de clic y que se guarde automatico.
        /*        int i=JOptionPane.showConfirmDialog(rootPane, "¿Desea guardar los cambios?", "MiniCompilador",JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION)*/

            { 
            Guardar GuardarCambios = new Guardar(ruta.getText(),CF.getText());
            }
        CF.setText("");
        ruta.setText("");
        CC.setText("");
        AL.setText("");
        Output.setText("");
        quitar.setVisible(false);
   AnalizarLex.setVisible(false);
   AnalizarSint.setVisible(false);
   Guardar.setVisible(false);
   limpiar.setVisible(false);
   CrearTabla.setVisible(false);
   LimpiarTabla.setVisible(false);
   this.LimpiarTablaActionPerformed(evt);
   AnalizarSem.setVisible(false); 
   Ejecutar.setVisible(false);
    }//GEN-LAST:event_GuardarActionPerformed

    private void CrearTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearTablaActionPerformed
    // 1. Limpiar estructuras de datos y contadores
    tablaSimbolos.clear();
    simboloId = 1;
    int erroresTabla = 0; // Contador de errores de redefinición/estructura

    // 2. Obtener el código fuente
    String codigoFuente = leerArchivo("SinComentarios.java"); // Usamos la función de utilidad
    String[] lineas = codigoFuente.split("\n");
    
    // 3. Recorrer el código y buscar DECLARACIONES (Tipos y Nombres)
    
    // REGEX unificada para capturar (tipo) + (nombre) + opcionalmente (= valor);
    // Incluimos todos los tipos que manejas en tus funciones:
    Pattern patron = Pattern.compile("^(int|char|double|float|boolean|String|short|long)\\s+([a-zA-Z_$][a-zA-Z0-9_$]*)\\s*(=.*)?;");

    for (int i = 0; i < lineas.length; i++) {
        String linea = lineas[i].trim();
        Matcher matcher = patron.matcher(linea);

        if (matcher.find()) {
            String tipo = matcher.group(1);
            String nombre = matcher.group(2);
            String valorCompleto = matcher.group(3); 
            String valorInicial = "null";
            String clase = "variable"; 
            
            // =========================================================
            // CHEQUEO DE REDEFINICIÓN (Análisis Semántico 1)
            // =========================================================
            if (buscarSimbolo(nombre) != null) {
                Output.append("Error Semántico: Línea " + (i + 1) + ": Redefinición de la variable '" + nombre + "'.\n");
                erroresTabla++;
                continue; // Saltar la adición del símbolo duplicado
            }

            // Extracción y limpieza del valor inicial (si existe)
            if (valorCompleto != null) {
                valorInicial = valorCompleto.substring(1).trim().replace(";", ""); 
                // Aquí podrías agregar lógica para chequear si es una constante (ej: si se usa 'final')
                // if (linea.contains("final")) { clase = "constante"; } 
            }

            // 4. Agregar a la Tabla de Símbolos
            Simbolo nuevoSimbolo = new Simbolo(
                simboloId++, 
                nombre, 
                i + 1, 
                tipo, 
                valorInicial, 
                clase
            );
            tablaSimbolos.add(nuevoSimbolo);
        }
        
    }
    
    // 5. Finalizar y Activar el siguiente paso
    if (erroresTabla == 0) {
        mostrarTablaEnGUI(); // Mostrar la tabla en tu JTable
        Output.append("Tabla de Símbolos creada con " + tablaSimbolos.size() + " entradas. Lista para Análisis Semántico.\n");
        CrearTabla.setVisible(false);
        AnalizarSem.setVisible(true); // ¡Activa el botón de Análisis Semántico!
    } else {
        Output.append("Creación de la Tabla de Símbolos finalizada con " + erroresTabla + " errores. (Redefinición).\n");
    }
    
    LimpiarTabla.setVisible(true); // Mantienes tu lógica de visibilidad
    }//GEN-LAST:event_CrearTablaActionPerformed

    private void LimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarTablaActionPerformed
    // 1. Limpiar la Lista Interna de Símbolos 
    // Esto asegura que la próxima vez que presiones "Crear Tabla",
    // se creen nuevos símbolos desde cero, y no se usen los viejos.
    if (tablaSimbolos != null) {
        tablaSimbolos.clear();
    }
    
    // 2. Limpiar la Tabla Visual (JTable)
    DefaultTableModel model = (DefaultTableModel) Tabla.getModel();
    
    // Elimina todas las filas del modelo visual.
    // Usamos un bucle inverso para evitar errores de índice.
    for (int i = model.getRowCount() - 1; i >= 0; i--) {
        model.removeRow(i);
    }
    
    // Opcional: Limpiar el Output si lo deseas, para una limpieza completa
    // Output.setText("Salida de consola reiniciada.\n");
    
    System.out.println("Tabla de símbolos y lista interna limpiadas.");
    }//GEN-LAST:event_LimpiarTablaActionPerformed

    private void CrearClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearClassActionPerformed
    // 1. Obtener el código fuente que SÍ pasó el análisis (código limpio).
    // Suponemos que leerArchivo("SinComentarios.java") contiene el código del área de texto.
    String codigoSinComentarios = leerArchivo("SinComentarios.java"); 
    
    if (codigoSinComentarios.isEmpty()) {
        Output.append("Error: No se encontró código fuente limpio para compilar.\n");
        Ejecutar.setEnabled(false);
        return;
    }
    
    // 2. HACER EL COMPILADOR DINÁMICO (LA CORRECCIÓN CLAVE): 
    // Reemplazamos cualquier "public class XXX" por "public class ClaseCorrecta" 
    // para cumplir con la regla de Java y el nombre de archivo fijo.
    // Usamos replaceAll con RegEx para mayor robustez.
    String codigoParaCompilar = codigoSinComentarios.replaceAll("public class\\s+[A-Za-z0-9_]+", "public class ClaseCorrecta");

    // 3. Definir el nombre de archivo y el comando de compilación (CORRECTO)
    String nombreArchivoJava = "ClaseCorrecta.java"; 
    // Comando javac -d . para crear la carpeta Prueba/
    String comandoCompilacion = "javac -d . " + nombreArchivoJava;

    try {
        // 4. Guardar el código DINÁMICO en el archivo ClaseCorrecta.java
        guardarArchivo(nombreArchivoJava, codigoParaCompilar);

        // 5. Ejecutar el comando del sistema (javac)
        Process proceso = Runtime.getRuntime().exec(comandoCompilacion);
        proceso.waitFor(); 
        
        // 6. Capturar la salida de ERRORES
        try (java.io.BufferedReader errorReader = new java.io.BufferedReader(
             new java.io.InputStreamReader(proceso.getErrorStream()))) {
            
            StringBuilder errorOutput = new StringBuilder();
            String linea;
            while ((linea = errorReader.readLine()) != null) {
                errorOutput.append(linea).append("\n");
            }
            
            if (errorOutput.length() > 0) {
                // Hay errores de compilación
                Output.append("--- ERRORES DEL COMPILADOR DE JAVA (javac) ---\n");
                Output.append(errorOutput.toString());
                Ejecutar.setVisible(false);  
            } else {
                // Se Compila exitoso
                Output.append("¡Compilación exitosa!\n");
                
                // HABILITAR EJECUTAR
               Ejecutar.setVisible(true);
                
                // =========================================================
                // ✅ PREPARAR SCRIPT DE CONFIRMACIÓN (SOLO MENSAJE)
                // =========================================================
                String nombreScript = "EjecutarPausa.bat";
                
                // Script para el botón Compilar: Solo confirma éxito, pausa y cierra.
                String contenidoScript = 
                    "echo -----------------------------------------------------\n" +
                    "echo COMPILACION EXITOSA.\n" +
                    "echo La clase 'Prueba.ClaseCorrecta' ha sido generada.\n" +
                    "echo Ahora puede usar el boton EJECUTAR.\n" +
                    "echo -----------------------------------------------------\n" +
                    "pause\n" + 
                    "exit\n"; 

                try {
                    guardarArchivo(nombreScript, contenidoScript);
                    Runtime.getRuntime().exec("cmd /c start " + nombreScript);
                } catch (IOException e) {
                    Output.append("Error al ejecutar el script de confirmacion: " + e.getMessage() + "\n");
               Ejecutar.setVisible(false); // Ocultar si hay una excepción general
                }
            }
        }
    } catch (Exception e) {
        Output.append("Error al ejecutar el compilador: " + e.getMessage() + "\n");
        Ejecutar.setEnabled(false);
    }
    }//GEN-LAST:event_CrearClassActionPerformed
private void guardarArchivo(String nombreArchivo, String contenido) throws IOException {
    // Método auxiliar para escribir el contenido en un archivo.
    try (java.io.FileWriter escritor = new java.io.FileWriter(nombreArchivo)) {
        escritor.write(contenido);
    }
}
    private void EjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EjecutarActionPerformed
    String nombreClase = "ClaseCorrecta"; 
    String nombreScript = "EjecutarPausa.bat"; 
    String nombreArchivoJava = "ClaseCorrecta.java";
    String nombreCompletoClase = "Prueba." + nombreClase;

    Output.append("Iniciando ejecución de la clase compilada...\n");

    try {
        // 1. LEER EL CÓDIGO FUENTE FINAL para detectar si es gráfico.
        String codigoFuenteFinal = leerArchivo(nombreArchivoJava);
        
        String comandoBase;
        String tipoEjecucion;

        if (codigoFuenteFinal.contains("javax.swing")) {
            
            // --- GRÁFICO (javaw): NO ABRE CONSOLA ---
            comandoBase = "javaw";
            tipoEjecucion = "Gráfica (sin CMD)";
            
            // 2. EJECUCIÓN DIRECTA SIN PAUSA NI ARCHIVO .BAT FIJO
            // Ejecutamos javaw directamente desde Java, que lanza el proceso de Windows
            // y no deja la ventana de CMD abierta.
            
            String comandoCompleto = comandoBase + " -cp . " + nombreCompletoClase;
            Runtime.getRuntime().exec(comandoCompleto);

            Output.append("Tipo de ejecución detectada: " + tipoEjecucion + "\n");
            Output.append("La interfaz gráfica debería aparecer directamente en el escritorio.\n");
            
            return; // Salimos inmediatamente para evitar el código de CMD de abajo
            
        } else {
            
            // --- CONSOLA (java): ABRE CONSOLA Y PERMITE INTERACCIÓN ---
            comandoBase = "java";
            tipoEjecucion = "Consola (con CMD)";
            
            Output.append("Tipo de ejecución detectada: " + tipoEjecucion + "\n");
            
            // Generamos y ejecutamos el script .bat con PAUSE
            String contenidoScript = 
                comandoBase + " -cp . " + nombreCompletoClase + "\n" + 
                "pause\n" +  
                "exit\n";
            
            guardarArchivo(nombreScript, contenidoScript); 

            // Ejecutamos el script .bat en una ventana de CMD
            Runtime.getRuntime().exec("cmd /c start " + nombreScript);
            
            Output.append("Ventana de ejecución CMD abierta para " + tipoEjecucion + ".\n");
            Output.append("Presione cualquier tecla en la ventana de CMD para cerrarla.\n");
        }

    } catch (IOException e) {
      Output.append("Error al intentar ejecutar el archivo: " + e.getMessage() + "\n");
    }
    }//GEN-LAST:event_EjecutarActionPerformed

    private void AnalizarSemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarSemActionPerformed
    // 1. Ocultar el botón semántico (para que no lo presionen otra vez)
    AnalizarSem.setVisible(false);
    
    // 2. Reiniciar los contadores de errores (usaremos la variable 'errores' que ya existe)
    errores = 0;
    
    // 3. Registrar el inicio del análisis
    LocalDateTime ahora = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String fechaSemantico = ahora.format(formato);
    Output.append("Inicio analizador semántico el " + fechaSemantico + "\n");
    
    // 4. Llamar a la función de análisis semántico
    //    (Aquí se ejecutan los cálculos y se actualiza la lista interna tablaSimbolos)
    iniciarAnalisisSemantico();
    
    // =======================================================
    // 5. CAMBIO CRÍTICO: RECARGAR LA TABLA VISUAL
    // =======================================================
    // Se llama a la función para refrescar el JTable con los valores 
    // ACTUALIZADOS (ej: "a + b" se convierte en "15") desde tablaSimbolos.
    mostrarTablaEnGUI();
    
    // 6. Mostrar el resultado en el Output
    if (errores == 0) {
        Output.append("Análisis Semántico FINALIZADO SIN ERRORES.\n");
    } else {
        Output.append("Análisis Semántico FINALIZADO con " + errores + " errores.\n");
    }
}
// ...    }//GEN-LAST:event_AnalizarSemActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MC().setVisible(true);
            }
        });
    }
    // AGREGAR ESTA FUNCIÓN
public void iniciarAnalisisSemantico() {
    // 1. Obtener el código fuente sin comentarios
    String codigoFuente = leerArchivo("SinComentarios.java");
    if (codigoFuente.isEmpty()) return;

    String[] lineas = codigoFuente.split("\n");

    // Regex para buscar identificadores (variables) en el código.
    Pattern idPattern = Pattern.compile("([a-zA-Z_$][a-zA-Z0-9_$]*)");

    // Lista de palabras clave (Mantengo tu lista original)
    String palabrasClaveEspeciales = 
        "(\\bpackage\\b|\\bimport\\b|\\bclass\\b|\\bpublic\\b|\\bstatic\\b|\\bvoid\\b|\\bmain\\b|\\bargs\\b|\\bSystem\\b|\\bout\\b|\\bprintln\\b|" + 
        "\\btrue\\b|\\bfalse\\b|\\bif\\b|\\belse\\b|\\bwhile\\b|\\bfor\\b|" +
        "\\bint\\b|\\bchar\\b|\\bdouble\\b|\\bfloat\\b|\\bboolean\\b|\\bString\\b|\\bshort\\b|\\blong\\b|\\bnew\\b|\\btry\\b|\\bcatch\\b|\\bdo\\b|" +
        "\\bprivate\\b|\\bprotected\\b|\\bfinal\\b|" + 
        "\\bbreak\\b|\\bcontinue\\b|\\breturn\\b|\\bthis\\b|\\bsuper\\b)";

    // =======================================================
    // FASE 1: CHEQUEO DE USO DE VARIABLES NO DECLARADAS (Tu lógica)
    // =======================================================
    for (int i = 0; i < lineas.length; i++) {
        String linea = lineas[i];
        
        // ... (Tu lógica original de Fase 1 para detectar 'factor' no declarado) ...
        String lineaSinStrings = linea.replaceAll("\".*?\"", " ");
        String lineaLimpiaSimb = lineaSinStrings.replaceAll("[^a-zA-Z0-9_\\s]", " "); 
        
        if (lineaLimpiaSimb.contains("package") || lineaLimpiaSimb.contains("class") || lineaLimpiaSimb.contains("main") || lineaLimpiaSimb.contains("import")) {
            continue; 
        }
        
        if (lineaLimpiaSimb.matches("^\\s*(int|char|double|float|boolean|String|short|long)\\s+.*") && !linea.contains("=")) {
            continue; 
        }

        if (lineaLimpiaSimb.matches(".*(public|private|protected)\\s+(static\\s+)?(void|int|char|double|float|boolean|String|short|long|\\w+)\\s+\\w+\\s*\\(.*")) {
            continue; 
        }
        
        Matcher matcher = idPattern.matcher(lineaLimpiaSimb);
        int usoEnLinea = 0; 

        while (matcher.find()) {
            String idUsado = matcher.group(1);
            usoEnLinea++;

            if (usoEnLinea == 1 && linea.contains("=")) {
                continue; 
            }

            if (idUsado.matches(palabrasClaveEspeciales)) {
                continue; 
            }
            
            Simbolo s = buscarSimbolo(idUsado);

            if (s == null) {
                Output.append("Error Semántico: Línea " + (i + 1) + ": Uso de la variable '" + idUsado + "' no declarada.\n");
                errores++;
            }
        }
    }

    // =======================================================
    // FASE 2: EVALUACIÓN CONSTANTE Y CHEQUEO DE TIPOS (Lógica de solución)
    // =======================================================

    // Regex para encontrar CUALQUIER asignación con una expresión a la derecha
    Pattern asignacionTotalPattern = Pattern.compile(
        "(?:int|char|double|float|boolean|String|short|long)?\\s*([a-zA-Z_$][a-zA-Z0-9_$]*)\\s*=\\s*([^;]+)\\s*;"
    );

    for (int i = 0; i < lineas.length; i++) {
        String linea = lineas[i].trim();
        int numLinea = i + 1;

        Matcher matcherAsignacion = asignacionTotalPattern.matcher(linea);

        if (matcherAsignacion.find()) {
            
            String idDestino = matcherAsignacion.group(1).trim(); 
            String expresionCompleta = matcherAsignacion.group(2).trim();

            Simbolo sDestino = buscarSimbolo(idDestino);
            
            if (sDestino == null) continue; // No debería pasar si Fase 1 funcionó, pero es una protección.
// NUEVA LÓGICA: CASTING EXPLÍCITO (SOLUCIÓN)
// Detecta la sintaxis (tipo)ID o (tipo)literal
if (expresionCompleta.contains("(") && expresionCompleta.contains(")") && expresionCompleta.matches(".*\\(\\w+\\).*")) {
    
    // Asume que solo hay un casting en la expresión.
    String resultadoCasting = evaluarCastingExplicito(expresionCompleta);
    
    if (resultadoCasting != null) {
        // Verifica si el tipo de destino (int) coincide con el resultado del casting
        if (sDestino.tipoDato.equalsIgnoreCase("int")) {
            sDestino.valor = resultadoCasting;
            continue; // Éxito en el casting, pasa a la siguiente línea.
        } else {
            // Error Semántico: El casting explícito no es compatible con el tipo destino
            Output.append("Error Semántico: Línea " + numLinea + ": Casting explícito a " + resultadoCasting + " no compatible con destino " + sDestino.tipoDato + ".\n");
            errores++;
            continue;
        }
    } else {
        // Podría ser un error dentro de evaluarCastingExplicito (ej: variable fuente no existe)
        continue;
    }
}
            // -------------------------------------------------------------
            // A. CHEQUEO DE ASIGNACIÓN SIMPLE Y TIPOS INCOMPATIBLES
            // (Se asume que tienes implementado determinarTipo())
            // -------------------------------------------------------------
            if (!(linea.contains("+") || linea.contains("-") || linea.contains("*") || linea.contains("/"))) {
                String tipoFuente = determinarTipo(expresionCompleta); 
                if (tipoFuente != null && !sDestino.tipoDato.equalsIgnoreCase(tipoFuente)) {
                    Output.append("Error Semántico: Línea " + numLinea + ": Tipo incompatible. No se puede asignar " + tipoFuente + " a " + sDestino.tipoDato + ".\n");
                    errores++;
                }
                // Si solo es una asignación simple, actualiza el valor directamente si es un literal.
                if (tipoFuente != null && !sDestino.tipoDato.equalsIgnoreCase("String") && (expresionCompleta.matches("-?\\d+") || expresionCompleta.matches("-?\\d+\\.\\d+")) ) {
                    sDestino.valor = expresionCompleta;
                }
                continue; 
            }        
            // -------------------------------------------------------------
            // B. CONCATENACIÓN MÚLTIPLE (SOLUCIONA el error 'mensaje')
            // -------------------------------------------------------------
            if (sDestino.tipoDato.equalsIgnoreCase("String") && expresionCompleta.contains("+")) {
                // Si es un String y tiene '+', lo manda a la función especial de concatenación.
                String resultadoConcatenado = evaluarConcatenacionMultiple(expresionCompleta); 
                
                if (resultadoConcatenado != null) {
                    sDestino.valor = resultadoConcatenado;
                    continue; // Pasa a la siguiente línea, la expresión String ya fue resuelta.
                }
            }                    
            // -------------------------------------------------------------
            // C. ARITMÉTICA BINARIA SIMPLE (Tu lógica original para +, -, *, /)
            // -------------------------------------------------------------
            if (sDestino.tipoDato.equalsIgnoreCase("int") || sDestino.tipoDato.equalsIgnoreCase("double")) {
                
                // Se usa split para separar por el operador, manteniendo el operador en el array
                String[] partesExpresion = expresionCompleta.split("(?=[+\\-*/])|(?<=[+\\-*/])"); 

                // Solo si la expresión parece ser un BINARIO simple: [Operando1, Operador, Operando2]
                if (partesExpresion.length >= 3) { 
                    String idOp1 = partesExpresion[0].trim().replace("(", "");
                    String operador = partesExpresion[1].trim();
                    String idOp2 = partesExpresion[2].trim().replace(")", ""); 
                    
                    idOp1 = idOp1.trim();
                    idOp2 = idOp2.trim();
                    
                    if (idOp1.isEmpty() || operador.isEmpty() || idOp2.isEmpty()) { continue; }

                    // Llamada al método de evaluación
                    String resultadoCalculado = evaluarExpresion(idOp1, operador, idOp2);
                    
                    // 3. Actualización de la Tabla de Símbolos
                    if (resultadoCalculado != null) {
                        for (Simbolo s : tablaSimbolos) {
                            if (s.nombre.equals(idDestino)) {
                                s.valor = resultadoCalculado;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
private String evaluarConcatenacionMultiple(String expresion) {
    // 1. Divide la expresión por el operador '+' (maneja espacios antes y después)
    String[] partes = expresion.split("\\+"); 
    StringBuilder resultadoFinal = new StringBuilder();

    for (String parte : partes) {
        String valor = parte.trim();
        
        // 2. Obtener el valor de cada parte
        if (valor.startsWith("\"") && valor.endsWith("\"")) {
            // Es un Literal String, usa su valor sin comillas
            resultadoFinal.append(valor.replace("\"", ""));
        } else {
            // Es un ID (variable) o un literal numérico
            Simbolo s = buscarSimbolo(valor);
            if (s != null && s.valor != null) {
                // Si es un ID, usa su valor (quita comillas si es String)
                resultadoFinal.append(s.valor.replace("\"", ""));
            } else if (valor.matches("-?\\d+")) {
                // Es un literal numérico que no es un ID, úsalo directamente
                 resultadoFinal.append(valor);
            } else {
                // Si llegamos aquí, es un ID no inicializado o no encontrado
                // Deberíamos lanzar un error semántico si es crítico
                return null;
            }
        }
    }
    // 3. Devuelve el resultado final como un String, entre comillas
    return "\"" + resultadoFinal.toString() + "\"";
}
private String determinarTipo(String valor) {
    valor = valor.trim();
    
    // 1. Es un Literal String
    if (valor.startsWith("\"") && valor.endsWith("\"")) {
        return "String";
    }
    // 2. Es un Literal Entero
    if (valor.matches("-?\\d+")) {
        return "int";
    }
    // 3. Es un Literal de Punto Flotante
    if (valor.matches("-?\\d+\\.\\d+")) {
        return "double";
    }
    
    // 4. Es un ID. Buscar su tipo en la tabla de símbolos
    Simbolo s = buscarSimbolo(valor);
    if (s != null) {
        return s.tipoDato;
    }
    
    return null; // Tipo desconocido
}
// AGREGAR ESTA FUNCIÓN AL FINAL DE LA CLASE MC
public void chequearAsignacionTipos(String linea, int numLinea) {  
    // Simplificaremos, buscando una asignación simple: <tipo> <id> = <valor>;
    // Nos centraremos en errores evidentes, como asignar un String a un int.

    if (linea.contains("=")) {
        
        // 1. Validación para int
        if (linea.startsWith("int ")) {
        // Ejemplo: int variable = "texto";
        if (linea.contains("\"")) {
            Output.append("Error Semántico: Línea " + numLinea + ": Asignación de String a tipo int no permitida.\n");
              errores++;
            }
        }        
        // 2. Validación para boolean
        else if (linea.startsWith("boolean ")) {
            // Ejemplo: boolean flag = 123; (asumiendo que solo acepta true/false)
            if (!(linea.contains("true") || linea.contains("false"))) {
            // Buscamos algo que parezca un número o un string
            if (linea.contains("0") || linea.contains("1") || linea.contains("\"")) {
                Output.append("Error Semántico: Línea " + numLinea + ": Tipo de valor incompatible con boolean. Solo se acepta 'true' o 'false'.\n");
                  errores++;
                }
            }
        }        
        // 3. Validación para char
        else if (linea.startsWith("char ")) {
            // Ejemplo: char c = "texto";
            // Un char debe ir entre comillas simples y ser solo un carácter: 'a'
            if (!linea.matches("char\\s+\\w+\\s*=\\s*'.?'\\s*;")) {
                 if (linea.contains("\"")) { // Si contiene comillas dobles, es un String
                    Output.append("Error Semántico: Línea " + numLinea + ": Char debe asignarse con comillas simples ('c'), no dobles.\n");
                    errores++;
                }
            }
        }       
    }
}    
public void EncuentraInt(String partes[],int i){
      String palabra;//Declara una variable palabra que contendrá la porción de la línea que posiblemente sea una declaración de int.
      int intIndex= partes[i].indexOf("int ");//indexof busca la posicion del caracter dentro del string y devuelve un numero del indice
                                              //posicion del primer caracter encontrado y si lo encuentra devuelve -1
      int intIndex1= partes[i].indexOf(";");
      if (intIndex>-1) {
              palabra=partes[i].substring(intIndex,intIndex1+1);//Extrae la subcadena que va desde "int " hasta el punto y coma ;.
              System.out.println(palabra);//expresion regular ===v
              Pattern pat=Pattern.compile("^int\\s+([a-zA-Z][a-zA-Z0-9_]*\\s*(=\\s*[^,;]+)?\\s*(,\\s*[a-zA-Z_][a-zA-Z0-9_]*\\s*(=\\s*[^,;]+)?\\s*)*);\\s*?$");
              Matcher mat= pat.matcher(palabra);
          if (mat.matches()) {
              Output.append("Expresion int valido en la linea "+(i+1)+"\n");
          } else {
              Output.append("Expresion int no valido en la linea "+(i+1)+"\n");
              errores++;
          }}
      }
      
public void EncuentraPackage(String partes[],int i){
    String linea = partes[i].trim();//Obtiene la línea actual (partes[i]) y elimina espacios en blanco al inicio y final con .trim().
    int intIndex = linea.indexOf("package");//Busca la palabra "package" dentro de la línea.
                                    //Si existe, devuelve la posición donde empieza "package".
                                    //indexOf busca un texto en una cadena y devuelve la posición donde lo encontró o -1 si no existe.
    if (intIndex > -1) {//Si no existe, intIndex será -1.
        String palabra = linea.substring(intIndex);//Extrae desde donde empieza "package" hasta el final de la línea.
        Valpackage(palabra, i);
    }
}

public void Valpackage(String palabra, int i) {
    // Permite guiones bajos
    //Define una expresión regular para validar la sintaxis de un package.
    Pattern pat = Pattern.compile("^package\\s+[a-zA-Z][a-zA-Z0-9_]*\\s*;\\s*$");
    Matcher mat = pat.matcher(palabra);//Compara el texto (palabra) con el patrón definido.
    if (mat.matches()) {
        Output.append("package valido en la linea " + (i + 1) + "\n");
    } else {
        Output.append("package no valido en la linea " + (i + 1) + "\n");
        errores++;
    }
    }


public void probarLexerFile() throws IOException{
    Reader reader= new BufferedReader(new FileReader("SinComentarios.java"));
    Lexer lexer= new Lexer(reader);
    LocalDateTime ahora = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    fechalexer = ahora.format(formato);    
    String res="",out=Output.getText();
    out=out+"Analizador lexico creado el "+fechalexer+"\n";
    int i=1,y=0;
        while (true) {
            Token tokens =lexer.yylex();
            if (tokens==null) {
                if (y!=0) {
                    Output.setText(out+"Analizador lexico termino con "+y+" errores \n");
                }else{
                    Output.setText(out+"El analizador lexico termino sin errores"+" \n");
                    AnalizarSint.setVisible(true);
                }
                res=res+"EOF";
                AL.setText(res);
                return;
            }
            switch (tokens) {
                case ERROR:
                    out=out+"Error, simbolo "+lexer.yytext()+" no reconocido en la linea "+i+"\n";
                    y++;
                    break;
                case ID: case INT:
                    res=res+i+" Token: "+tokens+" "+lexer.lexeme+"\n";
                     break;
                case SALTO:
                    res=res+i+" Token: "+tokens+"\n";
                    i++; 
                    break;
                default:
                    res=res+i+" Token: "+tokens+"\n";
            }
        }
    }
    
public void EncuentraShort(String[] partes, int i) {
    if (partes[i].contains("short")) {
        String[] tokens = partes[i].trim().split("\\s+"); // Divide por espacios
        if (tokens.length >= 3 && tokens[0].equals("short")) {
            String nombreVar = tokens[1];
            // Ajustamos para obtener correctamente el valor, considerando "="
            String valorStr = "";
            for (int j = 2; j < tokens.length; j++) {
                if (tokens[j].equals("=") && j + 1 < tokens.length) {
                    valorStr = tokens[j + 1].replace(";", "");
                    break;
                }
            }

            try {
                int valor = Integer.parseInt(valorStr);
                if (valor < -32768 || valor > 32767) {
                    Output.append("Error: El valor de short '" + nombreVar + "' fuera de rango en la línea " + (i + 1) + ".\n");
                    errores++;
                } else {
                    Output.append("Correcto: short " + nombreVar + " = " + valor + " en la línea " + (i + 1) + "\n");
                }
            } catch (NumberFormatException e) {
                Output.append("Error: Valor asignado a short '" + nombreVar + "' no es válido en la línea " + (i + 1) + ".\n");
                errores++;
            }
        }
    }
}
public void EncuentraImport(String partes[],int i){
    String palabra;
    int intIndex= partes[i].indexOf("import");
    if (intIndex>-1) {
            palabra=partes[i].substring(intIndex,partes[i].length());
            ValImport(palabra,i);
        }
    }
public void ValImport(String palabra, int i){
    Pattern pat=Pattern.compile("^import\\s+([a-zA-Z_][a-zA-Z0-9_]*\\.)*[a-zA-Z_][a-zA-Z0-9_]*(\\.\\*)?;\\s*$");
    Matcher mat= pat.matcher(palabra);
        if (mat.matches()) {
            Output.append("import valido en la linea "+(i+1)+"\n");
        } else {
            Output.append("import no valido en la linea "+(i+1)+"\n");
            errores++;
        }
    }
public void EncuentraPublicClass(String partes[],int i){
    String linea = partes[i].trim();
    int intIndex = linea.indexOf("public class");
    if (intIndex > -1) {
        String palabra = linea.substring(intIndex);
        ValPublicClass(palabra, i);
    }
}

public void ValPublicClass(String palabra, int i) {
    // Permite _ , extends, implements
    Pattern pat = Pattern.compile(
        "^public\\s+class\\s+\\w+(\\s+extends\\s+\\w+(\\.\\w+)*)?(\\s+implements\\s+[\\w,\\s]+)?\\s*\\{?\\s*$"
    );
    Matcher mat = pat.matcher(palabra);
    if (mat.matches()) {
        Output.append("PublicClass valido en la linea " + (i + 1) + "\n");
    } else {
        Output.append("PublicClass no valido en la linea " + (i + 1) + "\n");
        errores++;
    }
    }
public void EncuentraPublicStaticvoidmain(String partes[],int i){
    String linea = partes[i].trim();
    if (linea.toLowerCase().contains("public static void main")) {
        Pattern pat = Pattern.compile(
        "^public\\s+static\\s+void\\s+main\\s*\\(\\s*String\\s*\\[\\]\\s+\\w+\\s*\\)\\s*\\{?\\s*$",
        Pattern.CASE_INSENSITIVE
        );
        Matcher mat = pat.matcher(linea);
        if (mat.matches()) {
            Output.append("Public Static void main valido en la linea " + (i + 1) + "\n");
        } else {
            Output.append("Public Static void main no valido en la linea " + (i + 1) + "\n");
            errores++;
        }
    }
    }
public void ValPublicStaticvoidmain(String palabra, int i){
    Pattern pat=Pattern.compile("^public\\s+static\\s+void\\s+main\\s*\\(\\s*String\\s*\\[\\]\\s*args\\s*\\)\\s*\\{?\\s+$");
    Matcher mat= pat.matcher(palabra);
        if (mat.matches()) {
            Output.append("Public Static void main valido en la linea "+(i+1)+"\n");
        } else {
            Output.append("Public Static void main no valido en la linea "+(i+1)+"\n");
            errores++;
        }
    }
public void EncuentraFor(String partes[],int i){
    String palabra;
    int intIndex1= partes[i].indexOf("for");
        if (intIndex1>-1) {
            palabra=partes[i].substring(intIndex1,partes[i].length());
            ValFor(palabra,i);
        }
    }
public void ValFor(String palabra, int i){
    Pattern pat=Pattern.compile("^for\\s*\\(\\s*(int|char)\\s+\\w+\\s*=\\s*[^;]+;\\s*[^;]+;\\s*[^)]+\\)\\s*\\{?\\s*$");
    Matcher mat= pat.matcher(palabra);
        if (mat.matches()) {
            Output.append("Ciclo for valido en la linea "+(i+1)+"\n");
        } else {
            Output.append("Ciclo for no valido en la linea "+(i+1)+"\n");
            errores++;
        }
    }
    
public void EncuentraWhile(String partes[],int i){
    String palabra;
    int intIndex1= partes[i].indexOf("while");
    int intIndex2= partes[i].indexOf("} while");
        if (intIndex2==-1) {
        if (intIndex1>-1) {
            palabra=partes[i].substring(intIndex1,partes[i].length());
            ValWhile(palabra,i);
        }}
    }
public void ValWhile(String palabra, int i){
    Pattern pat=Pattern.compile("^while\\s*\\(.*\\)\\s*\\{?\\s*$");
    Matcher mat= pat.matcher(palabra);
        if (mat.matches()) {
            Output.append("Ciclo while valido en la linea "+(i+1)+"\n");
        } else {
            Output.append("Ciclo while no valido en la linea "+(i+1)+"\n");
            errores++;
        }
    }
    
public void EncuentraDoWhile(String partes[],int i){
    String palabra = null;int j;
    int intIndex1= partes[i].indexOf("} while");
    for (j = 0; j < partes.length; j++) {
    palabra=EncuentraDo(partes,j);
        if (palabra!=null && dobleDo<j) {
                break;
        }
    }
    if (intIndex1>-1) {
        palabra+="\n"+partes[i].substring(intIndex1,partes[i].length());
        ValDoWhile(palabra,i,j);
        }
    }
public void ValDoWhile(String palabra, int i,int j){
    Pattern pat=Pattern.compile("^do\\s*\\{?\\s*\\}?\\s*while\\s*\\([\\s\\S]*?\\)\\s*;\\s*$");
    Matcher mat= pat.matcher(palabra);
        if (mat.matches()) {
            Output.append("Ciclo do while valido en las lineas "+(j+1)+" y "+(i+1)+"\n");
            dobleDo=j;
            dobleWh=i;
        } else {
            Output.append("Ciclo do while no valido en la linea "+(i+1)+"\n");
            errores++;
        }
    }
    
public String EncuentraDo(String partes[],int i){
    String palabra=null;
    int intIndex1= partes[i].indexOf("do ");
        if (intIndex1>-1) {
            palabra=partes[i].substring(intIndex1,partes[i].length());
        }
        return palabra;
    }
    
public void EncuentraTryCatch(String partes[],int i){
    String palabra = null;int j;
    int intIndex1= partes[i].indexOf("} catch");
    for (j = 0; j < partes.length; j++) {
    palabra=EncuentraTry(partes,j);
        if (palabra!=null && dobleTry<j) {
            break;
        }
    }
        if (intIndex1>-1 && dobleCatch<i) {
            palabra+="\n"+partes[i].substring(intIndex1,partes[i].length());
            ValTryCatch(palabra,i,j);
        }
    }
public void ValTryCatch(String palabra, int i,int j){
    Pattern pat = Pattern.compile(
        "try\\s*\\{[\\s\\S]*?\\}\\s*catch\\s*\\(\\s*[a-zA-Z_][a-zA-Z0-9_]*\\s+[a-zA-Z_][a-zA-Z0-9_]*\\s*\\)\\s*\\{[\\s\\S]*?\\}",
        Pattern.MULTILINE
    );
    Matcher mat = pat.matcher(palabra);
    if (mat.find()) {
        Output.append("Try catch valido en las lineas " + (j + 1) + " y " + (i + 1) + "\n");
        dobleTry = j;
        dobleCatch = i;
    } else {
        Output.append("Try catch no valido en la linea " + (i + 1) + "\n");
        errores++;
    }
    }
    
public String EncuentraTry(String partes[],int i){
    String palabra=null;
    int intIndex1= partes[i].indexOf("try");
        if (intIndex1>-1) {
            palabra=partes[i].substring(intIndex1,partes[i].length());
        }
        return palabra;
    }
    
public void EncuentraString(String partes[],int i){
    String linea = partes[i];
    // Define lo que puede ser la parte derecha del '='
    String expresionDerecha = 
        // Acepta un Literal String ("...") O un ID (variable)
        "(\".*?\"|[a-zA-Z_$][a-zA-Z0-9_$]*)"; 
    
    // Acepta una Expresión Compuesta (Operando + Operando + ..)
    String expresionConcatenacion = 
        // Empieza con un Operando (ID o Literal)
        "\\s*(\".*?\"|[a-zA-Z_$][a-zA-Z0-9_$]*)" + 
        // Acepta 0 o más repeticiones de (+ Operando)
        "(\\s*\\+\\s*(\".*?\"|[a-zA-Z_$][a-zA-Z0-9_$]*))*"; 
        
    // REGEX FINAL (Corregido para aceptar concatenación)
    String regexString = 
        "^\\s*String\\s+([a-zA-Z_$][a-zA-Z0-9_$]*)\\s*=\\s*" + 
        expresionConcatenacion + 
        "\\s*;\\s*$";
    
    Pattern pattern = Pattern.compile(regexString);
    Matcher matcher = pattern.matcher(linea);

    if (matcher.matches()) {
        Output.append("Expresion String valido en la linea " + (i + 1) + "\n");
    } else {
}
 }
    
public void EncuentraBoolean(String partes[],int i){
    String palabra;
    int intIndex= partes[i].indexOf("boolean ");
    int intIndex1= partes[i].indexOf(";");
    if (intIndex>-1) {
            palabra=partes[i].substring(intIndex,intIndex1+1);
            Pattern pat=Pattern.compile("^boolean\\s+([a-zA-Z]\\w+\\s*(=\\s*(true|false))?\\s*(,\\s*\\w+\\s*(=\\s*(true|false))?\\s*)*);\\s*$");
            Matcher mat= pat.matcher(palabra);
        if (mat.matches()) {
            Output.append("Expresion boolean valido en la linea "+(i+1)+"\n");
        } else {
            Output.append("Expresion boolean no valido en la linea "+(i+1)+"\n");errores++;
        }}
    }
    
public void EncuentraChar(String partes[],int i){
    int intIndex = partes[i].indexOf("char ");
    int intIndex1 = partes[i].indexOf(";");

    if (intIndex > -1 && intIndex1 > intIndex) {
        String palabra = partes[i].substring(intIndex, intIndex1 + 1);

        // Regex que acepta cualquier caracter UTF-8 dentro de comillas simples
        Pattern pat = Pattern.compile(
            "^char\\s+[a-zA-Z]\\w*\\s*(=\\s*'[^']{1}')?\\s*(,\\s*[a-zA-Z]\\w*\\s*(=\\s*'[^']{1}')?\\s*)*;\\s*$",
            Pattern.UNICODE_CASE
        );

        Matcher mat = pat.matcher(palabra);
        if (mat.matches()) {
            Output.append("Expresion Char valido en la linea " + (i + 1) + "\n");
        } else {
            Output.append("Expresion Char no valido en la linea " + (i + 1) + "\n");
            errores++;
        }
    }
    }
    
public void EncuentraDouble(String partes[],int i){
    String palabra;
    int intIndex= partes[i].indexOf("double ");
    int intIndex1= partes[i].indexOf(";");
    if (intIndex>-1) {
            palabra=partes[i].substring(intIndex,intIndex1+1);
            Pattern pat=Pattern.compile("^double\\s+([a-zA-Z]\\w+\\s*(=\\s*[\\d.]+)?\\s*(,\\s*\\w+\\s*(=\\s*[\\d.]+)?\\s*)*);\\s*$");
            Matcher mat= pat.matcher(palabra);
        if (mat.matches()) {
            Output.append("Expresion double valido en la linea "+(i+1)+"\n");
        } else {
            Output.append("Expresion double no valido en la linea "+(i+1)+"\n");errores++;
        }}
    }
    
public void EncuentraVectorInt(String partes[],int i){
    String palabra;
    int intIndex= partes[i].indexOf("int[]");
    int intIndex1= partes[i].indexOf(";");
    if (intIndex>-1) {
            palabra=partes[i].substring(intIndex,intIndex1+1);
            Pattern pat=Pattern.compile("^int\\[\\]\\s+([a-zA-Z]\\w+\\s*(=\\s*\\{\\s*(\\d+\\s*(,\\s*\\d+\\s*)*)?\\s*\\})?\\s*(,\\s*\\w+\\s*(=\\s*\\{\\s*(\\d+\\s*(,\\s*\\d+\\s*)*)?\\s*\\})?\\s*)*);$");
            Matcher mat= pat.matcher(palabra);
        if (mat.matches()) {
            Output.append("Expresion de vector int valido en la linea "+(i+1)+"\n");
        } else {
            Output.append("Expresion de vector int no valido en la linea "+(i+1)+"\n");errores++;
        }}
    }
    
public void EncuentraSout(String partes[],int i){
    String palabra;
    int intIndex = partes[i].indexOf("System.out.println");
    int intIndex1 = partes[i].indexOf(";");
    if (intIndex > -1 && intIndex1 > intIndex) {
        palabra = partes[i].substring(intIndex, intIndex1 + 1);

        // Regex flexible para strings, variables y expresiones básicas
        Pattern pat = Pattern.compile(
            "^System\\.out\\.println\\s*\\(\\s*(" +
                "\"[^\"]*\"" +          // cadenas literales
                "|[a-zA-Z_][a-zA-Z0-9_]*" +  // variables
                "(\\s*[\\+\\-\\*/]\\s*[a-zA-Z0-9_]+)*" + // expresiones simples
            ")(\\s*\\+\\s*\"[^\"]*\"|\\s*\\+\\s*[a-zA-Z_][a-zA-Z0-9_]*)*\\s*\\)\\s*;\\s*$"
        );

        Matcher mat = pat.matcher(palabra);
        if (mat.matches()) {
            Output.append("Expresion para imprimir valido en la linea " + (i + 1) + "\n");
        } else {
            Output.append("Expresion para imprimir no valido en la linea " + (i + 1) + "\n");
            errores++;
        }
    }
    }
    
public void EncuentraScanner(String[] partes, int i) {
    String linea = partes[i].trim();

    // Caso 1: import de Scanner
    if (linea.startsWith("import") && linea.contains("Scanner")) {
        Output.append("Import Scanner válido en la línea " + (i + 1) + "\n");
        return;
    }

    // Caso 2: declaración de Scanner
    if (linea.startsWith("Scanner")) {
        // Patrón para validar la declaración de Scanner
        Pattern pat = Pattern.compile("^Scanner\\s+\\w+\\s*=\\s*new\\s+Scanner\\(System\\.in\\)\\s*;\\s*$");
        Matcher mat = pat.matcher(linea);

        if (mat.matches()) {
            Output.append("Scanner válido en la línea " + (i + 1) + "\n");
        } else {
            Output.append("Error: Scanner mal declarado en la línea " + (i + 1) + "\n");
            errores++;
        }
    }
}
public boolean Llaves(String partes[],int i){
    int CA=0,CC=0;
    boolean valido=false;
    for (int j = 0; j < partes.length; j++) {
    for (char c : partes[j].toCharArray()) {
                    if (c == '{') {
                        CA++;
                    } else if (c == '}') {
                        CC++;
                    }
                }}
    if (CA==CC) {
    valido=true;
    }
     return valido;
    }
public void AgregarRow(String Nom, String Tipo, String Valor, int Num) {
    // Crear el vector de la fila, usando String.valueOf para convertir enteros a cadenas
    Boolean Unica=true;
        for (int fila = 0; fila < model.getRowCount(); fila++) {
        if (model.getValueAt(fila, 3).toString().equals(Nom)) {
            Unica=false;
            fila=fila+1;
            Output.append("Variable "+Nom+" ya iniciada en fila: "+fila);
            break;
        }
    }
        if (Unica) {
            String[] vector = {String.valueOf(ID), String.valueOf(Num + 1), Tipo, Nom, Valor};
            model.addRow(vector);
            ID++;
        }       
}
public void TablaInt(String[] partes, int i) {
    String Nom = "", Valor = "";
    int Coma = 0;

    // Buscar la declaración de un int en la cadena
    int intIndex = partes[i].indexOf("int ");
    if (intIndex == -1) return; // Si no hay 'int', salimos

    intIndex += 4; // Saltar el "int "
    int FinalIntIndex = partes[i].indexOf(";");
    int ComaIndex = partes[i].indexOf(",");
    int IgualIndex = partes[i].indexOf("=");

    // Procesar las variables separadas por comas
    while (ComaIndex != -1) {
        if (IgualIndex != -1 && IgualIndex < ComaIndex) {
            Nom = partes[i].substring(intIndex, IgualIndex).trim();
            Valor = partes[i].substring(IgualIndex + 1, ComaIndex).trim();
        } else {
            Nom = partes[i].substring(intIndex, ComaIndex).trim();
            Valor = "null";
        }
        // Agregar fila a la tabla
        AgregarRow(Nom, "Int", Valor, i);
        // Actualizar índices para la próxima iteración
        Coma = ComaIndex + 1;
        intIndex = Coma;
        ComaIndex = partes[i].indexOf(",", Coma);
        IgualIndex = partes[i].indexOf("=", Coma);
    }
    // Procesar el último valor o único int
    if (IgualIndex != -1) {
        Nom = partes[i].substring(intIndex, IgualIndex).trim();
        Valor = partes[i].substring(IgualIndex + 1, FinalIntIndex).trim();
    } else {
        Nom = partes[i].substring(intIndex, FinalIntIndex).trim();
        Valor = "null";
    }
    // Agregar última fila a la tabla
    AgregarRow(Nom, "Int", Valor, i);
}
public void TablaChar(String[] partes, int i) {
    String Nom = "", Valor = "";
    int Coma = 0;

    // Busqueda la declaración de un char en la cadena
    int intIndex = partes[i].indexOf("char ");
    if (intIndex == -1) return; // Si no hay 'char', salir

    intIndex += 5; // Saltar el "char "
    int FinalIntIndex = partes[i].indexOf(";");
    int ComaIndex = partes[i].indexOf(",");
    int IgualIndex = partes[i].indexOf("=");

    while (ComaIndex != -1) {
        if (IgualIndex != -1 && IgualIndex < ComaIndex) {
            Nom = partes[i].substring(intIndex, IgualIndex).trim();
            Valor = partes[i].substring(IgualIndex + 2, ComaIndex).trim(); // Para chars, valor comienza dos posiciones después del "="
        } else {
            Nom = partes[i].substring(intIndex, ComaIndex).trim();
            Valor = "null";
        }

        // Agregar fila a la tabla
        AgregarRow(Nom, "Char", Valor, i);

        // Actualizar índices para la próxima iteración
        Coma = ComaIndex + 1;
        intIndex = Coma;
        ComaIndex = partes[i].indexOf(",", Coma);
        IgualIndex = partes[i].indexOf("=", Coma);
    }

    // Procesar el último valor o único char
    if (IgualIndex != -1) {
        Nom = partes[i].substring(intIndex, IgualIndex).trim();
        Valor = partes[i].substring(IgualIndex + 1, FinalIntIndex).trim();
    } else {
        Nom = partes[i].substring(intIndex, FinalIntIndex).trim();
        Valor = "null";
    }

    // Agregar última fila a la tabla
    AgregarRow(Nom, "Char", Valor, i);
}

public void TablaDouble(String[] partes, int i) {
    String Nom = "", Valor = "";
    int Coma = 0;

    // Buscar la declaración de un double en la cadena
    int intIndex = partes[i].indexOf("double ");
    if (intIndex == -1) return; // Si no hay 'double', salimos

    intIndex += 7; // Saltar el "double "
    int FinalIntIndex = partes[i].indexOf(";");
    int ComaIndex = partes[i].indexOf(",");
    int IgualIndex = partes[i].indexOf("=");

    while (ComaIndex != -1) {
        if (IgualIndex != -1 && IgualIndex < ComaIndex) {
            Nom = partes[i].substring(intIndex, IgualIndex).trim();
            Valor = partes[i].substring(IgualIndex + 1, ComaIndex).trim();
      } else {
            Nom = partes[i].substring(intIndex, ComaIndex).trim();
            Valor = "null";
        }
        // Agregar fila a la tabla
        AgregarRow(Nom, "Double", Valor, i);

        // Actualizar índices para la próxima iteración
        Coma = ComaIndex + 1;
        intIndex = Coma;
        ComaIndex = partes[i].indexOf(",", Coma);
        IgualIndex = partes[i].indexOf("=", Coma);
    }
    // Procesar el último valor (después de la última coma o único double)
    if (IgualIndex != -1) {
        Nom = partes[i].substring(intIndex, IgualIndex).trim();
        Valor = partes[i].substring(IgualIndex + 1, FinalIntIndex).trim();
    } else {
        Nom = partes[i].substring(intIndex, FinalIntIndex).trim();
        Valor = "null";
    }

    // Agregar última fila a la tabla
    AgregarRow(Nom, "Double", Valor, i);
}
public void EncuentraCharRegex(String[] partes, int i) {
    if (partes[i].contains("char ")) {
        System.out.println("Se encontró una declaración de char en la línea " + i);
    }
}


public void TablaFloat(String[] partes, int i) {
    String Nom = "", Valor = "";
    int Coma = 0;

    // Buscar la declaración de un float en la cadena
    int intIndex = partes[i].indexOf("float ");
    if (intIndex == -1) return; // Si no hay 'float', salimos

    intIndex += 6; // Saltar el "float "
    int FinalIntIndex = partes[i].indexOf(";");
    int ComaIndex = partes[i].indexOf(",");
    int IgualIndex = partes[i].indexOf("=");

    while (ComaIndex != -1) {
        if (IgualIndex != -1 && IgualIndex < ComaIndex) {
            Nom = partes[i].substring(intIndex, IgualIndex).trim();
            Valor = partes[i].substring(IgualIndex + 1, ComaIndex).trim();
        } else {
            Nom = partes[i].substring(intIndex, ComaIndex).trim();
            Valor = "null";
        }
        
        // Agregar fila a la tabla
        AgregarRow(Nom, "Float", Valor, i);

        // Actualizar índices para la próxima iteración
        Coma = ComaIndex + 1;
        intIndex = Coma;
        ComaIndex = partes[i].indexOf(",", Coma);
        IgualIndex = partes[i].indexOf("=", Coma);
    }

    // Procesar el último valor (después de la última coma o único float)
    if (IgualIndex != -1) {
        Nom = partes[i].substring(intIndex, IgualIndex).trim();
        Valor = partes[i].substring(IgualIndex + 1, FinalIntIndex).trim();
    } else {
        Nom = partes[i].substring(intIndex, FinalIntIndex).trim();
        Valor = "null";
    }

    // Agregar última fila a la tabla
    AgregarRow(Nom, "Float", Valor, i);
}
public void TablaBoolean(String[] partes, int i) {
    String Nom = "", Valor = "";
    int Coma = 0;

    // Buscar la declaración de un float en la cadena
    int intIndex = partes[i].indexOf("boolean ");
    if (intIndex == -1) return; // Si no hay 'float', salimos

    intIndex += 8; // Saltar el "float "
    int FinalIntIndex = partes[i].indexOf(";");
    int ComaIndex = partes[i].indexOf(",");
    int IgualIndex = partes[i].indexOf("=");

    while (ComaIndex != -1) {
        if (IgualIndex != -1 && IgualIndex < ComaIndex) {
            Nom = partes[i].substring(intIndex, IgualIndex).trim();
            Valor = partes[i].substring(IgualIndex + 1, ComaIndex).trim();
        } else {
            Nom = partes[i].substring(intIndex, ComaIndex).trim();
            Valor = "null";
        }
        
        // Agregar fila a la tabla
        AgregarRow(Nom, "Boolean", Valor, i);

        // Actualizar índices para la próxima iteración
        Coma = ComaIndex + 1;
        intIndex = Coma;
        ComaIndex = partes[i].indexOf(",", Coma);
        IgualIndex = partes[i].indexOf("=", Coma);
    }

    // Procesar el último valor (después de la última coma o único float)
    if (IgualIndex != -1) {
        Nom = partes[i].substring(intIndex, IgualIndex).trim();
        Valor = partes[i].substring(IgualIndex + 1, FinalIntIndex).trim();
    } else {
        Nom = partes[i].substring(intIndex, FinalIntIndex).trim();
        Valor = "null";
    }

    // Agregar última fila a la tabla
    AgregarRow(Nom, "Boolean", Valor, i);
}
public void TablaString(String[] partes, int i) {
    String Nom = "", Valor = "";
    int Coma = 0;

    // Buscar la declaración de un String en la cadena
    int intIndex = partes[i].indexOf("String ");
    if (intIndex == -1) return; // Si no hay 'String', salir

    intIndex += 7; // Saltar el "String "
    int FinalIntIndex = partes[i].indexOf(";");
    int ComaIndex = partes[i].indexOf(",");
    int IgualIndex = partes[i].indexOf("=");

    // Procesar las variables separadas por comas
    while (ComaIndex != -1) {
        if (IgualIndex != -1 && IgualIndex < ComaIndex) {
            Nom = partes[i].substring(intIndex, IgualIndex).trim();
            Valor = partes[i].substring(IgualIndex + 1, ComaIndex).trim();

            // Verificar que el valor esté entre comillas
            if (!Valor.startsWith("\"") || !Valor.endsWith("\"")) {
                Valor = "null";
            }
        } else {
            Nom = partes[i].substring(intIndex, ComaIndex).trim();
            Valor = "null";
        }

        // Agregar fila a la tabla
        AgregarRow(Nom, "String", Valor, i);

        // Actualizar índices para la próxima iteración
        Coma = ComaIndex + 1;
        intIndex = Coma;
        ComaIndex = partes[i].indexOf(",", Coma);
        IgualIndex = partes[i].indexOf("=", Coma);
    }

    // Procesar el último valor o único String
    if (IgualIndex != -1) {
        Nom = partes[i].substring(intIndex, IgualIndex).trim();
        Valor = partes[i].substring(IgualIndex + 1, FinalIntIndex).trim();

        // Verificar que el valor esté entre comillas
        if (!Valor.startsWith("\"") || !Valor.endsWith("\"")) {
            Valor = "null";
        }
    } else {
        Nom = partes[i].substring(intIndex, FinalIntIndex).trim();
        Valor = "null";
    }

    // Agregar última fila a la tabla
    AgregarRow(Nom, "String", Valor, i);
}

public void TablaLong(String[] partes, int i) {
    String Nom = "", Valor = "";
    int Coma = 0;

    // Buscar la declaración de un long en la cadena
    int longIndex = partes[i].indexOf("long ");
    if (longIndex == -1) return;

    longIndex += 5; // Saltar el "long "
    int FinalLongIndex = partes[i].indexOf(";");
    int ComaIndex = partes[i].indexOf(",");
    int IgualIndex = partes[i].indexOf("=");

    // Procesar las variables separadas por comas
    while (ComaIndex != -1) {
        if (IgualIndex != -1 && IgualIndex < ComaIndex) {
            Nom = partes[i].substring(longIndex, IgualIndex).trim();
            Valor = partes[i].substring(IgualIndex + 1, ComaIndex).trim();
        } else {
            Nom = partes[i].substring(longIndex, ComaIndex).trim();
            Valor = "null";
        }
        AgregarRow(Nom, "Long", Valor, i);

        // Actualizar índices para la próxima iteración
        Coma = ComaIndex + 1;
        longIndex = Coma;
        ComaIndex = partes[i].indexOf(",", Coma);
        IgualIndex = partes[i].indexOf("=", Coma);
    }

    // Procesar el último valor o único long
    if (IgualIndex != -1) {
        Nom = partes[i].substring(longIndex, IgualIndex).trim();
        Valor = partes[i].substring(IgualIndex + 1, FinalLongIndex).trim();
    } else {
        Nom = partes[i].substring(longIndex, FinalLongIndex).trim();
        Valor = "null";
    }
    AgregarRow(Nom, "Long", Valor, i);
}

public void TablaShort(String[] partes, int i) {
    String Nom = "", Valor = "";
    int Coma = 0;

    // Buscar la declaración de un short en la cadena
    int shortIndex = partes[i].indexOf("short ");
    if (shortIndex == -1) return; 

    shortIndex += 6; // Saltar el "short "
    int FinalShortIndex = partes[i].indexOf(";");
    int ComaIndex = partes[i].indexOf(",");
    int IgualIndex = partes[i].indexOf("=");

    // Procesar las variables separadas por comas
    while (ComaIndex != -1) {
        if (IgualIndex != -1 && IgualIndex < ComaIndex) {
            Nom = partes[i].substring(shortIndex, IgualIndex).trim();
            Valor = partes[i].substring(IgualIndex + 1, ComaIndex).trim();
        } else {
            Nom = partes[i].substring(shortIndex, ComaIndex).trim();
            Valor = "null";
        }
        AgregarRow(Nom, "Short", Valor, i);
        
        // Actualizar índices para la próxima iteración
        Coma = ComaIndex + 1;
        shortIndex = Coma;
        ComaIndex = partes[i].indexOf(",", Coma);
        IgualIndex = partes[i].indexOf("=", Coma);
    }

    // Procesar el último valor o único short
    if (IgualIndex != -1) {
        Nom = partes[i].substring(shortIndex, IgualIndex).trim();
        Valor = partes[i].substring(IgualIndex + 1, FinalShortIndex).trim();
    } else {
        Nom = partes[i].substring(shortIndex, FinalShortIndex).trim();
        Valor = "null";
    }

    // Agregar última fila a la tabla (Aquí es donde se haría el chequeo de rango si es numérico)
    AgregarRow(Nom, "Short", Valor, i);
}

public void TablaVariables(String[] partes, int i) {
    int fila, filaV, op = 0;
    String Va = "", Va2 = "", valorActual = "", valorAnterior, NomV = "";

    // Encuentra la fila de la variable que se va a actualizar
    fila = buscarFila(partes[i]);
    if (fila == -1) return;

    // Ciclo para manejar múltiples operaciones
    int inicioOperando = partes[i].indexOf("=") + 2;
    int finalOperando = partes[i].indexOf(";");
    while (inicioOperando < finalOperando) {
        // Busca el primer operando y operador
        if (Va.isBlank()) {
             Va = extraerOperando(partes[i], inicioOperando, finalOperando);
             Va = obtenerValorTabla(Va);  // Verifica si es una variable de la tabla
        }
        
        System.out.println("Va:"+Va);
        // Determina el operador actual
        op = obtenerOperacion(partes[i], inicioOperando, finalOperando);
        if (op == 0) {
            valorActual = Va;  // No hay más operadores
            break;
        }
        System.out.println("op:"+op);
        // Busca el siguiente operando
        int operadorPos = obtenerPosicionOperador(partes[i], inicioOperando, finalOperando);
        Va2 = extraerOperando(partes[i], operadorPos + 1, finalOperando);
        Va2 = obtenerValorTabla(Va2);  // Verifica si es una variable de la tabla
        System.out.println("Va2:"+Va2);
        // Realiza la operación y actualiza Va
        Va = realizarOperacion(op, Va, Va2);

        // Avanza al siguiente operador
        inicioOperando = operadorPos + 1;
        op = obtenerOperacion(partes[i], inicioOperando, finalOperando);
        if (op == 0) {
            valorActual = Va;  // No hay más operadores
            break;
        }
    }
    System.out.println("valorActual:"+valorActual);
    // Actualiza la celda con el nuevo valor
    model.setValueAt(valorActual, fila, 4);
}

private int buscarFila(String parte) {
    String lineaLimpia = parte.trim();
    int igualIndex = lineaLimpia.indexOf('=');

    // 1. Si la línea no es una asignación, salir.
    if (igualIndex == -1) {
        return -1;
    }

    // 2. Extraer el nombre de la variable (lo que está a la izquierda del '=')
    String nombreVarAsignada = lineaLimpia.substring(0, igualIndex).trim();

    // 3. Buscar ese nombre exacto en la columna de nombres (índice 3)
    for (int fila = 0; fila < model.getRowCount(); fila++) {
        String nombreEnTabla = model.getValueAt(fila, 3).toString();
        
        if (nombreEnTabla.equals(nombreVarAsignada)) {
            return fila; // Retorna el índice de la fila a actualizar
        }
    }
    
    return -1; // No se encontró la variable (no declarada)
}

private String extraerOperando(String parte, int inicio, int fin) {
    int operadorPos = obtenerPosicionOperador(parte, inicio, fin);
    String operando;

    if (operadorPos == -1) {
        // Si no hay operador
        operando = parte.substring(inicio, fin).trim();
    } else {
        // Si se encontró el operador
        operando = parte.substring(inicio, operadorPos).trim();
    }

    // Si el operando es un string (entre comillas)
    if (operando.startsWith("\"") && operando.endsWith("\"")) {
        // CORRECCIÓN: Usar substring(1, length() - 1) para remover la primera y la última comilla.
        if (operando.length() > 1) {
            return operando.substring(1, operando.length() - 1);
        }
        return ""; // Caso de string vacío ""
    }
    return operando;
}

private int obtenerOperacion(String parte, int inicio, int fin) {
    for (int j = inicio; j < fin; j++) {
        char c = parte.charAt(j);
        if (c == '+') return 1;
        if (c == '-') return 2;
        if (c == '*') return 3;
        if (c == '/') return 4;
    }
    return 0;  // No se encontró operador
}

private int obtenerPosicionOperador(String parte, int inicio, int fin) {
    for (int j = inicio; j < fin; j++) {
        char c = parte.charAt(j);
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return j;
        }
    }
    return -1;  // No se encontró operador
}

private String obtenerValorTabla(String variable) {
    for (int fila = 0; fila < model.getRowCount(); fila++) {
        if (model.getValueAt(fila, 3).toString().equals(variable)) {
            return model.getValueAt(fila, 4).toString();
        }
    }
    return variable;
}

private String realizarOperacion(int op, String Va, String Va2) {
    // Verifica si ambos valores son números decimales o enteros
    if (esNumero(Va) && esNumero(Va2)) {
        // Intentar parsear como Double para permitir decimales
        double num1 = Double.parseDouble(Va);
        double num2 = Double.parseDouble(Va2);

        double resultado = 0;

        // Realiza la operación dependiendo del valor de 'op'
        switch (op) {
            case 1: // Suma
                resultado = num1 + num2;
                break;
            case 2: // Resta
                resultado = num1 - num2;
                break;
            case 3: // Multiplicación
                resultado = num1 * num2;
                break;
            case 4: // División
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    return "Error: División por cero";
                }
                break;
        }
        // Si ambos números son enteros, retornar resultado como entero
        if (esEntero(resultado)) {
            return String.valueOf((int)resultado);
        } else {
            // Si hay decimales, retornar como double
            return String.valueOf(resultado);
        }

    } else if (op == 1) {
        // Si no son números, concatenar strings (solo para suma)
        return Va + Va2;
    }
    return Va;  // Si no es una operación válida, retorna el primer valor
}

// Método auxiliar para verificar si un número es entero
private boolean esEntero(double numero) {
    return numero == Math.floor(numero) && !Double.isInfinite(numero);
}


private boolean esNumero(String valor) {
    try {
        Double.parseDouble(valor); // Permite tanto enteros como decimales
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

// Función para buscar un símbolo por nombre (clave para la redefinición y el chequeo de uso)
private Simbolo buscarSimbolo(String nombre) {
for (Simbolo s : tablaSimbolos) {
        if (s.nombre.equals(nombre)) { 
            return s;
        }
    }
    return null;
}
// Función para leer todo el archivo
private String leerArchivo(String nombreArchivo) {
    try {
        // Opción 1: Usar la ruta relativa (si el archivo está en la raíz del proyecto)
        return new String(Files.readAllBytes(Paths.get(nombreArchivo)), StandardCharsets.UTF_8);
    } catch (IOException e) {    
        // Opción 2: Intentar leer desde el directorio 'src' o 'build', si es la estructura de tu IDE.
        try {
            Output.append("ERROR: Intento de lectura fallido en la ruta directa.\n");           
            Output.append("Revisa si el archivo '" + nombreArchivo + "' está cerrado por otro proceso o no existe.\n");
            // Mantén la salida original del error para diagnóstico
            Output.append("ERROR DE E/S ORIGINAL: " + e.getMessage() + "\n");
            return ""; // Devolvemos vacío para el chequeo de compilación.
        } catch (Exception ex) {
            return "";
        }
    }
}
// Función para poblar la JTable de tu GUI
private void mostrarTablaEnGUI() {
    DefaultTableModel modelo = new DefaultTableModel(
        new String[]{"NO.", "ID", "Línea", "TipoDeDato", "Valor", "Clase"}, 
        0 // 0 filas iniciales
    );
    
    for (Simbolo s : tablaSimbolos) {
        modelo.addRow(new Object[]{
            s.id, 
            s.nombre, 
            s.linea, 
            s.tipoDato, 
            s.valor, 
            s.clase
        });
    }
    // Asegúrate de que tu componente JTable se llame 'Tabla'
    Tabla.setModel(modelo);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AL;
    private javax.swing.JButton AnalizarLex;
    private javax.swing.JButton AnalizarSem;
    private javax.swing.JButton AnalizarSint;
    private javax.swing.JTextArea CC;
    private javax.swing.JTextArea CF;
    private javax.swing.JButton CrearClass;
    private javax.swing.JButton CrearTabla;
    private javax.swing.JButton Ejecutar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton LimpiarTabla;
    private javax.swing.JTextArea Output;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton abrir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton quitar;
    private javax.swing.JTextField ruta;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
// Método que evalúa una expresión simple binaria (ID/Literal OP ID/Literal)
private String evaluarExpresion(String idOp1, String operador, String idOp2) {
    try {
        String valorStr1 = null;
        String valorStr2 = null;

        // Obtener valor 1: Si es literal ("..."), lo usa; si es ID, busca en la tabla.
if (idOp1.startsWith("\"") || idOp1.matches("-?\\d+(\\.\\d+)?")) { // <--- CHEQUEA SI ES NUMÉRICO
    valorStr1 = idOp1;
} else {
    Simbolo s = buscarSimbolo(idOp1);
    if (s == null || s.valor == null) throw new NullPointerException("Valor no encontrado para: " + idOp1);
    valorStr1 = s.valor; 
}

        // Obtener valor 2: Si es literal ("..."), lo usa; si es ID, busca en la tabla.
if (idOp2.startsWith("\"") || idOp2.matches("-?\\d+(\\.\\d+)?")) { // Maneja literales String o numéricos
    valorStr2 = idOp2;
} else {
    // --- ESTA ES LA CORRECCIÓN CLAVE PARA idOp2 ---
    Simbolo s = buscarSimbolo(idOp2); 
    if (s == null || s.valor == null) throw new NullPointerException("Valor no encontrado para: " + idOp2);
    valorStr2 = s.valor;
}
            {
            valorStr2 = buscarSimbolo(idOp2).valor;
        }

        // --- 1. Lógica de Concatenación (Strings) ---
        if (valorStr1.startsWith("\"") || valorStr2.startsWith("\"")) {
             if (operador.equals("+")) {
                 String v1 = valorStr1.replace("\"", "");
                 String v2 = valorStr2.replace("\"", "");
                 return "\"" + v1 + v2 + "\""; // Devuelve la cadena concatenada con comillas
             }
             // Si hay otro operador (-, *, /) con Strings, devolvemos null (Error semántico de tipo)
             return null; 
        }

        // --- 2. Lógica Aritmética para Enteros (int) ---
valorStr1 = valorStr1.trim().replace("\"", "");
valorStr2 = valorStr2.trim().replace("\"", "");

int val1 = Integer.parseInt(valorStr1); // <-- Esto ya no debería fallar por espacios
int val2 = Integer.parseInt(valorStr2); // <-- Esto ya no debería fallar por espacios

        switch (operador) {
            case "+": return String.valueOf(val1 + val2);
            case "-": return String.valueOf(val1 - val2); // ¡Aquí se calcula 20 - 4 = 16!
            case "*": return String.valueOf(val1 * val2);
            case "/": 
                if (val2 == 0) { // Prevención de división por cero
                    Output.append("Error Semántico: División por cero detectada.\n");
                    return null;
                }
                return String.valueOf(val1 / val2);
            default: return null;
        }
    } catch (NullPointerException e) {
        // Si buscarSimbolo devuelve null
        Output.append("Error interno semántico: Valor de variable no inicializado o no encontrado durante la evaluación.\n");
        return null; 
    } catch (NumberFormatException e) {
        return null;
    }
}
private String evaluarCastingExplicito(String expresion) {
    // 1. Regex para extraer el tipo y la variable: (tipo)variable
    // Ej: "(int)pi" -> Grupo 1: "int", Grupo 2: "pi"
    Pattern castingPattern = Pattern.compile("\\s*\\((\\w+)\\)\\s*([a-zA-Z_$][a-zA-Z0-9_$]*)\\s*");
    Matcher m = castingPattern.matcher(expresion.trim());

    if (m.find()) {
        String tipoCasting = m.group(1).trim(); // "int"
        String idFuente = m.group(2).trim();   // "pi"

        Simbolo sFuente = buscarSimbolo(idFuente);
        
        if (sFuente == null || sFuente.valor == null) {
            // Error Semántico: Variable fuente no declarada o sin valor
            return null;
        }

        String valorFuente = sFuente.valor.replace("\"", ""); // Quitar comillas si es String

        try {
            if (tipoCasting.equalsIgnoreCase("int")) {
                // Conversión: double/float a int (Trunca el decimal)
                double valorDouble = Double.parseDouble(valorFuente);
                return String.valueOf((int) valorDouble); // -> "3"
            } 
            // Podrías agregar lógica para otros castings (ej: (double)int)
            // if (tipoCasting.equalsIgnoreCase("double")) { ... }
            
            // Si el casting no es soportado (ej: (String)int), devuelve null para un error.
            return null; 
            
        } catch (NumberFormatException e) {
            // Error Semántico: Intentar castear un valor no numérico a int
            return null;
        }
    }
    return null;
}
}
