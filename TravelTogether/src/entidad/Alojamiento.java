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
public class Alojamiento {

    private int codAlojam;
    private String nombre;
    private int capacidad;
    private int nroAmbientes;
    private int camas;
    private int banios;
    private double precioNoche;
    private String tipo;
//    Habitacion hab1;
//    Habitacion hab2;
//    Habitacion hab3;
    private int cantHabitacones;
    private String nbreCiudad;
    private boolean estado; // opcional
    
    public Alojamiento() {}

    public Alojamiento(int codAlojam, String nombre, int capacidad, int nroAmbientes, int camas, int banios, double precioNoche, String tipo, String nbreCiudad, boolean  estado) {
        this.codAlojam = codAlojam;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.nroAmbientes = nroAmbientes;
        this.camas = camas;
        this.banios = banios;
        this.precioNoche = precioNoche;
        this.tipo = tipo;
        this.nbreCiudad = nbreCiudad;
        this.estado = estado;
    }

    public int getCantHabitacones() {
        return cantHabitacones;
    }

    public void setCantHabitacones(int cantHabitacones) {
        this.cantHabitacones = cantHabitacones;
    }
   
    
    
    public int getCodAlojam() {
        return codAlojam;
    }

    public void setCodAlojam(int codAlojam) {
        this.codAlojam = codAlojam;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNroAmbientes() {
        return nroAmbientes;
    }

    public void setNroAmbientes(int nroAmbientes) {
        this.nroAmbientes = nroAmbientes;
    }

    public int getCamas() {
        return camas;
    }

    public void setCamas(int camas) {
        this.camas = camas;
    }

    public int getBanios() {
        return banios;
    }

    public void setBanios(int banios) {
        this.banios = banios;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNbreCiudad(String nbreCiudad) {
        this.nbreCiudad = nbreCiudad;
    }

    public String getNbreCiudad() {
        return nbreCiudad;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
     
    public boolean getEstado() 
    {
        return estado;
    }

    @Override
    public String toString() {
        return codAlojam + ", " + nombre + ", " + capacidad + ", " + nroAmbientes + ", " + camas + ", " + banios + ", " + precioNoche + ", " + tipo;
    }
    
    
}
