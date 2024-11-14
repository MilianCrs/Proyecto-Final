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
    private Turista turista;

    public Paquete() {}

    public Paquete(Integer codPaquete, LocalDate fechaIni, LocalDate fechaFin, Pasaje boleto, Alojamiento estadia, Pension regimen, Ciudad destino, Ciudad origen, float traslados, double montoFinal, Turista turista) {
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
        this.turista = turista;
    }

    public Integer getCodPaquete() {
        return codPaquete;
    }

    public void setCodPaquete(Integer codPaquete) {
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

    public Pasaje getBoleto() {
        return boleto;
    }

    public void setBoleto(Pasaje boleto) {
        this.boleto = boleto;
    }

    public Alojamiento getEstadia() {
        return estadia;
    }

    public void setEstadia(Alojamiento estadia) {
        this.estadia = estadia;
    }

    public Pension getRegimen() {
        return regimen;
    }

    public void setRegimen(Pension regimen) {
        this.regimen = regimen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Turista getTurista() {
        return turista;
    }

    public void setTurista(Turista turista) {
        this.turista = turista;
    }

    @Override
    public String toString() {
        return codPaquete + ", " + fechaIni + ", " + fechaFin + ", " + boleto + ", " + estadia + ", " + regimen + ", " + destino + ", " + origen + ", " + traslados + ", " + montoFinal;
    }
    
    
}
