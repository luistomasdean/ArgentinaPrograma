package conexion;

import clases.Tecnicos;
import interfaces.DaoTecnicos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecursosHumanosImpl extends Conexion implements DaoTecnicos {
    @Override
    public void registrar(Tecnicos tecnico) throws Exception {
        try {
            conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Tecnicos(nombre, cuil, medioComunicacion, disponibilidad) VALUES(?,?,?,?) ");
            st.setString(1, tecnico.getNombre());
            st.setInt(2, tecnico.getCuil());
            st.setString(3, tecnico.getMedioComunicacion());
            st.setBoolean(4, tecnico.isDisponibilidad());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Tecnicos tecnico) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE Tecnicos SET nombre = ?, medioComunicacion = ?, disponibilidad = ? WHERE cuil = ? ");
            st.setString(1, tecnico.getNombre());
            st.setString(2, tecnico.getMedioComunicacion());
            st.setBoolean(3, tecnico.isDisponibilidad());
            st.setInt(4, tecnico.getCuil());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Tecnicos tecnico) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM Tecnicos WHERE cuil = ? ");
            st.setInt(1, tecnico.getCuil());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<Tecnicos> listar() throws Exception {
        List<Tecnicos> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Tecnicos");
            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Tecnicos tecnico = new Tecnicos();
                tecnico.setNombre(rs.getString("nombre"));
                tecnico.setCuil(rs.getInt("cuil"));
                tecnico.setMedioComunicacion(rs.getString("medioComunicacion"));
                tecnico.setDisponibilidad(rs.getBoolean("disponibilidad"));
                lista.add(tecnico);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
}
