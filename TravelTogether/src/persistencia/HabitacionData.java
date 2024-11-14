package persistencia;

import entidad.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class HabitacionData {

    Connection con = null;

    public HabitacionData() {

        con = Conexion.getConexion();
    }

    public void AgregarHabitacion(Habitacion hab) {
        String sql = "INSERT INTO habitacion (codAlojamiento, nbreAlojamiento, cantMax, cupo, tipo) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            // Establecemos los parámetros del PreparedStatement
            ps.setInt(1, hab.getIdAlojamineto());         // codAlojamiento (id del alojamiento)
            ps.setString(2, hab.getNombreAlojamiento());   // nbreAlojamiento (nombre del alojamiento)
            ps.setInt(3, hab.getCantMax());                // cantMax (capacidad máxima de la habitación)
            ps.setInt(4, hab.getCupo());                   // cupo (ocupación actual de la habitación)
            ps.setString(5, hab.getTipo());                // tipo (tipo de habitación, Ej. "Simple", "Doble")

            // Ejecutamos la consulta de inserción
            ps.executeUpdate();

            // Cerramos el PreparedStatement
            ps.close();

        } catch (SQLException ex) {
            // Mostramos un mensaje en caso de error
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Habitacion: " + ex.getMessage());
        }
    }

    public Habitacion buscarHabitacion(int nro) {
        Habitacion hab = null;
        String sql = "SELECT * FROM habitacion WHERE nroHab = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, nro);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                hab = new Habitacion();
                hab.setNroHabitacion(nro);
                hab.setPlanta(rs.getInt("planta"));
                hab.setNumeracion(rs.getInt("numerac"));
                hab.setCupo(rs.getInt("cupo"));
                hab.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "La habitacion no existe");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Habitacion");
        }
        return hab;
    }

    public void modificarHabitacion(Habitacion hab) {

        String sql = "UPDATE habitacion SET nroHab = ? planta = ? numerac = ? cupo = ? estado = ? WHERE nroHab = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, hab.getNroHabitacion());
            ps.setInt(2, hab.getPlanta());
            ps.setInt(3, hab.getNumeracion());
            ps.setInt(4, hab.getCupo());
            ps.setBoolean(5, hab.isEstado());
            ps.setInt(6, hab.getNroHabitacion());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La Habitacion no existe");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Habitacion");
        }
    }

    public void borrarHabitacion(int nro) {

        String sql = "DELETE FROM habitacion WHERE nroHab = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, nro);

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó la habitación.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Habitacion");
        }
    }

    public void borrarHabitacionesPorAlojamiento(int codAlojam) {

        String sql = "DELETE FROM habitacion WHERE codAlojamiento = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, codAlojam);

            int exito = ps.executeUpdate();

            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "Se eliminaron las habitaciones del alojamiento.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron habitaciones para eliminar.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar las habitaciones: " + ex.getMessage());
        }
    }

    public List<Habitacion> listarHabitaciones() {
        List habitaciones = new ArrayList();

        String sql = "SELECT * FROM habitacion";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Habitacion hab = new Habitacion();
                hab.setNroHabitacion(rs.getInt("nroHab"));
                hab.setPlanta(rs.getInt("planta"));
                hab.setNumeracion(rs.getInt("numerac"));
                hab.setCupo(rs.getInt("cupo"));
                hab.setEstado(rs.getBoolean("estado"));

                habitaciones.add(hab);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Habitacion");
        }
        return habitaciones;
    }

    public List<Habitacion> obtenerHabitacionesPorAlojamiento(int codAlojamiento) {
        List<Habitacion> habitaciones = new ArrayList<>();
        // Consulta SQL para obtener solo los campos específicos
        String sql = "SELECT cantMax, cupo, tipo, nbreAlojamiento FROM habitacion WHERE codAlojamiento = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codAlojamiento);  // Establecemos el parámetro del código de alojamiento

            ResultSet rs = ps.executeQuery();

            // Iteramos a través de los resultados y agregamos las habitaciones a la lista
            while (rs.next()) {
                Habitacion hab = new Habitacion();
                hab.setCantMax(rs.getInt("cantMax"));  // Asignamos el valor de la capacidad máxima
                hab.setCupo(rs.getInt("cupo"));       // Asignamos el valor del cupo actual
                hab.setTipo(rs.getString("tipo"));    // Asignamos el tipo de habitación
                hab.setNombreAlojamiento(rs.getString("nbreAlojamiento"));  // Asignamos el nombre del alojamiento

                habitaciones.add(hab);
            }

            ps.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Habitacion: " + ex.getMessage());
        }

        return habitaciones;
    }

    public void actualizarHabitacion(Habitacion habitacion) {
        // Sentencia SQL para actualizar los campos de la habitación
        String sql = "UPDATE habitacion SET cantMax = ?, cupo = ?, tipo = ?, nbreAlojamiento = ? WHERE nroHab = ?";

        try {
            // Preparar la sentencia SQL
            PreparedStatement ps = con.prepareStatement(sql);

            // Establecer los parámetros de la sentencia SQL con los datos de la habitación
            ps.setInt(1, habitacion.getCantMax());  // Establecer la capacidad máxima
            ps.setInt(2, habitacion.getCupo());     // Establecer el cupo actual
            ps.setString(3, habitacion.getTipo());  // Establecer el tipo de habitación
            ps.setString(4, habitacion.getNombreAlojamiento());  // Establecer el nombre del alojamiento
            ps.setInt(5, habitacion.getNroHabitacion());  // Establecer el número de habitación (ID único)

            // Ejecutar la actualización
            int filasAfectadas = ps.executeUpdate();

            // Verificar si la actualización fue exitosa
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Habitación actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La habitación no fue encontrada o no se actualizó.");
            }

            // Cerrar el PreparedStatement
            ps.close();

        } catch (SQLException ex) {
            // Manejar cualquier error que ocurra durante la ejecución de la consulta
            JOptionPane.showMessageDialog(null, "Error al actualizar la habitación: " + ex.getMessage());
        }
    }

    public void actualizarHabitacionPorAlojamiento(int codAlojamiento, int cantMax) {
        // Sentencia SQL para actualizar el campo cantMax de las habitaciones en base al código de alojamiento
        String sql = "UPDATE habitacion SET cantMax = ? WHERE codAlojamiento = ?";

        try {
            // Preparar la sentencia SQL
            PreparedStatement ps = con.prepareStatement(sql);

            // Establecer los parámetros de la sentencia SQL
            ps.setInt(1, cantMax);  // Establecer la nueva capacidad máxima
            ps.setInt(2, codAlojamiento);  // Establecer el código de alojamiento como criterio de búsqueda

            // Ejecutar la actualización
            int filasAfectadas = ps.executeUpdate();

            // Verificar si la actualización fue exitosa
            if (filasAfectadas > 0) 
            {
                //JOptionPane.showMessageDialog(null, "Habitación actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron habitaciones para ese alojamiento o no se actualizó.");
            }

            // Cerrar el PreparedStatement
            ps.close();

        } catch (SQLException ex) {
            // Manejar cualquier error que ocurra durante la ejecución de la consulta
            JOptionPane.showMessageDialog(null, "Error al actualizar la habitación: " + ex.getMessage());
        }
    }

}
