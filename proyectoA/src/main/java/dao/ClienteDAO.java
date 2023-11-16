package dao;

import entities.Cliente;

import java.util.List;



public interface ClienteDAO {
    void agregarCliente(Cliente cliente);
    Cliente obtenerCliente(long clienteId);
    List<Cliente> obtenerTodosClientes();
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(Cliente cliente);
}
