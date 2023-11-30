package entities;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "cliente")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razonSocial;
    private String cuit;
    private String email;
    private String telefono;
}

