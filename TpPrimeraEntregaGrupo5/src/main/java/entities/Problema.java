package entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "problemas")
@Data
public class Problema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_problema", unique = true)
    private int idProblema;

    @Column(name = "id_incidente", nullable = false)
    private int idIncidente;

    @Column(name = "desc_problema", nullable = false)
    private String descripcionProblema;

    @Column(name = "tiempoEsperadoMin")
    private int tiempoEsperadoMin;

    @Column(name = "tiempoMaximoMin")
    private int tiempoMaximoMin;
}
