/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Celi Leandro
 */
public class Conexion 
{
  private static Connection connection;

    public Conexion() {
    }

    public static Connection getConexion() {

        if (connection == null) {

            try {
                // Cargar el controlador
                Class.forName("org.mariadb.jdbc.Driver");

                // Establecer la conexión
                String url = "jdbc:mariadb://localhost:3306/NOMBRE_BASEDATOS";
                String usuario = "root";
                String contrasena = "";

                connection = DriverManager.getConnection(url, usuario, contrasena);
                System.out.println("Conexión exitosa!");

            } catch (ClassNotFoundException e) {
                System.err.println("Controlador no encontrado: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Error de conexión: " + e.getMessage());
            } 
        }
        return connection;

    }    
}
