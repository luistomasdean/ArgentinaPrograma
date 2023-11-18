package entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "servicios")
@Data
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private int idServicio;

    @Column(name = "desc_servicio")
    private String descripcionServicio;
}
