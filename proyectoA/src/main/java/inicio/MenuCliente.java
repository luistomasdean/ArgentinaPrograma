package inicio;

import dao.ClienteDAO;

import entities.Cliente;
import impl.ClienteDAOImpl;

import java.util.List;
import java.util.Scanner;

public class MenuCliente {
    private static final ClienteDAO clienteDAO = ClienteDAOImpl.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("Menu Cliente");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Obtener Cliente por ID");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Obtener Todos los Clientes");
            System.out.println("5. Eliminar Cliente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer el número

            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    obtenerClientePorId();
                    break;
                case 3:
                    actualizarCliente();
                    break;
                case 4:
                    obtenerTodosLosClientes();
                    break;
                case 5:
                    eliminarCliente();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);
    }

    private static void agregarCliente() {
        System.out.print("Ingrese el CUIT del nuevo cliente: ");
        String cuit = scanner.nextLine();

        System.out.print("Ingrese la razón social del nuevo cliente: ");
        String razonSocial = scanner.nextLine();

        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setCuit(cuit);
        nuevoCliente.setRazonSocial(razonSocial);

        clienteDAO.agregarCliente(nuevoCliente);
        System.out.println("Cliente agregado correctamente.");
    }

    private static void obtenerClientePorId() {
        System.out.print("Ingrese el ID del cliente: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        Cliente clienteRecuperado = clienteDAO.obtenerCliente(id);

        if (clienteRecuperado != null) {
            System.out.println("Cliente recuperado: " + clienteRecuperado);
        } else {
            System.out.println("Cliente no encontrado con el ID proporcionado.");
        }
    }

    private static void actualizarCliente() {
        // Implementar lógica para actualizar un cliente
        System.out.print("Ingrese el ID del cliente que desea actualizar: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        Cliente clienteRecuperado = clienteDAO.obtenerCliente(id);

        if (clienteRecuperado != null) {
            System.out.println("Cliente actual: " + clienteRecuperado);
            System.out.print("Ingrese la nueva razón social del cliente: ");
            String nuevaRazonSocial = scanner.nextLine();
            clienteRecuperado.setRazonSocial(nuevaRazonSocial);

            clienteDAO.actualizarCliente(clienteRecuperado);
            System.out.println("Cliente actualizado correctamente.");
        } else {
            System.out.println("Cliente no encontrado con el ID proporcionado.");
        }
    }

    private static void obtenerTodosLosClientes() {
        List<Cliente> todosLosClientes = clienteDAO.obtenerTodosClientes();
        System.out.println("Todos los clientes: " + todosLosClientes);
    }

    private static void eliminarCliente() {
        System.out.print("Ingrese el ID del cliente que desea eliminar: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número

        Cliente clienteRecuperado = clienteDAO.obtenerCliente(id);

        if (clienteRecuperado != null) {
            clienteDAO.eliminarCliente(clienteRecuperado);
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("Cliente no encontrado con el ID proporcionado.");
        }
    }
}
