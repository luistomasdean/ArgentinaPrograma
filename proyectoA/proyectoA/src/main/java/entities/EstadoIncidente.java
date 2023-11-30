package entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estado_incidente")
@Data
public class EstadoIncidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}