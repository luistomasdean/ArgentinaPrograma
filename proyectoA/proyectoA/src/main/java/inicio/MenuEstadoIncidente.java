package inicio;



import dao.EstadoIncidenteDAO;
import entities.EstadoIncidente;
import impl.EstadoIncidenteDAOImpl;

import java.util.List;
import java.util.Scanner;

public class MenuEstadoIncidente {
    private static final EstadoIncidenteDAO estadoIncidenteDAO = EstadoIncidenteDAOImpl.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("Menu EstadoIncidente");
            System.out.println("1. Agregar EstadoIncidente");
            System.out.println("2. Obtener EstadoIncidente por ID");
            System.out.println("3. Actualizar EstadoIncidente");
            System.out.println("4. Obtener Todos los EstadosIncidente");
            System.out.println("5. Eliminar EstadoIncidente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarEstadoIncidente();
                    break;
                case 2:
                    obtenerEstadoIncidentePorId();
                    break;
                case 3:
                    actualizarEstadoIncidente();
                    break;
                case 4:
                    obtenerTodosLosEstadosIncidente();
                    break;
                case 5:
                    eliminarEstadoIncidente();
                    break;
                case 0:
                    MenuPrincipal.main(args);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);
    }

    private static void agregarEstadoIncidente() {
        System.out.print("Ingrese el nombre del nuevo estado de incidente: ");
        String nombre = scanner.nextLine();

        EstadoIncidente nuevoEstadoIncidente = new EstadoIncidente();
        nuevoEstadoIncidente.setNombre(nombre);

        estadoIncidenteDAO.agregarEstadoIncidente(nuevoEstadoIncidente);
        System.out.println("EstadoIncidente agregado correctamente.");
    }

    private static void obtenerEstadoIncidentePorId() {
        System.out.print("Ingrese el ID del estado de incidente: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        EstadoIncidente estadoIncidenteRecuperado = estadoIncidenteDAO.obtenerEstadoIncidente(id);

        if (estadoIncidenteRecuperado != null) {

            System.out.println("EstadoIncidente recuperado: " + estadoIncidenteRecuperado);
        } else {
            System.out.println("EstadoIncidente no encontrado con el ID proporcionado.");
        }
    }

    private static void actualizarEstadoIncidente() {
        System.out.print("Ingrese el ID del estado de incidente que desea actualizar: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        EstadoIncidente estadoIncidenteRecuperado = estadoIncidenteDAO.obtenerEstadoIncidente(id);

        if (estadoIncidenteRecuperado != null) {
            System.out.println("EstadoIncidente actual: " + estadoIncidenteRecuperado);

            System.out.print("Ingrese el nuevo nombre del estado de incidente: ");
            String nuevoNombre = scanner.nextLine();
            estadoIncidenteRecuperado.setNombre(nuevoNombre);

            estadoIncidenteDAO.actualizarEstadoIncidente(estadoIncidenteRecuperado);

            System.out.println("EstadoIncidente actualizado correctamente.");
        } else {
            System.out.println("EstadoIncidente no encontrado con el ID proporcionado.");
        }
    }

   public static void obtenerTodosLosEstadosIncidente() {
        List<EstadoIncidente> todosLosEstadosIncidente = estadoIncidenteDAO.obtenerTodosEstadosIncidente();

        System.out.println("Todos los estados de incidente:");
        for (EstadoIncidente estado : todosLosEstadosIncidente) {
            System.out.println(estado);
    }}

    private static void eliminarEstadoIncidente() {
        System.out.print("Ingrese el ID del estado de incidente que desea eliminar: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        EstadoIncidente estadoIncidenteRecuperado = estadoIncidenteDAO.obtenerEstadoIncidente(id);

        if (estadoIncidenteRecuperado != null) {
            estadoIncidenteDAO.eliminarEstadoIncidente(estadoIncidenteRecuperado);
            System.out.println("EstadoIncidente eliminado correctamente.");
        } else {
            System.out.println("EstadoIncidente no encontrado con el ID proporcionado.");
        }
    }
}
