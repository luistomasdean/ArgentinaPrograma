package inicio;

import dao.TecnicoDAO;
import entities.Tecnico;
import entities.Especialidad;
import impl.TecnicoDAOImpl;

import java.util.*;

public class MenuTecnico {
    private static final TecnicoDAO tecnicoDAO = TecnicoDAOImpl.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("Menu Técnico");
            System.out.println("1. Agregar Técnico");
            System.out.println("2. Obtener Técnico por ID");
            System.out.println("3. Actualizar Técnico");
            System.out.println("4. Obtener Todos los Técnicos");
            System.out.println("5. Eliminar Técnico");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarTecnico();
                    break;
                case 2:
                    obtenerTecnicoPorId();
                    break;
                case 3:
                    actualizarTecnico();
                    break;
                case 4:
                    obtenerTodosLosTecnicos();
                    break;
                case 5:
                    eliminarTecnico();
                    break;


                case 0:
                    MenuPrincipal.main(args);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);
    }

    private static void agregarTecnico() {
        System.out.print("Ingrese el nombre del técnico: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del técnico: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese el email del técnico: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese el teléfono del técnico: ");
        String telefono = scanner.nextLine();

        System.out.print("¿Está disponible? (true/false): ");
        boolean disponibilidad = scanner.nextBoolean();
        scanner.nextLine();


        List<Especialidad> especialidades = new ArrayList<>();
        int cantidadEspecialidades;
        System.out.print("Ingrese la cantidad de especialidades asociadas al técnico: ");
        cantidadEspecialidades = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidadEspecialidades; i++) {
            Especialidad especialidad = new Especialidad();
            System.out.print("Ingrese el nombre de la especialidad " + (i + 1) + ": ");
            especialidad.setNombre(scanner.nextLine());
            especialidades.add(especialidad);
        }


        Tecnico nuevoTecnico = new Tecnico(null, nombre, apellido, email, telefono);


        tecnicoDAO.agregarTecnico(nuevoTecnico);
        System.out.println("Técnico agregado correctamente.");
    }

    private static void obtenerTecnicoPorId() {
        System.out.print("Ingrese el ID del técnico: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        Tecnico tecnicoRecuperado = tecnicoDAO.obtenerTecnico(id);

        if (tecnicoRecuperado != null) {
            System.out.println("Técnico recuperado: " + tecnicoRecuperado);
        } else {
            System.out.println("Técnico no encontrado con el ID proporcionado.");
        }
    }

    private static void actualizarTecnico() {
        System.out.print("Ingrese el ID del técnico que desea actualizar: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        Tecnico tecnicoRecuperado = tecnicoDAO.obtenerTecnico(id);

        if (tecnicoRecuperado != null) {
            System.out.println("Técnico actual: " + tecnicoRecuperado);


            System.out.print("Ingrese el nuevo nombre del técnico: ");
            tecnicoRecuperado.setNombre(scanner.nextLine());


            tecnicoDAO.actualizarTecnico(tecnicoRecuperado);
            System.out.println("Técnico actualizado correctamente.");
        } else {
            System.out.println("Técnico no encontrado con el ID proporcionado.");
        }
    }

    private static void obtenerTodosLosTecnicos() {

        List<Tecnico> todosLosTecnicos = tecnicoDAO.obtenerTodosTecnicos();

        System.out.println("Todos los técnicos:");

        for (Tecnico tecnico : todosLosTecnicos) {


            System.out.println(tecnico);
        }

    }

    private static void eliminarTecnico() {
        System.out.print("Ingrese el ID del técnico que desea eliminar: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        Tecnico tecnicoRecuperado = tecnicoDAO.obtenerTecnico(id);

        if (tecnicoRecuperado != null) {
            tecnicoDAO.eliminarTecnico(tecnicoRecuperado);
            System.out.println("Técnico eliminado correctamente.");
        } else {
            System.out.println("Técnico no encontrado con el ID proporcionado.");
        }
    }

}




