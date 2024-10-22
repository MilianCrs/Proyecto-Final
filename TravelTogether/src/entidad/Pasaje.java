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
public class Pasaje {

    private int codPasaje;
    private String fechaHora;
    private String origen;
    private String destino;
    private int asiento;
    private String transporte;

    public Pasaje() {}

    public Pasaje(int codPasaje, String fechaHora, String origen, String destino, int asiento, String transporte) {
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

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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
}

