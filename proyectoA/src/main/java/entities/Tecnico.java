package entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;

   /* @OneToMany(mappedBy = "tecnico")
    private List<Incidente> incidentes;*/

    @OneToMany(mappedBy = "tecnico", fetch = FetchType.EAGER)
    private List<Incidente> incidentes;

    @ManyToOne
    @JoinColumn(name = "rrhh_id")
    private RRHH rrhh;

    // Otros campos y relaciones según sea necesario
}
