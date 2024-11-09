package persistencia;

import entidad.Ciudad;
import entidad.Pasaje;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PasajeData {
    
    Connection con = null;
    CiudadData cd;
    
    public PasajeData(){
        con = Conexion.getConexion();
        cd = new CiudadData();
    }
    
    public void guardarPasaje(Pasaje pas){
        
        String sql = "INSERT INTO pasaje (fechaHora, origen, destino, asiento, transporte) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setDate(1, Date.valueOf(pas.getFechaHora()));
            ps.setString(2, pas.getOrigen().getNombre());
            ps.setString(3, pas.getDestino().getNombre());
            ps.setInt(4, pas.getAsiento());
            ps.setString(5, pas.getTransporte());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pas.setCodPasaje(rs.getInt(1));   

                JOptionPane.showMessageDialog(null, "Pasaje añadido con éxito.");
                System.out.println("Pasaje añadido con éxito.");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Pasaje");
        }
    }
    
    public Pasaje buscarPasaje(int cod){
        Pasaje pas = null;
        String sql = "SELECT * FROM pasaje WHERE CodPasaje = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                pas = new Pasaje();
                Ciudad origen = cd.buscarCiudad(rs.getString("origen"));
                Ciudad destino = cd.buscarCiudad(rs.getString("destino"));
                pas.setCodPasaje(cod);
                pas.setFechaHora(rs.getDate("fechaHora").toLocalDate());
                pas.setOrigen(origen);
                pas.setDestino(destino);
                pas.setAsiento(rs.getInt("asiento"));
                pas.setTransporte(rs.getString("transporte"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el pasaje");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Pasaje");
        }
        return pas;
    }
    
    public void modificarPasaje(Pasaje pas){
        
        String sql = "UPDATE pasaje SET CodPasaje = ? fechaHora = ? origen = ? destino = ? asiento = ? transporte = ? WHERE CodPasaje = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pas.getCodPasaje());
            ps.setDate(2, Date.valueOf(pas.getFechaHora()));
            ps.setString(3, pas.getOrigen().getNombre());
            ps.setString(4, pas.getDestino().getNombre());
            ps.setInt(5, pas.getAsiento());
            ps.setString(6, pas.getTransporte());
            ps.setInt(7, pas.getCodPasaje());
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Pasaje no existe");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Pasaje");
        }
        
    }
    
    public void borrarPasaje(int cod){
        
        String sql = "DELETE FROM pasaje WHERE CodPasaje = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó el pasaje.");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Pasaje");
        }
        
    }
    
    public List<Pasaje> listarPasajes(){
        List<Pasaje> pasajes = new ArrayList();
        
        String sql = "SELECT * FROM pasaje";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pasaje pas = new Pasaje();
                Ciudad origen = cd.buscarCiudad(rs.getString("origen"));
                Ciudad destino = cd.buscarCiudad(rs.getString("destino"));
                pas.setCodPasaje(rs.getInt("CodPasaje"));
                pas.setFechaHora(rs.getDate("fechaHora").toLocalDate());
                pas.setOrigen(origen);
                pas.setDestino(destino);
                pas.setAsiento(rs.getInt("asiento"));
                pas.setTransporte(rs.getString("transporte"));
                
                pasajes.add(pas);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Pasaje");
        }
        return pasajes;
    }
}
