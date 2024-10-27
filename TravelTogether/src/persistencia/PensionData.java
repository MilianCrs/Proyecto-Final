package persistencia;

import entidad.Pension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PensionData {
    
    Connection con = null;
    
    public PensionData(){
        con = Conexion.getConexion();
    }
    
    public void cargarPension(Pension pension){
        
        String sql = "INSERT INTO pension (codAdicional, nombre, porcentaje) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pension.getCodAdicional());
            ps.setString(2, pension.getNombre());
            ps.setDouble(3, pension.getPorcentaje());
            
            ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Pension");
        }
    }
    
    public Pension buscarPension(int cod){
        Pension pension = null;
        String sql = "SELECT * FROM pension WHERE codAdicional = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                pension = new Pension();
                pension.setCodAdicional(cod);
                pension.setNombre(rs.getString("nombre"));
                pension.setPorcentaje(rs.getDouble("porcentaje"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la Pension");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Pension");
        }
        return pension;
    }
    
    public void modificarPension(Pension pension){
        
        String sql = "UPDATE pension SET codAdicional = ? nombre = ? porcentaje = ? WHERE codAdicional = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pension.getCodAdicional());
            ps.setString(2, pension.getNombre());
            ps.setDouble(3, pension.getPorcentaje());
            ps.setInt(4, pension.getCodAdicional());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Pension modificada Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "La Pension no existe");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Pension");
        }
    }
    
    public void borrarPension(int cod){
        
        String sql = "DELETE FROM pension WHERE codAdicional = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Pension Borrada Exitosamente");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Pension");
        }
        
    }
    
    public List<Pension> listarPensiones(){
        List<Pension> pensiones = new ArrayList();
        
        String sql = "SELECT * FROM pension";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Pension pension = new Pension();
                pension.setCodAdicional(rs.getInt("codAdicional"));
                pension.setNombre(rs.getString("nombre"));
                pension.setPorcentaje(rs.getDouble("porcentaje"));
                
                pensiones.add(pension);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Pension");
        }
        
        return pensiones;
    }
}
