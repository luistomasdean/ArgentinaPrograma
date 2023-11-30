
package impl;

import dao.ServicioDAO;
import entities.Servicio;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class ServicioDAOImpl implements ServicioDAO {

    private static final ServicioDAOImpl instance = new ServicioDAOImpl();

    private ServicioDAOImpl() {}

    public static ServicioDAOImpl getInstance() {
        return instance;
    }

    @Override
    public void agregarServicio(Servicio servicio) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(servicio);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Servicio obtenerServicio(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Servicio.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Servicio> obtenerTodosServicios() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Servicio", Servicio.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void actualizarServicio(Servicio servicio) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(servicio);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarServicio(Servicio servicio) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(servicio);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
