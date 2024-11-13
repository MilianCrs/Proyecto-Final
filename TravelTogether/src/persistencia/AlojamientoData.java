package persistencia;

import entidad.Alojamiento;
import entidad.Ciudad;
import entidad.Habitacion;
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
    CiudadData cd = null;
    HabitacionData hd = null;

    public AlojamientoData() {
        con = Conexion.getConexion();
        cd = new CiudadData();
        hd = new HabitacionData();
    }

    public int guardarAlojamiento(Alojamiento alo) {
        int idGenerado = -1; // Valor predeterminado en caso de error.
        String sql = "INSERT INTO alojamiento (nombre, capacidad, nroAmbientes, camas, banios, precioNoche, tipo, ciudad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Preparamos la sentencia SQL
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); // Añadido: PARA OBTENER EL ID

            // Asignamos los valores al PreparedStatement
            ps.setString(1, alo.getNombre());
            ps.setInt(2, alo.getCapacidad());
            ps.setInt(3, alo.getNroAmbientes());
            ps.setInt(4, alo.getCamas());
            ps.setInt(5, alo.getBanios());
            ps.setDouble(6, alo.getPrecioNoche());
            ps.setString(7, alo.getTipo());
            ps.setString(8, alo.getNbreCiudad());

            // Ejecutamos la inserción
            int filasAfectadas = ps.executeUpdate();

            // Si se insertaron filas, obtenemos el código generado
            if (filasAfectadas > 0) {
                // Obtenemos el ID generado automáticamente
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    idGenerado = rs.getInt(1); // El primer valor devuelto es el ID generado
                }
                rs.close();
            }

            ps.close();
        } catch (SQLException ex) {
            // Mostramos un mensaje si ocurre algún error en la base de datos
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento: " + ex.getMessage());
        }

        return idGenerado; // Devolvemos el ID generado
    }

    public Alojamiento buscarAlojamiento(int cod) {
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
                alo.setCamas(rs.getInt("camas"));
                alo.setBanios(rs.getInt("banios"));
                alo.setPrecioNoche(rs.getDouble("precioNoche"));
                alo.setTipo(rs.getString("tipo"));
                alo.setNbreCiudad(rs.getString("ciudad"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alojamiento");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento");
        }

        return alo;
    }

    public void modificarAlojamiento(Alojamiento alo) {

        String sql = "UPDATE alojamiento SET codAlojam = ?, nombre = ?, capacidad = ? ,nroAmbientes = ? ,camas = ? ,banios = ? ,precioNoche = ? ,tipo = ? WHERE codAlojam = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, alo.getCodAlojam());
            ps.setString(2, alo.getNombre());
            ps.setInt(3, alo.getCapacidad());
            ps.setInt(4, alo.getNroAmbientes());
            ps.setInt(5, alo.getCamas());
            ps.setInt(6, alo.getBanios());
            ps.setDouble(7, alo.getPrecioNoche());
            ps.setString(8, alo.getTipo());
            ps.setInt(9, alo.getCodAlojam());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alojamiento modificado Exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "El Alojamiento no existe");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento");
        }

    }

    public void borrarAlojamiento(int cod) {

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

    public List<Alojamiento> listarAlojamientos() {

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
                alo.setCamas(rs.getInt("camas"));
                alo.setBanios(rs.getInt("banios"));
                alo.setPrecioNoche(rs.getDouble("precioNoche"));
                alo.setTipo(rs.getString("tipo"));
                // alo.setCiudad(cd.buscarCiudad(rs.getString("ciudad")));

                alojamientos.add(alo);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento");
        }

        return alojamientos;
    }

    public List listarAlojamientosXCiudad(String ciudad) {
        List alojamientos = new ArrayList();

        String sql = "SELECT * FROM alojamiento WHERE ciudad = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ciudad);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alojamiento alo = new Alojamiento();
                alo.setCodAlojam(rs.getInt("codAlojam"));
                alo.setNombre(rs.getString("nombre"));
                alo.setCapacidad(rs.getInt("capacidad"));
                alo.setNroAmbientes(rs.getInt("nroAmbientes"));
                alo.setCamas(rs.getInt("camas"));
                alo.setBanios(rs.getInt("banios"));
                alo.setPrecioNoche(rs.getDouble("precioNoche"));
                alo.setTipo(rs.getString("tipo"));
                // alo.setCiudad(ciudad);

                alojamientos.add(alo);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento");
        }

        return alojamientos;
    }

    public void agregarH(Habitacion habitacion) {
        hd.AgregarHabitacion(habitacion);
    }

}
