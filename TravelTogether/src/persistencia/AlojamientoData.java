package persistencia;

import entidad.Alojamiento;
import entidad.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

//    public void modificarAlojamiento(Alojamiento alo) {
//
//        String sql = "UPDATE alojamiento SET nombre = ?, capacidad = ?, nroAmbientes = ?, camas = ?, banios = ?, precioNoche = ?, tipo = ?, ciudad = ? WHERE codAlojam = ?";
//
//        try {
//            // Preparar la sentencia SQL
//            PreparedStatement ps = con.prepareStatement(sql);
//
//            // Asignar los parámetros con los valores del objeto 'Alojamiento'
//            ps.setString(1, alo.getNombre());             // nombre
//            ps.setInt(2, alo.getCapacidad());             // capacidad
//            ps.setInt(3, alo.getNroAmbientes());          // nroAmbientes
//            ps.setInt(4, alo.getCamas());                 // camas
//            ps.setInt(5, alo.getBanios());                // banios
//            ps.setDouble(6, alo.getPrecioNoche());        // precioNoche
//            ps.setString(7, alo.getTipo());               // tipo
//            ps.setString(8, alo.getNbreCiudad());        // ciudad
//            ps.setInt(9, alo.getCodAlojam());             // codAlojam (clave primaria para buscar el registro)
//
//            // Ejecutar la actualización
//            int exito = ps.executeUpdate();
//
//            // Comprobar si la actualización fue exitosa
//            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Alojamiento modificado exitosamente");
//            } else {
//                JOptionPane.showMessageDialog(null, "El Alojamiento con ese código no existe");
//            }
//
//            // Cerrar el PreparedStatement
//            ps.close();
//
//        } catch (SQLException ex) {
//            // Manejo de excepciones
//            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento: " + ex.getMessage());
//        }
//    }
    public void modificarAlojamiento(Alojamiento alo) {

     // SQL para actualizar el alojamiento (no se modifica el nombre)
    String sql = "UPDATE alojamiento SET capacidad = ?, nroAmbientes = ?, camas = ?, banios = ?, precioNoche = ?, tipo = ? WHERE nombre = ?";

    try {
        // Preparar la sentencia SQL
        PreparedStatement ps = con.prepareStatement(sql);

        // Asignar los parámetros con los valores del objeto 'Alojamiento'
        ps.setInt(1, alo.getCapacidad());           // capacidad
        ps.setInt(2, alo.getNroAmbientes());        // nroAmbientes
        ps.setInt(3, alo.getCamas());               // camas
        ps.setInt(4, alo.getBanios());              // banios
        ps.setDouble(5, alo.getPrecioNoche());      // precioNoche
        ps.setString(6, alo.getTipo());             // tipo
       // ps.setString(7, alo.getNbreCiudad());      // ciudad
        ps.setString(7, alo.getNombre());           // nombre (usado para el WHERE)

        // Ejecutar la actualización
        int exito = ps.executeUpdate();

        // Comprobar si la actualización fue exitosa
        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Alojamiento modificado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar el alojamiento con ese nombre.");
        }

        // Cerrar el PreparedStatement
        ps.close();

    } catch (SQLException ex) {
        // Manejo de excepciones
        JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos: " + ex.getMessage());
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
                alo.setNbreCiudad(rs.getString("ciudad"));
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

                alo.setNbreCiudad(ciudad);

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
    public void modificarHabitacion(Habitacion h)
    {
        hd.actualizarHabitacionPorAlojamiento(h.getIdAlojamineto(),h.getCantMax());
    }
    
    public void borrarHabitacion(int cod)
    {
        hd.borrarHabitacionesPorAlojamiento(cod);
    }
    public List<Habitacion> habitacionesAlojamiento(int cod)
    {
      return hd.obtenerHabitacionesPorAlojamiento(cod);
    }

    public Alojamiento buscarAlojamientoPorNombre(String nombre) {
        Alojamiento alo = null;
        String sql = "SELECT * FROM alojamiento WHERE nombre = ?"; // SQL con el nombre como criterio

        try {
            // Preparar la sentencia SQL
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre); // Asignamos el nombre del alojamiento al PreparedStatement

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();

            // Si encontramos un alojamiento con ese nombre
            if (rs.next()) {
                alo = new Alojamiento();
                alo.setCodAlojam(rs.getInt("codAlojam"));
                alo.setNombre(rs.getString("nombre"));
                alo.setCapacidad(rs.getInt("capacidad"));
                alo.setNroAmbientes(rs.getInt("nroAmbientes"));
                alo.setCamas(rs.getInt("camas"));
                alo.setBanios(rs.getInt("banios"));
                alo.setPrecioNoche(rs.getDouble("precioNoche"));
                alo.setTipo(rs.getString("tipo"));
                alo.setNbreCiudad(rs.getString("ciudad"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el alojamiento con ese nombre.");
            }

            // Cerrar el PreparedStatement
            ps.close();

        } catch (SQLException ex) {
            // Manejo de excepciones en caso de error en la base de datos
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento: " + ex.getMessage());
        }

        return alo; // Retorna el objeto Alojamiento encontrado o null si no existe
    }

    
    public int obtenerCodigoAlojamientoPorNombre(String nombre) {
    int codAlojam = -1;  // Valor predeterminado en caso de que no se encuentre el alojamiento

    String sql = "SELECT codAlojam FROM alojamiento WHERE nombre = ?"; // SQL que selecciona el código de alojamiento por nombre

    try {
        // Preparar la sentencia SQL
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre);  // Establecer el nombre del alojamiento en la consulta

        // Ejecutar la consulta
        ResultSet rs = ps.executeQuery();

        // Si encontramos un alojamiento con ese nombre, obtenemos su código
        if (rs.next()) {
            codAlojam = rs.getInt("codAlojam");  // Obtenemos el código del alojamiento
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el alojamiento con ese nombre.");
        }

        // Cerrar el PreparedStatement y el ResultSet
        ps.close();
        rs.close();

    } catch (SQLException ex) {
        // Manejo de excepciones en caso de error en la base de datos
        JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla Alojamiento: " + ex.getMessage());
    }

    return codAlojam;  // Retorna el código encontrado o -1 si no existe
}

}
