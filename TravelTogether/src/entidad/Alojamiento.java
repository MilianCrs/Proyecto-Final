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
    private Ciudad nombre;
    private int capacidad;
    private int nroAmbientes;
    private String camas;
    private int banios;
    private double precioNoche;
    private String tipo;

    
    public Alojamiento() {}

    public Alojamiento(int codAlojam, Ciudad nombre, int capacidad, int nroAmbientes, String camas, int banios, double precioNoche, String tipo) {
        this.codAlojam = codAlojam;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.nroAmbientes = nroAmbientes;
        this.camas = camas;
        this.banios = banios;
        this.precioNoche = precioNoche;
        this.tipo = tipo;
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

    public String getCamas() {
        return camas;
    }

    public void setCamas(String camas) {
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

    @Override
    public String toString() {
        return codAlojam + ", " + nombre + ", " + capacidad + ", " + nroAmbientes + ", " + camas + ", " + banios + ", " + precioNoche + ", " + tipo;
    }
    
    
}
