
package entidad;


public class Habitacion {
        
    private int nroHabitacion;
    private int planta;
    private int numeracion;
    private int cupo;
    private boolean estado;

    public Habitacion(){
    }
    
    public Habitacion(int nroHabitacion, int planta, int numeracion, int cupo, boolean estado) {
        this.nroHabitacion = nroHabitacion;
        this.planta = planta;
        this.numeracion = numeracion;
        this.cupo = cupo;
        this.estado = estado;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Numero de Habitacion: "+nroHabitacion+ 
                ", Planta: "+planta+ 
                ", Numeracion: "+numeracion+ 
                ", Cupo: "+cupo+ 
                ", Estado: " +estado;
    }
    
    
}
