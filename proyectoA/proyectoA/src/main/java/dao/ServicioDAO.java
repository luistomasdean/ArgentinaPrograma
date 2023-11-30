package dao;

import entities.Servicio;
import java.util.List;

public interface ServicioDAO {
    void agregarServicio(Servicio servicio);
    Servicio obtenerServicio(long servicioId);
    List<Servicio> obtenerTodosServicios();
    void actualizarServicio(Servicio servicio);
    void eliminarServicio(Servicio servicio);
}
