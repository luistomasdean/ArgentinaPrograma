package interfaces;

import clases.Tecnicos;

import java.util.List;

public interface DaoTecnicos {
    public void registrar(Tecnicos tecnico) throws Exception;

    public void modificar(Tecnicos tecnico) throws Exception;

    public void eliminar(Tecnicos tecnico) throws Exception;

    public List<Tecnicos > listar() throws Exception;
}
