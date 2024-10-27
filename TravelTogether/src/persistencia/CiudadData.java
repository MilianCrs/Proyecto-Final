package persistencia;

import entidad.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CiudadData {
    
    Connection con = null;

    public CiudadData() {
        con = Conexion.getConexion();
    }
    
    public void guardarCiudad(Ciudad ciudad){
        
        String sql = "INSERT INTO ciudad (codCiudad, nombre, pais, continente) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, ciudad.getCodCiudad());
            ps.setString(2, ciudad.getNombre());
            ps.setString(3, ciudad.getPais());
            ps.setString(4, ciudad.getContinente());
            
            ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Ciudad");
        }
    }
    
    public void buscarCiudad(int cod){
        
        String sql = "SELECT * FROM ciudad WHERE codCiudad = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, cod);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setCodCiudad(cod);
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setPais(rs.getString("pais"));
                ciudad.setContinente(rs.getString("continente"));
            } else {
                JOptionPane.showMessageDialog(null,"No existe la ciudad");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Ciudad");
        }
    }
    
    public void modificarCiudad(Ciudad ciudad){
        
        String sql = "UPDATE ciudad SET codCiudad = ? nombre = ? pais = ? continente = ? WHERE codCiudad = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ciudad.getCodCiudad());
            ps.setString(2, ciudad.getNombre());
            ps.setString(3, ciudad.getPais());
            ps.setString(4, ciudad.getContinente());
            ps.setInt(5, ciudad.getCodCiudad());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Ciudad modificada Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "La ciudad no existe");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Ciudad");
        }
    }
    
    public void borrarCiudad(int cod){
        
        String sql = "DELETE FROM ciudad WHERE codCiudad = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Ciudad Borrada Exitosamente");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Ciudad");
        }
    }
    
    public List<Ciudad> listarCiudades(){
        List<Ciudad> ciudades = new ArrayList();
        
        String sql = "SELECT * FROM ciudad";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setCodCiudad(rs.getInt("codCiudad"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setPais(rs.getString("pais"));
                ciudad.setContinente(rs.getString("continente"));
                
                ciudades.add(ciudad);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Ciudad");
        }
        
        return ciudades;
    }
    
}
