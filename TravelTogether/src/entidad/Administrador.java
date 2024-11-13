package entidad;

public class Administrador {
    
    private String usuario;
    private int contraseña;

    public Administrador(String usuario, int contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Administrador() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
