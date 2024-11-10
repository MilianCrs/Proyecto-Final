package entidad;

import java.time.LocalDate;
import java.time.Month;

public class Compras {
    
    private int idCompra;
    Paquete paquete;
    Ciudad ciudad;
    private String temporada;

    public Compras() {
    }

    public Compras(int idCompra, Paquete paquete, Ciudad ciudad, String temporada) {
        this.idCompra = idCompra;
        this.paquete = paquete;
        this.ciudad = ciudad;
        this.temporada = temporada;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }
    
    public String calcularTemporada(Paquete paquete) {
        String temp = "Baja";
        LocalDate fecha = paquete.getFechaIni();

        if ((fecha.getMonth() == Month.DECEMBER && fecha.getDayOfMonth() >= 15)
                || (fecha.getMonth() == Month.JANUARY)
                || (fecha.getMonth() == Month.FEBRUARY)
                || (fecha.getMonth() == Month.JULY)) {
            temp = "Alta";
        } else if ((fecha.getMonth() == Month.SEPTEMBER)
                || (fecha.getMonth() == Month.OCTOBER)
                || (fecha.getMonth() == Month.NOVEMBER)
                || (fecha.getMonth() == Month.MARCH && fecha.getDayOfMonth() >= 22)
                || (fecha.getMonth() == Month.APRIL && fecha.getDayOfMonth() <= 24)) {
            temp = "Media";
        }
        return temp;
    }

    public Object getCodPaquete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getDestino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getImporte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
