package entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "permisos")
@Data
public class Permisos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permisos")
    private int idPermisos;

    @Column(name = "fullAccess")
    private boolean fullAccess;

    @Column(name = "rrhhAccess")
    private boolean rrhhAccess;

    @Column(name = "tecAccess")
    private boolean tecAccess;

    @Column(name = "asesorAccess")
    private boolean asesorAccess;

    @Column(name = "comerAccess")
    private boolean comerAccess;
}
