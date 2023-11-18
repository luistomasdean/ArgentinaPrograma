package entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "competencias")
@Data
public class Competencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competencia")
    private int idCompetencia;

    @Column(name = "id_servicio", nullable = false)
    private int idServicio;

    @Column(name = "id_tecnico", nullable = false)
    private int idTecnico;
}
