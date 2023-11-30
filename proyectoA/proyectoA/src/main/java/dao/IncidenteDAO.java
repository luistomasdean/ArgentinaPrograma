package dao;



import entities.Incidente;
import java.util.List;

public interface IncidenteDAO {
    void agregarIncidente(Incidente incidente);
    Incidente obtenerIncidente(long incidenteId);
    List<Incidente> obtenerTodosIncidentes();
    void actualizarIncidente(Incidente incidente);
    void eliminarIncidente(Incidente incidente);
}