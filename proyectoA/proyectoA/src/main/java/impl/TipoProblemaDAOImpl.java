package impl;



import dao.TipoProblemaDAO;
import entities.TipoProblema;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class TipoProblemaDAOImpl implements TipoProblemaDAO {

    private static final TipoProblemaDAOImpl instance = new TipoProblemaDAOImpl();

    private TipoProblemaDAOImpl() {}

    public static TipoProblemaDAOImpl getInstance() {
        return instance;
    }

    @Override
    public void agregarTipoProblema(TipoProblema tipoProblema) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(tipoProblema);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public TipoProblema obtenerTipoProblema(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(TipoProblema.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TipoProblema> obtenerTodosTiposProblema() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM TipoProblema", TipoProblema.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void actualizarTipoProblema(TipoProblema tipoProblema) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(tipoProblema);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarTipoProblema(TipoProblema tipoProblema) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(tipoProblema);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
