
package impl;

import dao.EspecialidadDAO;
import entities.Especialidad;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class EspecialidadDAOImpl implements EspecialidadDAO {

    private static final EspecialidadDAOImpl instance = new EspecialidadDAOImpl();

    private EspecialidadDAOImpl() {}

    public static EspecialidadDAOImpl getInstance() {
        return instance;
    }

    @Override
    public void agregarEspecialidad(Especialidad especialidad) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(especialidad);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Especialidad obtenerEspecialidad(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Especialidad.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Especialidad> obtenerTodasEspecialidades() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Especialidad", Especialidad.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void actualizarEspecialidad(Especialidad especialidad) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(especialidad);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEspecialidad(Especialidad especialidad) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(especialidad);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
