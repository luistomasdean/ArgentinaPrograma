package inicio;

import dao.EspecialidadDAO;
import entities.Especialidad;
import impl.EspecialidadDAOImpl;

import java.util.List;
import java.util.Scanner;

public class MenuEspecialidad {
    private static final EspecialidadDAO especialidadDAO = EspecialidadDAOImpl.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("Menu Especialidad");
            System.out.println("1. Agregar Especialidad");
            System.out.println("2. Obtener Especialidad por ID");
            System.out.println("3. Actualizar Especialidad");
            System.out.println("4. Obtener Todas las Especialidades");
            System.out.println("5. Eliminar Especialidad");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarEspecialidad();
                    break;
                case 2:
                    obtenerEspecialidadPorId();
                    break;
                case 3:
                    actualizarEspecialidad();
                    break;
                case 4:
                    obtenerTodasLasEspecialidades();
                    break;
                case 5:
                    eliminarEspecialidad();
                    break;
                case 0:
                    MenuPrincipal.main(args);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);
    }

    private static void agregarEspecialidad() {
        System.out.print("Ingrese el nombre de la nueva especialidad: ");
        String nombre = scanner.nextLine();

        Especialidad nuevaEspecialidad = new Especialidad();
        nuevaEspecialidad.setNombre(nombre);

        especialidadDAO.agregarEspecialidad(nuevaEspecialidad);
        System.out.println("Especialidad agregada correctamente.");
    }

    private static void obtenerEspecialidadPorId() {
        System.out.print("Ingrese el ID de la especialidad: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        Especialidad especialidadRecuperada = especialidadDAO.obtenerEspecialidad(id);

        if (especialidadRecuperada != null) {
            System.out.println("Especialidad recuperada: " + especialidadRecuperada);
        } else {
            System.out.println("Especialidad no encontrada con el ID proporcionado.");
        }
    }

    private static void actualizarEspecialidad() {
        System.out.print("Ingrese el ID de la especialidad que desea actualizar: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        Especialidad especialidadRecuperada = especialidadDAO.obtenerEspecialidad(id);

        if (especialidadRecuperada != null) {
            System.out.println("Especialidad actual: " + especialidadRecuperada);
            System.out.print("Ingrese el nuevo nombre de la especialidad: ");
            String nuevoNombre = scanner.nextLine();
            especialidadRecuperada.setNombre(nuevoNombre);

            especialidadDAO.actualizarEspecialidad(especialidadRecuperada);
            System.out.println("Especialidad actualizada correctamente.");
        } else {
            System.out.println("Especialidad no encontrada con el ID proporcionado.");
        }
    }

    private static void obtenerTodasLasEspecialidades() {
        List<Especialidad> todasLasEspecialidades = especialidadDAO.obtenerTodasEspecialidades();
        System.out.println("Todas las especialidades: " + todasLasEspecialidades);
    }

    private static void eliminarEspecialidad() {
        System.out.print("Ingrese el ID de la especialidad que desea eliminar: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        Especialidad especialidadRecuperada = especialidadDAO.obtenerEspecialidad(id);

        if (especialidadRecuperada != null) {
            especialidadDAO.eliminarEspecialidad(especialidadRecuperada);
            System.out.println("Especialidad eliminada correctamente.");
        } else {
            System.out.println("Especialidad no encontrada con el ID proporcionado.");
        }
    }
    public static void obtenerTecnicoDisponible() {
        List<Especialidad> todasLasEspecialidades = especialidadDAO.obtenerTodasEspecialidades();

        for (Especialidad especialidad :todasLasEspecialidades){
            if (especialidad.isDisponibilidad()){
                System.out.println(especialidad.getTecnico());

            }
        }
    }

}
