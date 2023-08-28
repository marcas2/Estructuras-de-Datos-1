/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laboratorio_1;
/**
 * Importar librerias
 */
import java.util.ArrayList;
import java.util.Scanner;
import Mundo.Alumno;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author maria
 */

public class Laboratorio_1 {

    public static void main(String[] args) throws FileNotFoundException {
        /**
         * Abrir Scanner
         */
        Scanner sc = new Scanner(System.in);
        
        /**
         * Bandera que permite terminar el programa
         */
               
        boolean activo = true;
        /**
         * Crear Array para guardar la información 
         */
        ArrayList<Alumno> misAlumnos = new ArrayList<Alumno>();
        
        /**
         * Llamamos el metodo Leer Archivo para el manejo de pesistencia 
         */
        
        leerArchivo(misAlumnos);
        
        /**
         *  Ciclo para mostrar el menu
         */
        do{ 
            /**
             * Menu Principal
             */
            
            System.out.println("========================");
            System.out.println("    Menu de opciones");
            System.out.println("========================");
            System.out.println("");
            System.out.println("1) Insertar alumno");
            System.out.println("2) Eliminar alumno");
            System.out.println("3) Modificar alumno");
            System.out.println("4) Consultar alumno");
            System.out.println("5) Mostrar listado alumnos");
            System.out.println("6) Terminar programa");
            System.out.println("========================");
            /**
             * Scanner para la opcion del menu
             */
            int opcion = sc.nextInt();

            /**
             * Switch para las opciones del menu seleccionadas
             */
                    
        switch(opcion){
            
            case 1:
                System.out.println("========================");
                System.out.println("     Insertar alumno    ");
                System.out.println("========================");
                
                /**
                 * Llamamos el metodo agregar alumno 
                 *@param sc
                 *@param alumnos 
                 */
                
                agregarAlumno(sc, misAlumnos) ;
                
                break;

            case 2:
                System.out.println("========================");
                System.out.println("     Eliminar alumno    ");
                System.out.println("========================");
                
                /**
                 * Llamamos el metodo eliminar alumno 
                 *@param sc
                 *@param alumnos 
                 */
                
                eliminarAlumno(sc,misAlumnos);

                break;
                
            case 3:
                System.out.println("========================");
                System.out.println("    Modificar alumno    ");
                System.out.println("========================");
                                                
                /**
                 * Llamamos el metodo modificar alumno 
                 *@param sc
                 *@param alumnos 
                 */
                
                actualizarAlumno(sc,misAlumnos);

                break;
                
            case 4:

                System.out.println("========================");
                System.out.println("    Consultar alumno    ");
                System.out.println("========================");
                
                /**
                 * Llamamos el metodo consultar alumno 
                 *@param sc
                 *@param alumnos 
                 */
                
                consultarAlumno(sc,misAlumnos);

                break;
                
            case 5: 
                 System.out.println("========================");
                System.out.println("    Consultar alumnos    ");
                System.out.println("========================");
                
                /**
                 * Llamamos el metodo consultar alumno 
                 *@param sc
                 *@param alumnos 
                 */
                
                consultarAlumnos(sc,misAlumnos);
                break;
            case 6:
                 
                System.out.println("========================");
                System.out.println("    Terminar programa   ");
                System.out.println("========================");
                System.out.println();
                System.out.println("Realizado por: María Casanova");
                /**
                 * Finaliza el estado de la variable "activa" a falso
                */  
                activo=false;
                break;   
        }
        
    }while (activo);
       /**
        * Cerramos el Scanner
        */
        sc.close();
    
    }
    
    /**
     * Agregar Alumno
     * @param sc
     * @param alumnos
     * @throws FileNotFoundException 
     */
    
    private static void agregarAlumno(Scanner sc, ArrayList<Alumno> alumnos) throws FileNotFoundException {
        /**
         * Comprobamos si la cedula que ingresa el usuario está repetida
         * Utilizamos un ciclo While para que pida una cedula diferente en caso de estar repetida
         */
        while (true) {
            
        /**
         * Se recibe la cedula
         */
        
        System.out.println("Introduce la cedula del alumno: ");
        String cedula = sc.next();
        /**
         * Bandera para verificar la cedula
         */
        boolean cedulaExistente = false;
        /**
         * Se verifica la cedula con los datos ya existentes
         */
        for (Alumno alumno : alumnos) {
            if (alumno.getCedula().equals(cedula)) {
                cedulaExistente = true;
                System.out.println("Ya existe un alumno con esta cedula.");
                break;
            }
        }
        /**
         * Se piden los demás datos
         */
        if (!cedulaExistente) {
            // Recibir el nombre del usuario
            System.out.println("Introduce el nombre del alumno: ");
            String nombre = sc.next();

            // Recibir el apellido del usuario
            System.out.println("Introduce el apellido del alumno: ");
            String apellido = sc.next();

            // Recibir el semestre del usuario
            System.out.println("Introduce el semestre del alumno: ");
            String semestre = sc.next();

            // Recibir el correo del usuario
            System.out.println("Introduce el correo del alumno: ");
            String correo = sc.next();

            // Recibir el celular del usuario
            System.out.println("Introduce el celular del alumno: ");
            String celular = sc.next();

            /**
             * Se crea el objeto para guardar la informacion de cada alumno
             */
            Alumno a = new Alumno();
            a.setCedula(cedula);
            a.setNombre(nombre);
            a.setApellido(apellido);
            a.setSemestre(semestre);
            a.setCorreo(correo);
            a.setCelular(celular);

            /**
             * Agregamos el valor del objeto al ArrayList
             */
            alumnos.add(a);

            /**
             * Bandera para informar al usuario el estado del sistema
             */
            System.out.println("Alumno añadido correctamente.");
            /**
             * Llamamos el metodo para editar el archivo
             */
            escribirArchivoUsuario(alumnos);

            break; 
        }
    }
}

     
    /**
     * Eliminar Alumno
     * @param sc
     * @param alumnos
     * @throws FileNotFoundException 
     */
    
    private static void eliminarAlumno(Scanner sc, ArrayList<Alumno> alumnos) throws FileNotFoundException{
        
        /**
         * Se pide la cedula para consultar al estudiante
         */
        System.out.println("Digita la cedula del estudiante que desees eliminar.");
        String cedulaEliminar = sc.next();
        
        /**
         * Bandera para mostrar mensaje al usuario en caso de no encontrar coincidencias
         */
        
        boolean encontrar=false;
        
        /**
         * Uso de ForEach 
         * Tipo= Alumno. Variable = alumno. Coleccion= (lista) alumnos 
         * Basado: https://oregoom.com/java/for-each/
         */
        
        for (Alumno alumno:alumnos){
            
            /**
             * Analizar con IF cada elemento y ver si coinciden con la cedula digitada. 
             */
            
            if (alumno.getCedula().equals(cedulaEliminar)){
                if (alumno.getCedula() != null){
                /**
                 * Se usa la funcion REMOVE 
                 * Basado: https://www.arquitecturajava.com/java-arraylist-remove-y-sus-opciones/
                 */
                
                alumnos.remove(alumno);
                
                /**
                 * Informamos el estado del sistema
                 */
                
                System.out.print("Se ha eliminado el alumno correctamente.");
                
                /**
                 * Bandera en TRUE para no mostrar mensaje de error al usuario
                 */
                
                encontrar=true;
                
                break;
            }
            }
        } 
        
        /**
         * Editar el archivo txt 
         */
        
        escribirArchivoUsuario( alumnos);
        /**
         * Mensaje en caso de no encontrar coincidencias
         */
        if (!encontrar) System.out.println("No hay ningun estudiante que coincida con la cedula digitada.");
        
    }
    
    /**
     * Actualizar alumno
     * @param sc
     * @param alumnos
     * @throws FileNotFoundException 
     */
    
    private static void actualizarAlumno(Scanner sc, ArrayList<Alumno> alumnos ) throws FileNotFoundException{
        
        /**
         * Se pide la cedula para consultar al estudiante
         */
        System.out.println("Digita la cedula del estudiante que desees modificar.");
        String cedulaModificar = sc.next();
                
        /**
         * Bandera para mostrar mensaje al usuario en caso de no encontrar coincidencias
         */
        
        boolean encontrar=false;
        
        /**
         * Uso de ForEach 
         */
        
        for (Alumno alumno:alumnos){
            
             /**
             * Analizar con IF cada elemento y ver si coinciden con la cedula digitada. 
             */
             
            if (alumno.getCedula().equals(cedulaModificar)){
                
                //Recibir la nueva cedula del usuario
                System.out.println("Introduce la nueva cedula del alumno: ");
                String cedula = sc.next();

                //Recibir el nuevo nombre del usuario
                System.out.println("Introduce el nuevo nombre del alumno: ");
                String nombre = sc.next();

                //Recibir el nuevo apellido del usuario
                System.out.println("Introduce el nuevo apellido del alumno: ");
                String apellido = sc.next();

                //Recibir el nuevo semestre del usuario
                System.out.println("Introduce el nuevo semestre del alumno: ");
                String semestre = sc.next();

                //Recibir el nuevo correo del usuario
                System.out.println("Introduce el nuevo correo del alumno: ");
                String correo = sc.next();

                //Recibir el nuevo celular del usuario
                System.out.println("Introduce el nuevo celular del alumno: ");
                String celular = sc.next();
                
                /**
                 * Modificar los datos
                 */
                
                alumno.setCedula(cedula);
                alumno.setNombre(nombre);
                alumno.setApellido(apellido);
                alumno.setSemestre(semestre);
                alumno.setCorreo(correo);
                alumno.setCelular(celular);
                
                /**
                 * Informamos el estado del sistema 
                 */
                
                System.out.print("Se ha modificado el alumno correctamente.");
                /**
                 * Bandera en TRUE para no mostrar mensaje de error al usuario
                 */
                encontrar=true;
                /**
                 * Se edita el archivo txt, llamando el metodo para excribir en el archivo txt
                 */
                escribirArchivoUsuario( alumnos);
                break;
            }
        }
        /**
         * Mensaje en caso de no encontrar coincidencias
         */
        
        if (!encontrar) System.out.println("No hay ningun estudiante que coincida con la cedula digitada.");
    }
    
    /**
     * Consultar Alumno
     * @param sc
     * @param alumnos
     * @throws FileNotFoundException 
     */
    
    private static void consultarAlumno(Scanner sc, ArrayList<Alumno> alumnos) throws FileNotFoundException{
        
        /**
         * Se pide la cedula para consultar al estudiante
         */
        System.out.println("Digita la cedula del estudiante que desees consultar.");
        String cedulaConsultar = sc.next();      
        /**
         * Bandera para mostrar mensaje al usuario en caso de no encontrar coincidencias
         */
        boolean encontrar=false;
        /**
         * Uso de ForEach 
         */
        for (Alumno alumno:alumnos){
            /**
             * Analizar con IF cada elemento y ver si coinciden con la cedula digitada. 
             */
            if (alumno.getCedula().equals(cedulaConsultar)){
                /**
                 * Usar funciones GET para mostrar los datos
                 */
                System.out.println("NOMBRE: "+ alumno.getNombre());
                System.out.println("APELLIDO: "+ alumno.getApellido());
                System.out.println("CELULAR: "+ alumno.getCelular());
                System.out.println("CORREO: "+ alumno.getCorreo());
                System.out.println("SEMESTRE: "+ alumno.getSemestre());
                /**
                 * Bandera en TRUE para no mostrar mensaje de error al usuario
                 */
                encontrar=true;
                break;
            }
        }
        /**
         * Mensaje en caso de no encontrar coincidencias
         */
        
        if (!encontrar) System.out.println("No hay ningun estudiante que coincida con la cedula digitada.");
    }
    
    /**
     * Consultar Alumnos (Listado)
     * @param sc
     * @param alumnos
     * @throws FileNotFoundException 
     */
    
    private static void consultarAlumnos(Scanner sc, ArrayList<Alumno> alumnos) throws FileNotFoundException{
        /**
         * Ciclo for para recorres el array list 
         */
        for (Alumno alumno:alumnos){
                /**
                 * Se muestra listado 
                 */
                System.out.println("///////////////////////////////");
                System.out.println("NOMBRE: "+ alumno.getNombre());
                System.out.println("APELLIDO: "+ alumno.getApellido());
                System.out.println("CELULAR: "+ alumno.getCelular());
                System.out.println("CORREO: "+ alumno.getCorreo());
                System.out.println("SEMESTRE: "+ alumno.getSemestre());
                System.out.println("///////////////////////////////");
   
            }
        }
    /**
     * Escribir archivo txt para mostrar el usuario 
     * @param alumnos 
     */
    
    public static void escribirArchivoUsuario(ArrayList<Alumno> alumnos) {
        /**
         * Se crea el archivo
         */
        File archivo = new File("./data/reporteU.txt");
        /**
         * Bloque try-catch 
         */
        try {
            /**
             * Creamos la pluma y escribimos
             */
            PrintWriter pluma = new PrintWriter(archivo);
            pluma.println("======================");
            pluma.println(" Reporte estudiantes ");
            pluma.println("======================");
            /**
             * Con un bucle for y con la pluma se escriben los datos
             */
            for (Alumno a : alumnos) {
                pluma.println("Cedula: " + a.getCedula()+ "\n"+
                "Nombre: " + a.getNombre()+ "\n"+
                "Apellido: " + a.getApellido()+ "\n"+
                "Celular: " + a.getCelular()+ "\n"+
                "Correo: " + a.getCorreo()+ "\n"+
                "Semestre: " + a.getSemestre()+ "\n"+
                "======================");
            }
            /**
             * Llamamos el metodo para escribir los archivos de persistencia para que este 
             * se actualice a la vez
             */
            escribirArchivoPersistencia (alumnos);
            
            /**
             * Cerramos la pluma
             */
            pluma.close();
       
        } 
        catch (FileNotFoundException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    /**
     * Escribir archivo txt para persistencia
     * @param alumnos 
     */
    
    public static void escribirArchivoPersistencia(ArrayList<Alumno> alumnos) {
        /**
         * Se crea el archivo
         */
        File archivo = new File("./data/reporteP.txt");
        
        /**
         * Bloque try-catch 
         */
       try {
            /**
             * Creamos la pluma 
             */
            PrintWriter pluma = new PrintWriter(archivo);

            /**
             * Con el ciclo for se escribe la informacion separada por comas. 
             */
            for (Alumno a : alumnos) {
                
                pluma.println( a.getCedula()+ ","+
                a.getNombre()+ ","+
                a.getApellido()+ ","+
                a.getCelular()+ ","+
                a.getCorreo()+ ","+
                a.getSemestre());
                
            }
            /**
             * Cerramos la pluma
             */
            pluma.close();
       
        } 
        catch (FileNotFoundException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    /**
     * Leer archivo txt para manejo de persistencia
     * @param alumnos
     * @throws FileNotFoundException 
     */
    
    public static void leerArchivo (ArrayList<Alumno> alumnos) throws FileNotFoundException{
        /**
         *  Se especifica la ruta del archivo a leer
         */
        File archivo = new File("./data/reporteP.txt");
        /**
         * Bloque try-catch
         */
        try{
            /**
             * Se crea un FileReader para leer el archivo
             */
            FileReader fr= new FileReader (archivo);
            BufferedReader lector = new BufferedReader(fr);
            /**
             * Se lee la primera línea del archivo
             */
            String linea=lector.readLine();
            /**
             * Con el bucle while se recorre el archivo línea por línea
             */
            while(linea!=null){
                /**
                 * Se dividen los datos de la línea en un arreglo utilizando la coma como separador
                 */
                String [] datos = linea.split(",");
                /**
                 * Asignamos los valores
                 */
                String cedula= datos[0].trim();
                String nombre=datos[1].trim();
                String apellido=datos[2].trim();
                String celular=datos[3].trim();
                String correo =datos[4].trim();
                String semestre=datos[5].trim();
                /**
                 * Creamos un alumno con la informacion obtenida y se agrega a la lista de alumnos
                 */
                Alumno a = new Alumno(cedula,nombre, apellido, semestre, correo, celular);
                alumnos.add(a); 
                
                /**
                 * Se lee la siguiente línea del archivo
                 */
                linea =lector.readLine();
                
            }
            /**
             * Se cierran los recursos utilizados para la lectura
             */
            fr.close();
            lector.close();
            
        } catch(IOException e){
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
}
