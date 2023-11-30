package entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "servicio")
@Data
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

}