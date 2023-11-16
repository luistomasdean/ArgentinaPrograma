package dao;

import entities.Operador;

import java.util.List;

public interface OperadorDAO {
    void agregarOperador(Operador operador);
    Operador obtenerOperador(long id);
    List<Operador> obtenerTodosOperadores();
    void actualizarOperador(Operador operador);
    void eliminarOperador(Operador operador);
}
