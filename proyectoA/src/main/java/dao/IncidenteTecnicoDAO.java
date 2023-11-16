package dao;

import entities.Incidente;
import entities.Tecnico;

import java.util.List;

public interface IncidenteTecnicoDAO {
    List<Incidente> obtenerIncidentesResueltosEnUltimosNDias(int n);

    List<Incidente> obtenerIncidentesResueltosPorEspecialidadEnUltimosNDias(String especialidad, int n);

    Tecnico obtenerTecnicoConMasIncidentesResueltos();

    Tecnico obtenerTecnicoConMasIncidentesResueltosEnEspecialidad(String especialidad);

    Tecnico obtenerTecnicoMasRapidoEnResolverIncidentes();
}

