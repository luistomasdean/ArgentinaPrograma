package conexion;

import clases.ClienteServicio;
import interfaces.DaoClienteServicio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteServicioImpl extends Conexion implements DaoClienteServicio {

    @Override
    public void registrar(ClienteServicio clienteServicio) throws Exception {
        try {
            conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO ClienteServicio(cuit, servicio_id, fecha_contratacion) VALUES(?,?,?) ");
            st.setInt(1, clienteServicio.getCuit());
            st.setInt(2, clienteServicio.getServicioId());
            st.setDate(3, new java.sql.Date(clienteServicio.getFechaIcontratacion().getTime()));
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(ClienteServicio clienteServicio) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE ClienteServicio SET fecha_contratacion = ? WHERE cuit = ? AND servicio_id = ?");
            st.setDate(1, new java.sql.Date(clienteServicio.getFechaIcontratacion().getTime()));
            st.setInt(2, clienteServicio.getCuit());
            st.setInt(3, clienteServicio.getServicioId());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(ClienteServicio clienteServicio) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM ClienteServicio WHERE cuit = ? AND servicio_id = ?");
            st.setInt(1, clienteServicio.getCuit());
            st.setInt(2, clienteServicio.getServicioId());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<ClienteServicio> listar() throws Exception {
        List<ClienteServicio> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM ClienteServicio");
            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClienteServicio clienteServicio = new ClienteServicio();
                clienteServicio.setCuit(rs.getInt("cuit"));
                clienteServicio.setServicioId(rs.getInt("servicio_id"));
                clienteServicio.setFechaIcontratacion(rs.getDate("fecha_contratacion"));
                lista.add(clienteServicio);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
}

