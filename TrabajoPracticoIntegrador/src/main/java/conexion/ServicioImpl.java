package conexion;

import clases.Servicio;
import interfaces.DaoServicio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServicioImpl extends Conexion implements DaoServicio {


        @Override
        public void registrar(Servicio servicio) throws Exception {
            try {
                conectar();
                PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Servicios(servicio_id, nombre_servicio) VALUES(?, ?)");
                st.setInt(1, servicio.getId());
                st.setString(2, servicio.getNombreServicio());
                st.executeUpdate();
            } catch (Exception e) {
                throw e;
            } finally {
                this.cerrar();
            }
        }

        @Override
        public void modificar(Servicio servicio) throws Exception {
            try {
                this.conectar();
                PreparedStatement st = this.conexion.prepareStatement("UPDATE Servicios SET nombre_servicio = ? WHERE servicio_id = ?");
                st.setString(1, servicio.getNombreServicio());
                st.setInt(2, servicio.getId());
                st.executeUpdate();
            } catch (Exception e) {
                throw e;
            } finally {
                this.cerrar();
            }
        }

        @Override
        public void eliminar(Servicio servicio) throws Exception {
            try {
                this.conectar();
                PreparedStatement st = this.conexion.prepareStatement("DELETE FROM Servicios WHERE servicio_id = ?");
                st.setInt(1, servicio.getId());
                st.executeUpdate();
            } catch (Exception e) {
                throw e;
            } finally {
                this.cerrar();
            }
        }

        @Override
        public List<Servicio> listar() throws Exception {
            List<Servicio> lista = null;
            try {
                this.conectar();
                PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Servicios");
                lista = new ArrayList<>();
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Servicio servicio = new Servicio();
                    servicio.setId(rs.getInt("servicio_id"));
                    servicio.setNombreServicio(rs.getString("nombre_servicio"));
                    lista.add(servicio);
                }
            } catch (Exception e) {
                throw e;
            } finally {
                this.cerrar();
            }
            return lista;
        }
    }


