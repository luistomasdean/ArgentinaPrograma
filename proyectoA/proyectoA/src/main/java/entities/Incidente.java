package entities;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Entity
@Table(name = "incidente")
@Data
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)

    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    private Servicio servicio;

    @ManyToOne(fetch = FetchType.EAGER)
    private TipoProblema tipoProblema;

    private String descripcion;
    private Integer tiempoEstimadoResolucion;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoIncidente estado;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tecnico tecnicoAsignado;

    private String observaciones;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaInicio", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Date fechaInicio;
    public Incidente() {
        this.fechaInicio = new Date();
    }
}
