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
    private String camas;
    private int banios;
    private double precioNoche;
    private String tipo;
    Habitacion hab1;
    Habitacion hab2;
    Habitacion hab3;
    Ciudad ciudad;

    
    public Alojamiento() {}

    public Alojamiento(int codAlojam, String nombre, int capacidad, int nroAmbientes, String camas, int banios, double precioNoche, String tipo, Ciudad ciudad) {
        this.codAlojam = codAlojam;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.nroAmbientes = nroAmbientes;
        this.camas = camas;
        this.banios = banios;
        this.precioNoche = precioNoche;
        this.tipo = tipo;
        this.ciudad = ciudad;
    }

    public Alojamiento(int codAlojam, String nombre, int capacidad, int nroAmbientes, String camas, int banios, double precioNoche, String tipo, Habitacion hab1, Habitacion hab2, Habitacion hab3, Ciudad ciudad) {
        this.codAlojam = codAlojam;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.nroAmbientes = nroAmbientes;
        this.camas = camas;
        this.banios = banios;
        this.precioNoche = precioNoche;
        this.tipo = tipo;
        this.hab1 = hab1;
        this.hab2 = hab2;
        this.hab3 = hab3;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Habitacion getHab1() {
        return hab1;
    }

    public void setHab1(Habitacion hab1) {
        this.hab1 = hab1;
    }

    public Habitacion getHab2() {
        return hab2;
    }

    public void setHab2(Habitacion hab2) {
        this.hab2 = hab2;
    }

    public Habitacion getHab3() {
        return hab3;
    }

    public void setHab3(Habitacion hab3) {
        this.hab3 = hab3;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    

    @Override
    public String toString() {
        return codAlojam + ", " + nombre + ", " + capacidad + ", " + nroAmbientes + ", " + camas + ", " + banios + ", " + precioNoche + ", " + tipo;
    }
    
    
}
