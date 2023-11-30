// En el paquete dao
package dao;

import entities.Tecnico;
import java.util.List;

public interface TecnicoDAO {
    void agregarTecnico(Tecnico tecnico);
    Tecnico obtenerTecnico(long tecnicoId);
    List<Tecnico> obtenerTodosTecnicos();
    void actualizarTecnico(Tecnico tecnico);
    void eliminarTecnico(Tecnico tecnico);
}
