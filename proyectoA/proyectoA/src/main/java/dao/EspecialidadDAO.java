package dao;

import entities.Especialidad;
import java.util.List;

public interface EspecialidadDAO {
    void agregarEspecialidad(Especialidad especialidad);
    Especialidad obtenerEspecialidad(long especialidadId);
    List<Especialidad> obtenerTodasEspecialidades();
    void actualizarEspecialidad(Especialidad especialidad);
    void eliminarEspecialidad(Especialidad especialidad);
}