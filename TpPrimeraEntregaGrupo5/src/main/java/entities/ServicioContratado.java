package entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "serv_Contratados")
@Data
public class ServicioContratado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servContratado")
    private int idServContratado;

    @Column(name = "id_cliente", nullable = false)
    private int idCliente;

    @Column(name = "id_servicio", nullable = false)
    private int idServicio;
}
