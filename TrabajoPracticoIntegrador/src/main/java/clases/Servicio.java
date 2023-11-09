package clases;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Servicio {
    private int id;
    private String nombreServicio;

    public Servicio() {
    }

    public Servicio(String nombreServicio) {

        this.nombreServicio = nombreServicio;
    }
}
