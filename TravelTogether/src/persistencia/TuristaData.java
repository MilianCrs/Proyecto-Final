package persistencia;

import entidad.Turista;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TuristaData {
    
    Connection con = null;

    public TuristaData() {
        con = Conexion.getConexion();
    }
    
    public void cargarTurista(Turista turista){
        
        String sql = "INSERT INTO turista (dni, nombre ,apellido ,edad ,telefono ,correo) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, turista.getDni());
            ps.setString(2, turista.getNombre());
            ps.setString(3, turista.getApellido());
            ps.setInt(4,turista.getEdad());
            ps.setLong(5, turista.getTelefono());
            ps.setString(6, turista.getCorreo());
            
            ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Turista");
        }
        
    }
    
    public void buscarTurista(int dni){
       
        String sql = "SELECT * FROM turista WHERE dni = ? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Turista turista = new Turista();
                turista.setDni(dni);
                turista.setNombre(rs.getString("nombre"));
                turista.setApellido(rs.getString("apellido"));
                turista.setEdad(rs.getInt("edad"));
                turista.setTelefono(rs.getLong("telefono"));
                turista.setCorreo(rs.getString("correo"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el turista");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Turista");
        }
    }
    
    public void modificarTurista(Turista turista){
        
        String sql = "UPDATE turista SET dni = ? nombre = ? apellido = ? edad = ? telefono = ? correo = ? WHERE dni = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, turista.getDni());
            ps.setString(2, turista.getNombre());
            ps.setString(3, turista.getApellido());
            ps.setInt(4,turista.getEdad());
            ps.setLong(5, turista.getTelefono());
            ps.setString(6, turista.getCorreo());
            ps.setInt(7, turista.getDni());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Turista modificado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "El turista no existe");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existe el turista");
        }
    }
    
    public void eliminarTurista(int dni){
        
        String sql = "DELETE FROM turista WHERE dni = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, dni);
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Turista Borrado Exitosamente");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Turista");
        }
    }
    
    public List<Turista> listarTuristas(){
        ArrayList<Turista> turistas = new ArrayList();
        
        String sql = "SELECT * FROM turista";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Turista turista = new Turista();
                
                turista.setDni(rs.getInt("dni"));
                turista.setNombre(rs.getString("nombre"));
                turista.setApellido(rs.getString("apellido"));
                turista.setEdad(rs.getInt("edad"));
                turista.setTelefono(rs.getLong("telefono"));
                turista.setCorreo(rs.getString("correo"));
                
                turistas.add(turista);
                
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Turista");
        }
        return turistas;
    }
    
}
