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
public class Ciudad {

    private int codCiudad;
    private String nombre;
    private String pais;
    private String continente;
    private String rol;

    private LocalDate inicioTem;
    private LocalDate finTem;

    public Ciudad() {
    }

    public Ciudad(int codCiudad, String nombre, String pais, String continente, String rol, LocalDate inicioTem, LocalDate finTem) {
        this.codCiudad = codCiudad;
        this.nombre = nombre;
        this.pais = pais;
        this.continente = continente;
        this.rol = rol;
        this.inicioTem = inicioTem;
        this.finTem = finTem;
    }

    public Ciudad(int codCiudad, String nombre, String pais, String continente) {
        this.codCiudad = codCiudad;
        this.nombre = nombre;
        this.pais = pais;
        this.continente = continente;
    }

    public LocalDate getInicioTem() {
        return inicioTem;
    }

    public LocalDate getFinTem() {
        return finTem;
    }

    public String getRol() {
        return rol;
    }

    public int getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(int codCiudad) {
        this.codCiudad = codCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getContinente() {
        return continente;
    }

    public void setFinTem(LocalDate finTem) {
        this.finTem = finTem;
    }

    public void setInicioTem(LocalDate inicioTem) {
        this.inicioTem = inicioTem;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    @Override
    public String toString() {
        return nombre + ", " + pais;
    }


}
