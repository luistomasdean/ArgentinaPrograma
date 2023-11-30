package inicio;


import java.util.Scanner;

public class MenuPrincipal {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("Menu Principal");
            System.out.println("1. Menú Cliente");
            System.out.println("2. Menú Especialidad");
            System.out.println("3. Menú Servicio");
            System.out.println("4. Menú TipoProblema");
            System.out.println("5. Menú EstadoIncidente");
            System.out.println("6. Menú Tecnico");
            System.out.println("7. Menú Incidente");
            
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    MenuCliente.main(args);
                    break;
                case 2:
                    MenuEspecialidad.main(args);
                    break;
                case 3:
                    MenuServicio.main(args);
                    break;
                case 4:
                    MenuTipoProblema.main(args);
                    break;
                case 5:
                    MenuEstadoIncidente.main(args);
                    break;
                case 6:
                    MenuTecnico.main(args);
                    break;
                case 7:
                    MenuIncidente.main(args);
                    break;

                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);
    }
}
