package dao;
import entities.RRHH;

import java.util.List;

public interface RRHHDAO {
    void agregarRRHH(RRHH rrhh);
    RRHH obtenerRRHH(long id);
    List<RRHH> obtenerTodosRRHH();
    void actualizarRRHH(RRHH rrhh);
    void eliminarRRHH(RRHH rrhh);
}
