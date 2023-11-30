package entities;

import jakarta.persistence.*;
import lombok.*;






@Entity
@Table(name = "tecnico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;



    }




