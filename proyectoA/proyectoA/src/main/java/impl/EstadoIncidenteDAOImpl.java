
package impl;

import dao.EstadoIncidenteDAO;
import entities.EstadoIncidente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class EstadoIncidenteDAOImpl implements EstadoIncidenteDAO {

    private static final EstadoIncidenteDAOImpl instance = new EstadoIncidenteDAOImpl();

    private EstadoIncidenteDAOImpl() {}

    public static EstadoIncidenteDAOImpl getInstance() {
        return instance;
    }

    @Override
    public void agregarEstadoIncidente(EstadoIncidente estadoIncidente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(estadoIncidente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public EstadoIncidente obtenerEstadoIncidente(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(EstadoIncidente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<EstadoIncidente> obtenerTodosEstadosIncidente() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM EstadoIncidente", EstadoIncidente.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void actualizarEstadoIncidente(EstadoIncidente estadoIncidente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(estadoIncidente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEstadoIncidente(EstadoIncidente estadoIncidente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(estadoIncidente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
