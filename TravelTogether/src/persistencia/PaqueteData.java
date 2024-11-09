package persistencia;

import entidad.Paquete;
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

public class PaqueteData {
  
    Connection con = null;
    PasajeData pd = null;
    AlojamientoData ad = null;
    PensionData pendat = null;
    CiudadData cd = null;
    TuristaData td = null;

    public PaqueteData() {
        con = Conexion.getConexion();
    }
    
    public void guardarPaquete(Paquete paquete){
        
        String sql = "INSERT INTO paquete (codPaquete, fechaIni, fechaFin, boleto, estadia, regimen, origen, destino, traslados, montoFinal, dni_turista) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, paquete.getCodPaquete());
            ps.setDate(2, Date.valueOf(paquete.getFechaIni()));
            ps.setDate(3, Date.valueOf(paquete.getFechaFin()));
            ps.setInt(4, paquete.getBoleto().getCodPasaje());
            ps.setInt(5, paquete.getEstadia().getCodAlojam());
            ps.setInt(6, paquete.getRegimen().getCodAdicional());
            ps.setString(7, paquete.getOrigen().getNombre());
            ps.setString(8, paquete.getDestino().getNombre());
            ps.setFloat(9, paquete.getTraslados());
            ps.setDouble(10, paquete.getMontoFinal());
            ps.setInt(11, paquete.getTurista().getDni());
            
            ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla paquete");
        }
    }
    
    public Paquete buscarPaquete(int codPaquete){
        Paquete paquete = null;
        String sql = "SELECT * FROM paquete WHERE codPaquete = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codPaquete);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                paquete = new Paquete();
                paquete.setCodPaquete(codPaquete);
                paquete.setFechaIni(rs.getDate("fechaIni").toLocalDate());
                paquete.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                paquete.setBoleto(pd.buscarPasaje(rs.getInt("boleto")));
                paquete.setEstadia(ad.buscarAlojamiento(rs.getInt("estadia")));
                paquete.setRegimen(pendat.buscarPension(rs.getInt("regimen")));
                paquete.setOrigen(cd.buscarCiudad(rs.getString("origen")));
                paquete.setDestino(cd.buscarCiudad(rs.getString("destino")));
                paquete.setTraslados(rs.getFloat("traslados"));
                paquete.setMontoFinal(rs.getDouble("montoFinal"));
                paquete.setTurista(td.buscarTurista(rs.getInt("dni_turista")));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el paquete");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla paquete");
        }
        return paquete;
    }
    
    public void modificarPaquete(Paquete paquete){
        
        String sql = "UPDATE paquete SET codPaquete = ?, fechaIni = ?, fechaFin = ?, boleto = ?, estadia = ?, regimen = ?, origen = ?, destino = ?, traslados = ?, montoFinal = ?, dni_turista = ? WHERE codPaquete = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, paquete.getCodPaquete());
            ps.setDate(2, Date.valueOf(paquete.getFechaIni()));
            ps.setDate(3, Date.valueOf(paquete.getFechaFin()));
            ps.setInt(4, paquete.getBoleto().getCodPasaje());
            ps.setInt(5, paquete.getEstadia().getCodAlojam());
            ps.setInt(6, paquete.getRegimen().getCodAdicional());
            ps.setString(7, paquete.getOrigen().getNombre());
            ps.setString(8, paquete.getDestino().getNombre());
            ps.setFloat(9, paquete.getTraslados());
            ps.setDouble(10, paquete.getMontoFinal());
            ps.setInt(11, paquete.getTurista().getDni());
            ps.setInt(1, paquete.getCodPaquete());
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Paquete no existe");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla paquete");
        }
    }
    
    public void borrarPaquete(int cod){
        
        String sql = "DELETE FROM paquete WHERE CodPaquete = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó el paquete.");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Paquete");
        }
    }
    
    public List<Paquete> listarPaquetes(){
        List<Paquete> paquetes = new ArrayList();
        
        String sql = "SELECT * FROM paquete";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Paquete paquete = new Paquete();
                paquete.setCodPaquete(rs.getInt("codPaquete"));
                paquete.setFechaIni(rs.getDate("fechaIni").toLocalDate());
                paquete.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                paquete.setBoleto(pd.buscarPasaje(rs.getInt("boleto")));
                paquete.setEstadia(ad.buscarAlojamiento(rs.getInt("estadia")));
                paquete.setRegimen(pendat.buscarPension(rs.getInt("regimen")));
                paquete.setOrigen(cd.buscarCiudad(rs.getString("origen")));
                paquete.setDestino(cd.buscarCiudad(rs.getString("destino")));
                paquete.setTraslados(rs.getFloat("traslados"));
                paquete.setMontoFinal(rs.getDouble("montoFinal"));
                paquete.setTurista(td.buscarTurista(rs.getInt("dni_turista")));
                
                paquetes.add(paquete);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Paquete");
        }
        return paquetes;
    }
    
    
}
