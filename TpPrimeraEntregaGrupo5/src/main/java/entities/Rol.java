package entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int idRol;

    @Column(name = "des_rol")
    private String descripcionRol;

    @Column(name = "id_permisos", nullable = false)
    private int idPermisos;
}
