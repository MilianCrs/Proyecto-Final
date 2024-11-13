/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Ciudad;
import entidad.Compras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ComprasData {
    
    Connection con = null;
    CiudadData cd = null;
    PaqueteData pd = null;

    public ComprasData() {
        con = Conexion.getConexion();
        cd = new CiudadData();
        pd = new PaqueteData();
    }
    
    public void generarCompra(Compras compra){
        
        String sql = "INSERT INTO compras (codPaquete, ciudad, temporada) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, compra.getPaquete().getCodPaquete());
            ps.setString(2, compra.getCiudad().getNombre());
            ps.setString(3, compra.calcularTemporada(compra.getPaquete()));
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                compra.setIdCompra(rs.getInt(1));

                
                System.out.println("Compra realizada con éxito.");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla compras");
        }
    }
    
    public Compras buscarCompra(int idCompra){
        Compras compra = null;
        String sql = "SELECT * FROM compras WHERE idCompra = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                compra = new Compras();
                compra.setIdCompra(idCompra);
                compra.setPaquete(pd.buscarPaquete(rs.getInt("codPaquete")));
                compra.setCiudad(cd.buscarCiudad(rs.getString("ciudad")));
                compra.setTemporada(rs.getString("temporada"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe esa compra");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla compras");
        }
        return compra;
    }
    
    public List<Compras> buscarCompraXPaquete(int codPaquete){
        List<Compras> compras = new ArrayList();
        
        String sql = "SELECT * FROM compras WHERE codPaquete = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codPaquete);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Compras compra = new Compras();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setPaquete(pd.buscarPaquete(rs.getInt("codPaquete")));
                compra.setCiudad(cd.buscarCiudad(rs.getString("ciudad")));
                compra.setTemporada(rs.getString("temporada"));
                
                compras.add(compra);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla compras");
        }
        return compras;
    }
    
    public List<Compras> buscarCompraXCiudad(String ciudad){
        List<Compras> compras = new ArrayList();
        
        String sql = "SELECT * FROM compras WHERE ciudad = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ciudad);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Compras compra = new Compras();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setPaquete(pd.buscarPaquete(rs.getInt("codPaquete")));
                compra.setCiudad(cd.buscarCiudad(rs.getString("ciudad")));
                compra.setTemporada(rs.getString("temporada"));
                
                compras.add(compra);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla compras");
        }
        return compras;
    }
    
    public Ciudad masElegidaMeses(int mes) {
        Ciudad compra = null;

        String sql = "SELECT c.ciudad, COUNT(*) AS selecciones "
                + "FROM compras c "
                + "JOIN paquete p ON c.codPaquete = p.codPaquete "
                + "WHERE MONTH(p.fechaIni) = ? "
                + "GROUP BY c.ciudad "
                + "ORDER BY selecciones DESC LIMIT 1";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, mes);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                compra = cd.buscarCiudad(rs.getString("ciudad"));
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla compras");
        }
        return compra;
    }
    
    public Ciudad masElegidaTemporada(String Temporada) {
        Ciudad compra = null;

        String sql = "SELECT c.ciudad, COUNT(*) AS selecciones "
                + "FROM compras c "
                + "WHERE c.temporada = ? "
                + "GROUP BY c.ciudad "
                + "ORDER BY selecciones DESC LIMIT 1";


        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, Temporada);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                compra = cd.buscarCiudad(rs.getString("ciudad"));
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla compras");
        }
        return compra;
    }
    
    public void anularCompra(int idcompra){
        
        String sql = "DELETE FROM compras WHERE idCompra = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idcompra);
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se anuló la compra.");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla compras");
        }
    }
    
    public void modificarCompra(Compras compra){
        
        String sql = "UPDATE compras SET idCompra = ?, codPaquete = ?, ciudad = ?, temporada = ? WHERE idCompra = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, compra.getIdCompra());
            ps.setInt(2, compra.getPaquete().getCodPaquete());
            ps.setString(3, compra.getCiudad().getNombre());
            ps.setString(4, compra.calcularTemporada(compra.getPaquete()));
            ps.setInt(5, compra.getPaquete().getCodPaquete());
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Compra modificada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La compra no existe");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla compras");
        }
        
    }
    
    public List<Compras> listarCompras(){
        List<Compras> compras = new ArrayList();
        
        String sql = "SELECT * FROM compras";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Compras compra = new Compras();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setPaquete(pd.buscarPaquete(rs.getInt("codPaquete")));
                compra.setCiudad(cd.buscarCiudad(rs.getString("ciudad")));
                compra.setTemporada(rs.getString("temporada"));
                
                compras.add(compra);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla compras");
        }
        return compras;
    }
    
    public List<Compras> listarUltimasCompras() {
        List<Compras> compras = new ArrayList();

        String sql = "SELECT c.idCompra, c.codPaquete, c.ciudad, p.fechaIni, p.montoFinal "
                + "FROM compras c "
                + "JOIN paquete p ON p.codPaquete = c.codPaquete "
                + "WHERE p.fechaIni BETWEEN DATE_SUB(NOW(), INTERVAL 2 MONTH) AND NOW();";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Compras compra = new Compras();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setPaquete(pd.buscarPaquete(rs.getInt("codPaquete")));
                compra.setCiudad(cd.buscarCiudad(rs.getString("ciudad")));
                
                compras.add(compra);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla compras");
        }
        return compras;
    }
    
    public List<Compras> buscarCompraXCiudadYMes(Ciudad ciudad, int mes){
        List<Compras> compras = new ArrayList();
        
        String sql = "SELECT * FROM compras c JOIN paquete p ON c.codPaquete = p.codPaquete WHERE ciudad = ? AND MONTH(p.fechaIni) = ? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ciudad.getNombre());
            ps.setInt(2, mes);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Compras compra = new Compras();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setPaquete(pd.buscarPaquete(rs.getInt("codPaquete")));
                compra.setCiudad(cd.buscarCiudad(rs.getString("ciudad")));
                compra.setTemporada(rs.getString("temporada"));
                
                compras.add(compra);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla compras");
        }
        return compras;
    }
    
    public List<Compras> buscarCompraXCiudadYTemporada(Ciudad ciudad, String temporada){
        List<Compras> compras = new ArrayList();
        
        String sql = "SELECT * FROM compras WHERE ciudad = ? AND temporada = ? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ciudad.getNombre());
            ps.setString(2, temporada);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Compras compra = new Compras();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setPaquete(pd.buscarPaquete(rs.getInt("codPaquete")));
                compra.setCiudad(cd.buscarCiudad(rs.getString("ciudad")));
                compra.setTemporada(rs.getString("temporada"));
                
                compras.add(compra);
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla compras");
        }
        return compras;
    }
    
}
