package entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tipo_problema")
@Data
public class TipoProblema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Integer tiempoMaximoResolucion;
}
