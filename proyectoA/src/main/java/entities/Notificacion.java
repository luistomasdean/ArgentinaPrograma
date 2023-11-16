package entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;
    private LocalDateTime fechaEnvio;
    private boolean leido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    // Otros campos y relaciones según sea necesario

    // Getters y setters

    public Notificacion() {
        // Constructor vacío necesario para JPA
    }

    public Notificacion(String contenido, LocalDateTime fechaEnvio, boolean leido, Cliente cliente, Tecnico tecnico) {
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
        this.leido = leido;
        this.cliente = cliente;
        this.tecnico = tecnico;
    }

    // Métodos getter y setter
}