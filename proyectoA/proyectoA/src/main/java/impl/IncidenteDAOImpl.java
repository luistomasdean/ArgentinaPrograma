package impl;



import dao.IncidenteDAO;
import entities.Incidente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class IncidenteDAOImpl implements IncidenteDAO {

    private static final IncidenteDAOImpl instance = new IncidenteDAOImpl();

    private IncidenteDAOImpl() {}

    public static IncidenteDAOImpl getInstance() {
        return instance;
    }

    @Override
    public void agregarIncidente(Incidente incidente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(incidente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Incidente obtenerIncidente(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Incidente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Incidente> obtenerTodosIncidentes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Incidente", Incidente.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void actualizarIncidente(Incidente incidente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(incidente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarIncidente(Incidente incidente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(incidente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
