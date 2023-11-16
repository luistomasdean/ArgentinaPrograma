package impl;

import dao.IncidenteTecnicoDAO;
import entities.Incidente;
import entities.Tecnico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.time.LocalDateTime;
import java.util.List;

public class IncidenteTecnicoDAOImpl implements IncidenteTecnicoDAO {
    @Override
    public List<Incidente> obtenerIncidentesResueltosEnUltimosNDias(int n) {
        return null;
    }

    @Override
    public List<Incidente> obtenerIncidentesResueltosPorEspecialidadEnUltimosNDias(String especialidad, int n) {
        return null;
    }

    @Override
    public Tecnico obtenerTecnicoConMasIncidentesResueltos() {
        return null;
    }

    @Override
    public Tecnico obtenerTecnicoConMasIncidentesResueltosEnEspecialidad(String especialidad) {
        return null;
    }

    @Override
    public Tecnico obtenerTecnicoMasRapidoEnResolverIncidentes() {
        return null;
    }

    /*... (implementación de otros métodos)

    @Override
    public List<Incidente> obtenerIncidentesResueltosEnUltimosNDias(int n) {
        // Implementación para obtener incidentes resueltos en los últimos N días
        LocalDateTime fechaLimite = LocalDateTime.now().minusDays(n);
        EntityManager entityManager = // Obtén el EntityManager según tu configuración
                Query query = entityManager.createQuery("SELECT i FROM Incidente i WHERE i.estado = 'Resuelto' AND i.fechaResolucion >= :fechaLimite", Incidente.class);
        query.setParameter("fechaLimite", fechaLimite);
        return query.getResultList();
    }

    @Override
    public List<Incidente> obtenerIncidentesResueltosPorEspecialidadEnUltimosNDias(String especialidad, int n) {
        // Implementación para obtener incidentes resueltos por especialidad en los últimos N días
        LocalDateTime fechaLimite = LocalDateTime.now().minusDays(n);
        EntityManager entityManager = // Obtén el EntityManager según tu configuración
                Query query = entityManager.createQuery("SELECT i FROM Incidente i WHERE i.estado = 'Resuelto' AND i.tecnico.especialidad = :especialidad AND i.fechaResolucion >= :fechaLimite", Incidente.class);
        query.setParameter("especialidad", especialidad);
        query.setParameter("fechaLimite", fechaLimite);
        return query.getResultList();
    }

    @Override
    public Tecnico obtenerTecnicoConMasIncidentesResueltos() {
        // Implementación para obtener al técnico con más incidentes resueltos
        EntityManager entityManager = // Obtén el EntityManager según tu configuración
                Query query = entityManager.createQuery("SELECT i.tecnico FROM Incidente i WHERE i.estado = 'Resuelto' GROUP BY i.tecnico ORDER BY COUNT(i) DESC", Tecnico.class);
        query.setMaxResults(1);
        return (Tecnico) query.getSingleResult();
    }

    @Override
    public Tecnico obtenerTecnicoConMasIncidentesResueltosEnEspecialidad(String especialidad) {
        // Implementación para obtener al técnico con más incidentes resueltos en una especialidad
        EntityManager entityManager = // Obtén el EntityManager según tu configuración
                Query query = entityManager.createQuery("SELECT i.tecnico FROM Incidente i WHERE i.estado = 'Resuelto' AND i.tecnico.especialidad = :especialidad GROUP BY i.tecnico ORDER BY COUNT(i) DESC", Tecnico.class);
        query.setParameter("especialidad", especialidad);
        query.setMaxResults(1);
        return (Tecnico) query.getSingleResult();
    }

    @Override
    public Tecnico obtenerTecnicoMasRapidoEnResolverIncidentes() {
        // Implementación para obtener al técnico que más rápido resuelve incidentes
        EntityManager entityManager = // Obtén el EntityManager según tu configuración
                Query query = entityManager.createQuery("SELECT i.tecnico FROM Incidente i WHERE i.estado = 'Resuelto' ORDER BY AVG(i.tiempoResolucion) ASC", Tecnico.class);
        query.setMaxResults(1);
        return (Tecnico) query.getSingleResult();
    }*/
}
