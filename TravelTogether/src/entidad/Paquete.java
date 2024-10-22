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

public class Paquete {

    private int codPaquete;
    private String fechaIni;
    private String fechaFin;
    private double boleto;
    private int estadia;
    private int regimen;
    private int destino;
    private float traslados;
    private double montoFinal;

    public Paquete() {}

    public Paquete(int codPaquete, String fechaIni, String fechaFin, double boleto, int estadia, int regimen, int destino, float traslados, double montoFinal) {
        this.codPaquete = codPaquete;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.boleto = boleto;
        this.estadia = estadia;
        this.regimen = regimen;
        this.destino = destino;
        this.traslados = traslados;
        this.montoFinal = montoFinal;
    }

    public int getCodPaquete() {
        return codPaquete;
    }

    public void setCodPaquete(int codPaquete) {
        this.codPaquete = codPaquete;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getBoleto() {
        return boleto;
    }

    public void setBoleto(double boleto) {
        this.boleto = boleto;
    }

    public int getEstadia() {
        return estadia;
    }

    public void setEstadia(int estadia) {
        this.estadia = estadia;
    }

    public int getRegimen() {
        return regimen;
    }

    public void setRegimen(int regimen) {
        this.regimen = regimen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
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
}
