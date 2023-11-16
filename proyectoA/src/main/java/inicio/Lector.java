package inicio;

import java.util.Scanner;

public class Lector { // Wrapper.

    private static Scanner S = new Scanner(System.in);
    
    public static String leer(String pregunta) {
        System.out.println(pregunta);
        return S.nextLine();
    }
    
}
