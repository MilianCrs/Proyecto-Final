/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.time.LocalDate;


/**
 *
 * @author Celi Leandro
 */
public class Pasaje {

    private int codPasaje;
    private LocalDate fechaHora;
    private Ciudad origen;
    private Ciudad destino;
    private int asiento;
    private String transporte;

    public Pasaje() {}

    public Pasaje(int codPasaje, LocalDate fechaHora, Ciudad origen, Ciudad destino, int asiento, String transporte) {
        this.codPasaje = codPasaje;
        this.fechaHora = fechaHora;
        this.origen = origen;
        this.destino = destino;
        this.asiento = asiento;
        this.transporte = transporte;
    }

    // Getters y Setters
    public int getCodPasaje() {
        return codPasaje;
    }

    public void setCodPasaje(int codPasaje) {
        this.codPasaje = codPasaje;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    @Override
    public String toString() {
        return codPasaje + ", " + fechaHora + ", " + origen + ", " + destino + ", " + asiento + ", " + transporte;
    }
    
    
    
}

