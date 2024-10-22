/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author Celi Leandro
 */
public class Turista 
{
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int telefono;
    private String correo;

    public Turista() {
    }

    public Turista(int dni, String nombre, String apellido, int edad, int telefono, String correo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
    }

   
    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
  
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
