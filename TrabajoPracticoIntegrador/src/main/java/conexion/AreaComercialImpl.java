package conexion;

import clases.Cliente;
import interfaces.DaoCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AreaComercialImpl extends Conexion implements DaoCliente {


    @Override
    public void registrar(Cliente cliente) throws Exception {
        try {
            conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO clientes(cuit,razon_social,mail) VALUES(?,?,?) ");
            st.setInt(1, cliente.getCuil());
            st.setString(2, cliente.getRazonSocial());
            st.setString(3, cliente.getMail());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }


    @Override
    public void modificar(Cliente cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE clientes SET razon_social where cuit= ? ");
            st.setInt(1, cliente.getCuil());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void eliminar(Cliente cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("delete from clientes where cuit = ? ");
            st.setInt(1, cliente.getCuil());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public List<Cliente> listar() throws Exception {
        List<Cliente> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM clientes");

            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cliente cliente1 = new Cliente();
                cliente1.setCuil(rs.getInt("cuit"));
                cliente1.setRazonSocial(rs.getString("razon_social"));
                cliente1.setMail(rs.getString("mail"));

                lista.add(cliente1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

        return lista;
    }


}
