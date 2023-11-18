package entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();


        Incidente nuevoIncidente = new Incidente();
        nuevoIncidente.setIdUser(1);
        nuevoIncidente.setIdCliente(1);



        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();


            session.save(nuevoIncidente);


            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            sessionFactory.close();
        }
    }
}