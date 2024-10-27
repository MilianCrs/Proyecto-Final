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
public class Ciudad {
    
    private int codCiudad;
    private String nombre;
    private String pais;
    private String continente;

    public Ciudad(int codCiudad, String nombre, String pais, String continente) {
        this.codCiudad = codCiudad;
        this.nombre = nombre;
        this.pais = pais;
        this.continente = continente;
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

    public void setContinente(String continente) {
        this.continente = continente;
    }

    @Override
    public String toString() {
        return codCiudad + ", " + nombre + ", " + pais + ", " + continente;
    }
    
    
    
    
    
}
