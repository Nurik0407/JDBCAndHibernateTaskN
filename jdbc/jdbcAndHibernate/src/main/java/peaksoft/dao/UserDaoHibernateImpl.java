package peaksoft.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try (Session session = Util.getSession().openSession()) {
            session.beginTransaction();
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSession().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("drop table users;").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Table successfully deleted");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        try (Session session = Util.getSession().openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
            System.out.println(name + " successfully saved...");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long idUser) {
        try (Session session = Util.getSession().openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, idUser);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
            System.out.println(user.getName() + " successfully deleted");
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getSession().openSession()) {
            session.beginTransaction();
            List<User> resultList = session.createQuery("FROM User ").getResultList();
            session.getTransaction().commit();
            session.close();
            return resultList;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSession().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE from User ").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Table successfully cleaned...");
        }
    }
}
