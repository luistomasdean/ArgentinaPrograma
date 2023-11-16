package entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RRHH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "rrhh")
    private List<Tecnico> tecnicos;

    // Otros campos y relaciones según sea necesario
}
