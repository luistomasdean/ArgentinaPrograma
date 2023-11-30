
package dao;

import entities.TipoProblema;
import java.util.List;

public interface TipoProblemaDAO {
    void agregarTipoProblema(TipoProblema tipoProblema);
    TipoProblema obtenerTipoProblema(long tipoProblemaId);
    List<TipoProblema> obtenerTodosTiposProblema();
    void actualizarTipoProblema(TipoProblema tipoProblema);
    void eliminarTipoProblema(TipoProblema tipoProblema);
}
