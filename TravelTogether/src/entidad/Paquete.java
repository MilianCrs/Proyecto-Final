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

public class Paquete {

    private int codPaquete;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private Pasaje boleto;
    private Alojamiento estadia;
    private Pension regimen;
    private Ciudad destino;
    private Ciudad origen;
    private float traslados;
    private double montoFinal;

    public Paquete() {}

    public Paquete(int codPaquete, LocalDate fechaIni, LocalDate fechaFin, Pasaje boleto, Alojamiento estadia, Pension regimen, Ciudad destino, Ciudad origen, float traslados, double montoFinal) {
        this.codPaquete = codPaquete;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.boleto = boleto;
        this.estadia = estadia;
        this.regimen = regimen;
        this.destino = destino;
        this.origen = origen;
        this.traslados = traslados;
        this.montoFinal = montoFinal;
    }

    public int getCodPaquete() {
        return codPaquete;
    }

    public void setCodPaquete(int codPaquete) {
        this.codPaquete = codPaquete;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getTraslados() {
        return traslados;
    }

    public void setTraslados(float traslados) {
        this.traslados = traslados;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    @Override
    public String toString() {
        return codPaquete + ", " + fechaIni + ", " + fechaFin + ", " + boleto + ", " + estadia + ", " + regimen + ", " + destino + ", " + origen + ", " + traslados + ", " + montoFinal;
    }
    
    
}
