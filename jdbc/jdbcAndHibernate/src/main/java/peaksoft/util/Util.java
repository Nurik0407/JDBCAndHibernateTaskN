package peaksoft.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    // реализуйте настройку соеденения с БД
    public static SessionFactory getSession() {
        try {
            System.out.println("Successfully connected... ");
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
