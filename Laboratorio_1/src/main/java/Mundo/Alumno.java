/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mundo;

/**
 *
 * @author maria
 */

public class Alumno {
    
    /**
     * Declaración de los datos que contiene el Alumno
     */
    
    private int Cedula;
    private String Nombre;
    private String Apellido;
    private int Semestre;
    private String Correo;
    private int Celular;

    public Alumno() {

    }
    
    /**
     * Constructor
     * @param Cedula
     * @param Nombre
     * @param Apellido
     * @param Semestre
     * @param Correo
     * @param Celular 
     */
    
    public Alumno(int Cedula, String Nombre, String Apellido, int Semestre, String Correo, int Celular) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Semestre = Semestre;
        this.Correo = Correo;
        this.Celular = Celular;
    }
    
    /**
     * Declaracion gettes y setter de cada elemento. 
     */
    
    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getSemestre() {
        return Semestre;
    }

    public void setSemestre(int Semestre) {
        this.Semestre = Semestre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getCelular() {
        return Celular;
    }

    public void setCelular(int Celular) {
        this.Celular = Celular;
    }

    
 
    
    
}
