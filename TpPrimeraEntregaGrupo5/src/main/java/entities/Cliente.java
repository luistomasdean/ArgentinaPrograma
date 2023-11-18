package entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "clientes")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "id_user", nullable = false)
    private int idUser;

    @Column(name = "cuit")
    private int cuit;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "email")
    private String email;
}
