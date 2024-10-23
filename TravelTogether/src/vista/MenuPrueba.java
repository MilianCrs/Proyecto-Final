
package vista;

import entidad.Turista;
import java.util.Scanner;
import persistencia.TuristaData;


public class MenuPrueba {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Menú de Ingreso de Datos");
            System.out.println("1. Ingresar nuevo Turista");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    
                    System.out.print("Ingrese el dni del turista: ");
                    int dni = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Ingrese el apellido del turista: ");
                    String apellido = scanner.nextLine();

                    System.out.print("Ingrese el nombre del turista: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Ingrese la edad del turista: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Ingrese el telefono del turista: ");
                    long telefono = scanner.nextLong();
                    scanner.nextLine();
                    
                    System.out.print("Ingrese el correo del turista: ");
                    String correo = scanner.nextLine();

                    Turista t1 = new Turista(dni, nombre, apellido, edad, telefono, correo);
                    TuristaData test = new TuristaData();
                    test.cargarTurista(t1);
                     break;

                    case 2:
                        continuar = false; // Salir del bucle
                        System.out.println("Saliendo del programa.");
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                }
                 
            }
        }
    
}
