
package dao;

import entities.EstadoIncidente;
import java.util.List;

public interface EstadoIncidenteDAO {
    void agregarEstadoIncidente(EstadoIncidente estadoIncidente);
    EstadoIncidente obtenerEstadoIncidente(long estadoIncidenteId);
    List<EstadoIncidente> obtenerTodosEstadosIncidente();
    void actualizarEstadoIncidente(EstadoIncidente estadoIncidente);
    void eliminarEstadoIncidente(EstadoIncidente estadoIncidente);
}
