package entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "mesa_de_ayuda_id") // Asegúrate de que el nombre de la columna sea el correcto
    private MesaDeAyuda mesaDeAyuda;

    private String descripcion;
    private String tipoProblema;
    private String estado;
    private Date fechaResolucion;

    // Otros campos y relaciones según sea necesario
}
