package com.zafar.springCourse;

import com.zafar.springCourse.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            session.createQuery("update Person set name='Test' where age < 30")
                    .executeUpdate();

//            List<Person> personList = session.createQuery("FROM Person where name LIKE 'T%'").getResultList();
//            for (Person person: personList) {
//                System.out.println(person.toString());
//            }


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
