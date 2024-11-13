package persistencia;

import entidad.Ciudad;
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

public class CiudadData {

    Connection con = null;

    public CiudadData() {
        con = Conexion.getConexion();
    }

    public boolean guardarCiudad(Ciudad ciudad) {
        boolean resultado = false;
        String sql = "INSERT INTO ciudad (codCiudad, nombre, pais, continente, rol,inicioTemp,finTemp) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, ciudad.getCodCiudad());
            ps.setString(2, ciudad.getNombre());
            ps.setString(3, ciudad.getPais());
            ps.setString(4, ciudad.getContinente());
            ps.setString(5, ciudad.getRol());
            if (ciudad.getRol().equals("Origen")) {
                ps.setDate(6, null);
                ps.setDate(7, null);
            } else {
                ps.setDate(6, Date.valueOf(ciudad.getInicioTem()));
                ps.setDate(7, Date.valueOf(ciudad.getFinTem()));
            }

            resultado = ps.executeUpdate() > 0; // Para verificar si la inserción fue exitosa

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Ciudad: " + ex.getMessage());
        }

        return resultado;
    }

    public Ciudad buscarCiudad(String nombre) {
        Ciudad ciudad = null;
        String sql = "SELECT * FROM ciudad WHERE nombre = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ciudad = new Ciudad();
                ciudad.setCodCiudad(rs.getInt("codCiudad"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setPais(rs.getString("pais"));
                ciudad.setContinente(rs.getString("continente"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la ciudad");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Ciudad");
        }

        return ciudad;
    }

    public boolean actualizarCiudad(Ciudad ciudad) {
        boolean resultado = false;
        String sql = "UPDATE ciudad SET nombre = ?, pais = ?, continente = ?, rol = ?, inicioTemp = ?, finTemp = ? WHERE nombre = ?";

        PreparedStatement ps = null; // Declarar aquí para usar en finally
        try {
            ps = con.prepareStatement(sql);

            // Establecer los parámetros del PreparedStatement
            ps.setString(1, ciudad.getNombre());
            ps.setString(2, ciudad.getPais());
            ps.setString(3, ciudad.getContinente());
            ps.setString(4, ciudad.getRol());

            // Manejar las fechas
            if (ciudad.getRol().equals("Origen")) {
                ps.setDate(5, null);
                ps.setDate(6, null);
            } else {
                ps.setDate(5, Date.valueOf(ciudad.getInicioTem()));
                ps.setDate(6, Date.valueOf(ciudad.getFinTem()));
            }

            // Establecer el código de la ciudad a actualizar
            ps.setString(7, ciudad.getNombre());

            // Ejecutar la actualización y verificar el resultado
            resultado = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la ciudad: " + ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close(); // Cerrar PreparedStatement en finally
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return resultado;
    }

    public void borrarCiudad(String nombre) {

        String sql = "DELETE FROM ciudad WHERE nombre = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Ciudad Borrada Exitosamente");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Ciudad");
        }
    }

    public List<Ciudad> listarCiudades() {
        List<Ciudad> ciudades = new ArrayList();

        String sql = "SELECT * FROM ciudad";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setCodCiudad(rs.getInt("codCiudad"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setPais(rs.getString("pais"));
                ciudad.setContinente(rs.getString("continente"));
                ciudad.setRol(rs.getString("rol"));

                if (ciudad.getRol().equals("Origen")) {
                    ciudad.setInicioTem(null);
                    ciudad.setFinTem(null);
                } else {
                    ciudad.setInicioTem(rs.getDate("inicioTemp").toLocalDate());
                    ciudad.setFinTem(rs.getDate("finTemp").toLocalDate());
                }

                ciudades.add(ciudad);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Ciudad");
        }

        return ciudades;
    }

    public List<String> listarNombresCiudades() {
        List<String> nombresCiudades = new ArrayList<>();
        String sql = "SELECT nombre FROM ciudad";

        try (PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nombreCiudad = rs.getString("nombre");
                nombresCiudades.add(nombreCiudad);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Ciudad: " + ex.getMessage());
        }

        // Retornar la lista de nombres de las ciudades
        return nombresCiudades;
    }
    public boolean ciudadExiste(String nombre) {
    boolean existe = false;
    String sql = "SELECT 1 FROM ciudad WHERE nombre = ? LIMIT 1"; // Usamos LIMIT 1 para optimizar la búsqueda.

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            existe = true; // Si encontramos alguna fila, la ciudad existe.
        }

        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Ciudad: " + ex.getMessage());
    }

    return existe; // Retornamos true si la ciudad existe, false si no.
}


}
