package persistencia;

import entidad.Alojamiento;
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

public class AlojamientoData {
    
    Connection con = null;

    public AlojamientoData() {
        con = Conexion.getConexion();
    }
    
    public void guardarAlojamiento(Alojamiento alo){
        
        String sql = "INSERT INTO alojamiento (codAlojam, nombre, capacidad, nroAmbientes, camas, banios, precioNoche, tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, alo.getCodAlojam());
            ps.setString(2, alo.getNombre());
            ps.setInt(3, alo.getCapacidad());
            ps.setInt(4, alo.getNroAmbientes());
            ps.setString(5, alo.getCamas());
            ps.setInt(6, alo.getBanios());
            ps.setDouble(7, alo.getPrecioNoche());
            ps.setString(8, alo.getTipo());
            
            ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento");
        }
    }
    
    public Alojamiento buscarAlojamiento(int cod){
        Alojamiento alo = null;
        String sql = "SELECT * FROM alojamiento WHERE codAlojam = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                alo = new Alojamiento();
                alo.setCodAlojam(cod);
                alo.setNombre(rs.getString("nombre"));
                alo.setCapacidad(rs.getInt("capacidad"));
                alo.setNroAmbientes(rs.getInt("nroAmbientes"));
                alo.setCamas(rs.getString("camas"));
                alo.setBanios(rs.getInt("banios"));
                alo.setPrecioNoche(rs.getDouble("precioNoche"));
                alo.setTipo(rs.getString("tipo"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alojamiento");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento");
        }
        
        return alo;
    }
    
    public void modificarAlojamiento(Alojamiento alo){
        
        String sql = "UPDATE alojamiento SET codAlojam = ?, nombre = ?, capacidad = ? ,nroAmbientes = ? ,camas = ? ,banios = ? ,precioNoche = ? ,tipo = ? WHERE codAlojam = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, alo.getCodAlojam());
            ps.setString(2, alo.getNombre());
            ps.setInt(3, alo.getCapacidad());
            ps.setInt(4, alo.getNroAmbientes());
            ps.setString(5, alo.getCamas());
            ps.setInt(6, alo.getBanios());
            ps.setDouble(7, alo.getPrecioNoche());
            ps.setString(8, alo.getTipo());
            ps.setInt(9, alo.getCodAlojam());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alojamiento modificado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "El Alojamiento no existe");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento");
        }
        
    }
    
    public void borrarAlojamiento(int cod){
        
        String sql = "DELETE FROM alojamiento WHERE codAlojam = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alojamiento Borrado Exitosamente");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento");
        }
        
    }
    
    public List<Alojamiento> listarAlojamientos(){
        
        List<Alojamiento> alojamientos = new ArrayList();
        
        String sql = "SELECT * FROM alojamiento";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Alojamiento alo = new Alojamiento();
                alo.setCodAlojam(rs.getInt("codAlojam"));
                alo.setNombre(rs.getString("nombre"));
                alo.setCapacidad(rs.getInt("capacidad"));
                alo.setNroAmbientes(rs.getInt("nroAmbientes"));
                alo.setCamas(rs.getString("camas"));
                alo.setBanios(rs.getInt("banios"));
                alo.setPrecioNoche(rs.getDouble("precioNoche"));
                alo.setTipo(rs.getString("tipo"));
                
                alojamientos.add(alo);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento");
        }
        
        return alojamientos;
    }
    
    public List listarAlojamientosXCiudad(Ciudad ciudad){
        List alojamientos = new ArrayList();
        
        String sql = "SELECT * FROM alojamiento WHERE ciudad = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ciudad.getNombre());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Alojamiento alo = new Alojamiento();
                alo.setCodAlojam(rs.getInt("codAlojam"));
                alo.setNombre(rs.getString("nombre"));
                alo.setCapacidad(rs.getInt("capacidad"));
                alo.setNroAmbientes(rs.getInt("nroAmbientes"));
                alo.setCamas(rs.getString("camas"));
                alo.setBanios(rs.getInt("banios"));
                alo.setPrecioNoche(rs.getDouble("precioNoche"));
                alo.setTipo(rs.getString("tipo"));
                
                alojamientos.add(alo);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento");
        }
        
        return alojamientos;
    }
    
}
