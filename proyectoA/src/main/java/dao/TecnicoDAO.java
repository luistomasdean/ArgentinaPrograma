package dao;


import entities.Tecnico;

import java.util.List;

public interface TecnicoDAO {
    void agregarTecnico(Tecnico tecnico);
    Tecnico obtenerTecnico(long id);
    List<Tecnico> obtenerTodosTecnicos();
    void actualizarTecnico(Tecnico tecnico);
    void eliminarTecnico(Tecnico tecnico);
}
