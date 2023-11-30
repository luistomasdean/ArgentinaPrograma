package inicio;

import dao.TipoProblemaDAO;
import entities.TipoProblema;
import impl.TipoProblemaDAOImpl;

import java.util.List;
import java.util.Scanner;

public class MenuTipoProblema {
    private static final TipoProblemaDAO tipoProblemaDAO = TipoProblemaDAOImpl.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("Menu TipoProblema");
            System.out.println("1. Agregar TipoProblema");
            System.out.println("2. Obtener TipoProblema por ID");
            System.out.println("3. Actualizar TipoProblema");
            System.out.println("4. Obtener Todos los TiposProblema");
            System.out.println("5. Eliminar TipoProblema");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarTipoProblema();
                    break;
                case 2:
                    obtenerTipoProblemaPorId();
                    break;
                case 3:
                    actualizarTipoProblema();
                    break;
                case 4:
                    obtenerTodosLosTiposProblema();
                    break;
                case 5:
                    eliminarTipoProblema();
                    break;
                case 0:
                    MenuPrincipal.main(args);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);
    }

    private static void agregarTipoProblema() {
        System.out.print("Ingrese el nombre del nuevo tipo de problema: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la descripción del nuevo tipo de problema: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese el tiempo máximo de resolución del nuevo tipo de problema: ");
        int tiempoMaximoResolucion = scanner.nextInt();
        scanner.nextLine();

        TipoProblema nuevoTipoProblema = new TipoProblema();
        nuevoTipoProblema.setNombre(nombre);
        nuevoTipoProblema.setDescripcion(descripcion);
        nuevoTipoProblema.setTiempoMaximoResolucion(tiempoMaximoResolucion);

        tipoProblemaDAO.agregarTipoProblema(nuevoTipoProblema);
        System.out.println("TipoProblema agregado correctamente.");
    }

    public static void obtenerTipoProblemaPorId() {
        System.out.print("Ingrese el ID del tipo de problema: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        TipoProblema tipoProblemaRecuperado = tipoProblemaDAO.obtenerTipoProblema(id);

        if (tipoProblemaRecuperado != null) {
            System.out.println("TipoProblema recuperado: " + tipoProblemaRecuperado);
        } else {
            System.out.println("TipoProblema no encontrado con el ID proporcionado.");
        }
    }

    private static void actualizarTipoProblema() {
        System.out.print("Ingrese el ID del tipo de problema que desea actualizar: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        TipoProblema tipoProblemaRecuperado = tipoProblemaDAO.obtenerTipoProblema(id);

        if (tipoProblemaRecuperado != null) {
            System.out.println("TipoProblema actual: " + tipoProblemaRecuperado);

            System.out.print("Ingrese el nuevo nombre del tipo de problema: ");
            String nuevoNombre = scanner.nextLine();
            tipoProblemaRecuperado.setNombre(nuevoNombre);

            System.out.print("Ingrese la nueva descripción del tipo de problema: ");
            String nuevaDescripcion = scanner.nextLine();
            tipoProblemaRecuperado.setDescripcion(nuevaDescripcion);

            System.out.print("Ingrese el nuevo tiempo máximo de resolución del tipo de problema: ");
            int nuevoTiempoMaximoResolucion = scanner.nextInt();
            scanner.nextLine();
            tipoProblemaRecuperado.setTiempoMaximoResolucion(nuevoTiempoMaximoResolucion);

            tipoProblemaDAO.actualizarTipoProblema(tipoProblemaRecuperado);

            System.out.println("TipoProblema actualizado correctamente.");
        } else {
            System.out.println("TipoProblema no encontrado con el ID proporcionado.");
        }
    }

    public static void obtenerTodosLosTiposProblema() {
        List<TipoProblema> todosLosTiposProblema = tipoProblemaDAO.obtenerTodosTiposProblema();
       for (TipoProblema todo : todosLosTiposProblema){
           System.out.println(todo);
       }
    }

    private static void eliminarTipoProblema() {
        System.out.print("Ingrese el ID del tipo de problema que desea eliminar: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        TipoProblema tipoProblemaRecuperado = tipoProblemaDAO.obtenerTipoProblema(id);

        if (tipoProblemaRecuperado != null) {
            tipoProblemaDAO.eliminarTipoProblema(tipoProblemaRecuperado);
            System.out.println("TipoProblema eliminado correctamente.");
        } else {
            System.out.println("TipoProblema no encontrado con el ID proporcionado.");
        }
    }
}
