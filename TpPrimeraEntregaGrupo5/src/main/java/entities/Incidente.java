package entities;

import entities.EstadoIncidente;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "incidentes")
@Data
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidente")
    private int idIncidente;

    @Column(name = "id_user", nullable = false)
    private int idUser;

    @Column(name = "id_cliente", nullable = false)
    private int idCliente;

    @Column(name = "descript", nullable = false)
    private String descripcion;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @Column(name = "fecha_cierre")
    private Date fechaCierre;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoIncidente estado;

    @Column(name = "id_servicio", nullable = false)
    private int idServicio;

    @Column(name = "id_tecnico")
    private Integer idTecnico;

    @Column(name = "tiempoResolucion")
    private int tiempoResolucion;

    @Column(name = "esComplejo")
    private boolean esComplejo;

    @Column(name = "comentarios")
    private String comentarios;

    @Column(name = "emailEnviado")
    private boolean emailEnviado;
}
