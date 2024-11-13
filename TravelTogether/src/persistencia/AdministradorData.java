package persistencia;

import entidad.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AdministradorData {
    
    Connection con = null;
    
    public AdministradorData(){
        con = Conexion.getConexion();
    }
    
    public void guardarAdministrador(Administrador admin){
        
        String sql = "INSERT INTO administrador (usuario, contraseña) VALUES (?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, admin.getUsuario());
            ps.setInt(2, admin.getContraseña());
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla administrador");
        }
    }
    
    public Administrador buscarAdministrador(String usuario){
        Administrador admin = null;
        String sql = "SELECT * FROM administrador WHERE usuario = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                admin = new Administrador();
                admin.setUsuario(usuario);
                admin.setContraseña(rs.getInt("contraseña"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el administrador");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla administrador");
        }
        return admin;
    }
    
    public void borrarAdmin(String usuario){
        
        String sql = "DELETE FROM administrador WHERE usuario = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó el Administrador.");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla administrador");
        }
    }
    
    public List<Administrador> listarAdmins(){
        List<Administrador> admins = new ArrayList();
        
        String sql = "SELECT * FROM administrador";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Administrador admin = new Administrador();
                admin.setUsuario(rs.getString("usuario"));
                admin.setContraseña(rs.getInt("contraseña"));
                admins.add(admin);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla administrador");
        }
        return admins;
    }
    
}
