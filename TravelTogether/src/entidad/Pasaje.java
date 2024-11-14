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

    public Pasaje(Integer codPasaje, LocalDate fechaHora, Ciudad origen, Ciudad destino, int asiento, String transporte) {
        this.codPasaje = codPasaje;
        this.fechaHora = fechaHora;
        this.origen = origen;
        this.destino = destino;
        this.asiento = asiento;
        this.transporte = transporte;
    }

    // Getters y Setters
    public Integer getCodPasaje() {
        return codPasaje;
    }

    public void setCodPasaje(Integer codPasaje) {
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

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }
    
    

    @Override
    public String toString() {
        return codPasaje + ", " + fechaHora + ", " + origen + ", " + destino + ", " + asiento + ", " + transporte;
    }
    
    
    
}

