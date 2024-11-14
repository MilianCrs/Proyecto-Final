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
public class Pension {
    
    private int codAdicional;
    private String nombre;
    private double porcentaje;

    public Pension() {
    }

    public Pension(Integer codAdicional, String nombre, double porcentaje) {
        this.codAdicional = codAdicional;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public Integer getCodAdicional() {
        return codAdicional;
    }

    public void setCodAdicional(Integer codAdicional) {
        this.codAdicional = codAdicional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return codAdicional + ", " + nombre + ", " + porcentaje;
    }
    
    
    
    
}
