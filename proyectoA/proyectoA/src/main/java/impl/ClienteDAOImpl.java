package impl;

import dao.ClienteDAO;
import entities.Cliente;
import java.util.Collections;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    private static final ClienteDAOImpl instance = new ClienteDAOImpl();

    private ClienteDAOImpl() {}

    public static ClienteDAOImpl getInstance() {
        return instance;
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Cliente obtenerCliente(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Cliente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Cliente> obtenerTodosClientes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Cliente", Cliente.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
