package interfaces;

import clases.Servicio;

import java.util.List;

public interface DaoServicio {
    public void registrar(Servicio servicio) throws Exception;

    public void modificar(Servicio servicio) throws Exception;

    public void eliminar(Servicio servicio) throws Exception;

    public List<Servicio> listar() throws Exception;
}
