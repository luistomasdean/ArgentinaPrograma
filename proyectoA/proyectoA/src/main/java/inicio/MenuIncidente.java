package inicio;


import dao.IncidenteDAO;
import entities.Cliente;
import entities.EstadoIncidente;
import entities.Incidente;
import entities.Servicio;
import entities.Tecnico;
import entities.TipoProblema;
import impl.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class MenuIncidente {
    private static final IncidenteDAO incidenteDAO = IncidenteDAOImpl.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("Menu Incidente");
            System.out.println("1. Agregar Incidente");
            System.out.println("2. Obtener Incidente por ID");
            System.out.println("3. Actualizar Incidente");
            System.out.println("4. Obtener Todos los Incidentes");
            System.out.println("5. Eliminar Incidente");
            System.out.println("6. Obtener Tecnico Con Mas Puntos();");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarIncidente();
                    break;
                case 2:
                    obtenerIncidentePorId();
                    break;
                case 3:
                    actualizarIncidente();
                    break;
                case 4:
                    obtenerTodosLosIncidentes();
                    break;
                case 5:
                    eliminarIncidente();
                    break;
                case 6:
                    obtenerTecnicoConMasPuntos();
                    break;

                case 0:
                    MenuPrincipal.main(args);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);
    }

    private static void agregarIncidente() {

        System.out.print("Ingrese el ID del Cliente asociado al incidente: ");
        MenuCliente.ListaTodosLosClientes();
        System.out.print("Ingrese el ID del Cliente asociado al incidente: ");
        long clienteId = scanner.nextLong();
        scanner.nextLine();
        MenuServicio.obtenerTodosLosServicios(clienteId);
        System.out.print("Ingrese el ID del Servicio asociado al incidente: ");

        long servicioId = scanner.nextLong();
        scanner.nextLine();
        MenuTipoProblema.obtenerTodosLosTiposProblema();
        System.out.print("Ingrese el ID del Tipo de Problema asociado al incidente: ");

        long tipoProblemaId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Ingrese la descripción del incidente: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese el tiempo estimado de resolución del incidente en horas: ");
        int tiempoEstimadoResolucion = scanner.nextInt();
        scanner.nextLine();
        MenuEstadoIncidente.obtenerTodosLosEstadosIncidente();
        System.out.print("Ingrese el ID del Estado del incidente: ");
        long estadoId = scanner.nextLong();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número
        MenuEspecialidad.obtenerTecnicoDisponible();
        System.out.print("Ingrese el ID del Técnico asignado al incidente (o 0 si no hay uno): ");

        long tecnicoId = scanner.nextLong();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        System.out.print("Ingrese observaciones para el incidente: ");
        String observaciones = scanner.nextLine();


        Cliente cliente = ClienteDAOImpl.getInstance().obtenerCliente(clienteId);
        Servicio servicio = ServicioDAOImpl.getInstance().obtenerServicio(servicioId);
        TipoProblema tipoProblema = TipoProblemaDAOImpl.getInstance().obtenerTipoProblema(tipoProblemaId);
        EstadoIncidente estadoIncidente = EstadoIncidenteDAOImpl.getInstance().obtenerEstadoIncidente(estadoId);
        Tecnico tecnicoAsignado = (tecnicoId != 0) ? TecnicoDAOImpl.getInstance().obtenerTecnico(tecnicoId) : null;


        Incidente nuevoIncidente = new Incidente();
        nuevoIncidente.setCliente(cliente);
        nuevoIncidente.setServicio(servicio);
        nuevoIncidente.setTipoProblema(tipoProblema);
        nuevoIncidente.setDescripcion(descripcion);
        nuevoIncidente.setTiempoEstimadoResolucion(tiempoEstimadoResolucion);
        nuevoIncidente.setEstado(estadoIncidente);
        nuevoIncidente.setTecnicoAsignado(tecnicoAsignado);
        nuevoIncidente.setObservaciones(observaciones);


        incidenteDAO.agregarIncidente(nuevoIncidente);

        System.out.println("Incidente agregado correctamente.");
    }

    private static void obtenerIncidentePorId() {

        System.out.print("Ingrese el ID del incidente: ");
        long id = scanner.nextLong();
        scanner.nextLine();


        Incidente incidenteRecuperado = incidenteDAO.obtenerIncidente(id);

        if (incidenteRecuperado != null) {

            System.out.println("Incidente recuperado: " + incidenteRecuperado);
        } else {
            System.out.println("Incidente no encontrado con el ID proporcionado.");
        }
    }

    private static void actualizarIncidente() {

        System.out.print("Ingrese el ID del incidente que desea actualizar: ");
        long id = scanner.nextLong();
        scanner.nextLine();


        Incidente incidenteRecuperado = incidenteDAO.obtenerIncidente(id);

        if (incidenteRecuperado != null) {

            System.out.println("Incidente actual: " + incidenteRecuperado);


            System.out.print("Ingrese la nueva descripción del incidente: ");
            String nuevaDescripcion = scanner.nextLine();
            incidenteRecuperado.setDescripcion(nuevaDescripcion);

            System.out.print("Ingrese el nuevo tiempo estimado de resolución del incidente: ");
            int nuevoTiempoEstimado = scanner.nextInt();
            scanner.nextLine();
            incidenteRecuperado.setTiempoEstimadoResolucion(nuevoTiempoEstimado);

            System.out.print("Ingrese el nuevo ID del Estado del incidente: ");
            long nuevoEstadoId = scanner.nextLong();
            scanner.nextLine();
            EstadoIncidente nuevoEstado = EstadoIncidenteDAOImpl.getInstance().obtenerEstadoIncidente(nuevoEstadoId);
            incidenteRecuperado.setEstado(nuevoEstado);

            System.out.print("Ingrese el nuevo ID del Técnico asignado al incidente (o 0 si no hay uno): ");
            long nuevoTecnicoId = scanner.nextLong();
            scanner.nextLine();
            Tecnico nuevoTecnico = (nuevoTecnicoId != 0) ? TecnicoDAOImpl.getInstance().obtenerTecnico(nuevoTecnicoId) : null;
            incidenteRecuperado.setTecnicoAsignado(nuevoTecnico);

            System.out.print("Ingrese las nuevas observaciones para el incidente: ");
            String nuevasObservaciones = scanner.nextLine();
            incidenteRecuperado.setObservaciones(nuevasObservaciones);


            incidenteDAO.actualizarIncidente(incidenteRecuperado);

            System.out.println("Incidente actualizado correctamente.");
        } else {
            System.out.println("Incidente no encontrado con el ID proporcionado.");
        }
    }


    private static void obtenerTodosLosIncidentes() {
        List<Incidente> todosLosIncidentes = incidenteDAO.obtenerTodosIncidentes();

        System.out.println("Todos los incidentes:");
        for (Incidente incidente : todosLosIncidentes) {
            System.out.println(incidente);
        }
    }

    private static void eliminarIncidente() {

        System.out.print("Ingrese el ID del incidente que desea eliminar: ");
        long id = scanner.nextLong();
        scanner.nextLine();


        Incidente incidenteRecuperado = incidenteDAO.obtenerIncidente(id);

        if (incidenteRecuperado != null) {

            System.out.println("Incidente a eliminar: " + incidenteRecuperado);


            System.out.print("¿Está seguro de que desea eliminar este incidente? (S/N): ");
            String confirmacion = scanner.nextLine();

            if (confirmacion.equalsIgnoreCase("S")) {

                incidenteDAO.eliminarIncidente(incidenteRecuperado);
                System.out.println("Incidente eliminado correctamente.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("Incidente no encontrado con el ID proporcionado.");
        }
    }

    public static void obtenerTecnicoConMasPuntos() {
        List<Incidente> todosLosIncidentes = incidenteDAO.obtenerTodosIncidentes();
        Map<Tecnico, Integer> tecnicoPuntos = new HashMap<>();

        System.out.println("Ranking tecnico");
        for (Incidente incidente : todosLosIncidentes) {
            if ("Completado".equals(incidente.getEstado().getNombre())) {

                Tecnico tecnico = incidente.getTecnicoAsignado();


                tecnicoPuntos.compute(tecnico, (key, value) -> (value == null) ? 1 : value + 1);
            }
        }


        for (Map.Entry<Tecnico, Integer> entry : tecnicoPuntos.entrySet()) {
            System.out.println("Técnico: " + entry.getKey().getNombre() + ", Puntos: " + entry.getValue());
        }}



}




