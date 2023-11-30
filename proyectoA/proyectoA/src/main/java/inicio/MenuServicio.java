package inicio;



import dao.ServicioDAO;
import entities.Servicio;
import impl.ServicioDAOImpl;

import java.util.List;
import java.util.Scanner;

public class MenuServicio {
    private static final ServicioDAO servicioDAO = ServicioDAOImpl.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("Menu Servicio");
            System.out.println("1. Agregar Servicio");
            System.out.println("2. Obtener Servicio por ID");
            System.out.println("3. Actualizar Servicio");
            System.out.println("4. Obtener Todos los Servicios");
            System.out.println("5. Eliminar Servicio");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarServicio();
                    break;
                case 2:
                    obtenerServicioPorId();
                    break;
                case 3:
                    actualizarServicio();
                    break;
                case 4:
                    obtenerTodosLosServicios();
                    break;
                case 5:
                    eliminarServicio();
                    break;
                case 0:
                    MenuPrincipal.main(args);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);
    }

    private static void agregarServicio() {
        System.out.print("Ingrese el nombre del nuevo servicio: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la descripción del nuevo servicio: ");
        String descripcion = scanner.nextLine();

        Servicio nuevoServicio = new Servicio();
        nuevoServicio.setNombre(nombre);
        nuevoServicio.setDescripcion(descripcion);

        servicioDAO.agregarServicio(nuevoServicio);
        System.out.println("Servicio agregado correctamente.");
    }

    private static void obtenerServicioPorId() {
        System.out.print("Ingrese el ID del servicio: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        Servicio servicioRecuperado = servicioDAO.obtenerServicio(id);

        if (servicioRecuperado != null) {
            System.out.println("Servicio recuperado: " + servicioRecuperado);
        } else {
            System.out.println("Servicio no encontrado con el ID proporcionado.");
        }
    }

    private static void actualizarServicio() {
        System.out.print("Ingrese el ID del servicio que desea actualizar: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        Servicio servicioRecuperado = servicioDAO.obtenerServicio(id);

        if (servicioRecuperado != null) {
            System.out.println("Servicio actual: " + servicioRecuperado);

            System.out.print("Ingrese el nuevo nombre del servicio: ");
            String nuevoNombre = scanner.nextLine();
            servicioRecuperado.setNombre(nuevoNombre);

            System.out.print("Ingrese la nueva descripción del servicio: ");
            String nuevaDescripcion = scanner.nextLine();
            servicioRecuperado.setDescripcion(nuevaDescripcion);

            servicioDAO.actualizarServicio(servicioRecuperado);

            System.out.println("Servicio actualizado correctamente.");
        } else {
            System.out.println("Servicio no encontrado con el ID proporcionado.");
        }
    }

   public static void obtenerTodosLosServicios() {
        List<Servicio> todosLosServicios = servicioDAO.obtenerTodosServicios();
       for (Servicio servicio : todosLosServicios) {
           System.out.println(servicio);
       }
    }

    private static void eliminarServicio() {
        System.out.print("Ingrese el ID del servicio que desea eliminar: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        Servicio servicioRecuperado = servicioDAO.obtenerServicio(id);

        if (servicioRecuperado != null) {
            servicioDAO.eliminarServicio(servicioRecuperado);
            System.out.println("Servicio eliminado correctamente.");
        } else {
            System.out.println("Servicio no encontrado con el ID proporcionado.");
        }
    }

    public static void obtenerTodosLosServicios(Long id) {
        List<Servicio> todosLosServicios = servicioDAO.obtenerTodosServicios();
        for (Servicio servicio : todosLosServicios) {
            if (servicio.getCliente().getId() == id) {
                System.out.println(servicio);
            }
        }

        }

}
