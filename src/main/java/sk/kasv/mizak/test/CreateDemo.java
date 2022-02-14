package sk.kasv.mizak.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kasv.mizak.test.entity.City;
import sk.kasv.mizak.test.entity.Country;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(City.class).
                addAnnotatedClass(Country.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Country country1=new Country("Slovakia");
            Country country2=new Country("Czech");
            City city1=new City("Bratislava");
            City city2=new City("Košice");
            City city3=new City("Prague");
            City city4=new City("Brno");

            country1.setCity(city1);
            country1.setCity(city2);
            country2.setCity(city3);
            country2.setCity(city4);

            session.beginTransaction();

            session.save(country1);
            session.save(country2);


            session.getTransaction().commit();
            System.out.println("Done");
        }finally {


            session.close();

            factory.close();
        }
    }
}
