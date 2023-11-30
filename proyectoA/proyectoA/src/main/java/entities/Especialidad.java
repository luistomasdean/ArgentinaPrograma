package entities;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "especialidad")
@Data
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tecnico tecnico;

    private boolean disponibilidad;

}
