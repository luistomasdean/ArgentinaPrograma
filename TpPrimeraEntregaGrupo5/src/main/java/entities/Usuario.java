package entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "pwd", nullable = false)
    private String password;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "id_rol", nullable = false)
    private int idRol;

    @Column(name = "email")
    private String email;
}
