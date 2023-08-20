/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laboratorio_1;

import java.util.ArrayList;
import java.util.Scanner;
import Mundo.Alumno;

/**
 *
 * @author maria
 */
public class Laboratorio_1 {

    public static void main(String[] args) {
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
            System.out.println("5) Terminar programa");
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
                
                agregarAlumno(sc, misAlumnos);
                
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
                System.out.println("    Terminar programa   ");
                System.out.println("========================");
                System.out.println();
                System.out.println("Realizado por: Juan Calpa y María Casanova");
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
     */
    
     private static void agregarAlumno(Scanner sc, ArrayList<Alumno> alumnos) {
         
        //Recibir la cedula del usuario
        System.out.println("Introduce la cedula del alumno: ");
        int cedula = sc.nextInt();
               
        //Recibir el nombre del usuario
        System.out.println("Introduce el nombre del alumno: ");
        String nombre = sc.next();
                
        //Recibir el apellido del usuario
        System.out.println("Introduce el apellido del alumno: ");
        String apellido = sc.next();
                
        //Recibir el semestre del usuario
        System.out.println("Introduce el semestre del alumno: ");
        int semestre = sc.nextInt();
                
        //Recibir el correo del usuario
        System.out.println("Introduce el correo del alumno: ");
        String correo = sc.next();
                
        //Recibir el celular del usuario
        System.out.println("Introduce el celular del alumno: ");
        int celular = sc.nextInt();
                
                
        /**
        * Se crea el objeto para guardar la informacion de cada 1
         */
                
        Alumno a = new Alumno();
        a.setCedula(cedula);
        a.setNombre(nombre);
        a.setApellido(apellido);
        a.setSemestre(semestre);
        a.setCorreo(correo);
        a.setCelular(celular);
                
        /**
        * Agregamos el valor del objeto al listArray
        */
                
        alumnos.add(a);
        /**
         * Bandera para informar al usuario el estado del sistema
         */        
        System.out.println("Alumno añadido correctamente.");
     }
     
     /**
      * Eliminar Alumno
      * @param sc
      * @param alumnos 
      */
    
    private static void eliminarAlumno(Scanner sc, ArrayList<Alumno> alumnos){
        
        /**
         * Se pide la cedula para consultar al estudiante
         */
        System.out.println("Digita la cedula del estudiante que desees eliminar.");
        int cedulaEliminar = sc.nextInt();
        
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
            
            if (alumno.getCedula()==cedulaEliminar){
                if (alumno.getCedula() != 0){
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
         * Mensaje en caso de no encontrar coincidencias
         */
        
        if (!encontrar) System.out.println("No hay ningun estudiante que coincida con la cedula digitada.");
    }
    
    /**
     * Actualizar Alumno
     * @param sc
     * @param alumnos 
     */
    
    private static void actualizarAlumno(Scanner sc, ArrayList<Alumno> alumnos ){
        /**
         * Se pide la cedula para consultar al estudiante
         */
        System.out.println("Digita la cedula del estudiante que desees modificar.");
        int cedulaModificar = sc.nextInt();
                
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
             
            if (alumno.getCedula()==cedulaModificar){
                
                //Recibir la nueva cedula del usuario
                System.out.println("Introduce la nueva cedula del alumno: ");
                int cedula = sc.nextInt();

                //Recibir el nuevo nombre del usuario
                System.out.println("Introduce el nuevo nombre del alumno: ");
                String nombre = sc.next();

                //Recibir el nuevo apellido del usuario
                System.out.println("Introduce el nuevo apellido del alumno: ");
                String apellido = sc.next();

                //Recibir el nuevo semestre del usuario
                System.out.println("Introduce el nuevo semestre del alumno: ");
                int semestre = sc.nextInt();

                //Recibir el nuevo correo del usuario
                System.out.println("Introduce el nuevo correo del alumno: ");
                String correo = sc.next();

                //Recibir el nuevo celular del usuario
                System.out.println("Introduce el nuevo celular del alumno: ");
                int celular = sc.nextInt();
                
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
                break;
            }
        }
        /**
         * Mensaje en caso de no encontrar coincidencias
         */
        
        if (!encontrar) System.out.println("No hay ningun estudiante que coincida con la cedula digitada.");
    }
    
    /**
     * Consultar alumno
     * @param sc
     * @param alumnos 
     */
    
    private static void consultarAlumno(Scanner sc, ArrayList<Alumno> alumnos){
        /**
         * Se pide la cedula para consultar al estudiante
         */
        System.out.println("Digita la cedula del estudiante que desees consultar.");
        int cedulaConsultar = sc.nextInt();      
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
            if (alumno.getCedula()==cedulaConsultar){
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
}
