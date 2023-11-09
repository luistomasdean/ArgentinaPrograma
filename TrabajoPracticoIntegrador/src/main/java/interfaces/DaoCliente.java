package interfaces;

import clases.Cliente;

import java.util.List;

public interface DaoCliente {
    public void registrar(Cliente cliente) throws Exception;

    public void modificar(Cliente cliente) throws Exception;

    public void eliminar(Cliente cliente) throws Exception;

    public List<Cliente> listar() throws Exception;
}
