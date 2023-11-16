package impl;

import dao.MesaDeAyudaDAO;
import entities.MesaDeAyuda;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class MesaDeAyudaDAOImpl implements MesaDeAyudaDAO {
    @Override
    public void agregarMesaDeAyuda(MesaDeAyuda mesaDeAyuda) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(mesaDeAyuda);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public MesaDeAyuda obtenerMesaDeAyuda(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(MesaDeAyuda.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<MesaDeAyuda> obtenerTodasMesasDeAyuda() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM MesaDeAyuda", MesaDeAyuda.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void actualizarMesaDeAyuda(MesaDeAyuda mesaDeAyuda) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(mesaDeAyuda);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarMesaDeAyuda(MesaDeAyuda mesaDeAyuda) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(mesaDeAyuda);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
