package entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MesaDeAyuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "mesaDeAyuda")
    private List<Incidente> incidentes;



    // Otros campos y relaciones según sea necesario
}