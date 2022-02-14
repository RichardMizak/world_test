package sk.kasv.mizak.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kasv.mizak.test.entity.City;
import sk.kasv.mizak.test.entity.Country;

public class GetDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(City.class).
                addAnnotatedClass(Country.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int theId = 1;
            Country country = session.get(Country.class, theId);



            System.out.println(country);



            session.getTransaction().commit();
            System.out.println("Done");
        }finally {


            session.close();

            factory.close();
        }
    }
}
