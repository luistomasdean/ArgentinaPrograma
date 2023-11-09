package interfaces;

import clases.ClienteServicio;

import java.util.List;

public interface DaoClienteServicio {
    public void registrar(ClienteServicio clienteServicio) throws Exception;

    public void modificar(ClienteServicio clienteServicio) throws Exception;

    public void eliminar(ClienteServicio clienteServicio) throws Exception;

    public List<ClienteServicio> listar() throws Exception;
}
