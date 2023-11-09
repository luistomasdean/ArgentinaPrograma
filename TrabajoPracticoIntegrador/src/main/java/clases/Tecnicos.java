package clases;

import lombok.Getter;
import lombok.Setter;



import java.util.List;
@Setter
@Getter
public class Tecnicos {
    private String nombre;
    private int cuil;

    private String medioComunicacion;
    private boolean disponibilidad;



    /*
    * Cada técnico tiene una o varias especialidades y solo se le pueden asignar incidentes que
coincidan con las mismas*/
}
