package com.zafar.springCourse;

import com.zafar.springCourse.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // Update
            // Person person = session.get(Person.class, 2);
            // person.setName("Qwerty");

            // Delete
            // Person person = session.get(Person.class, 2);
            // session.delete(person);

            Person person = new Person("Some name", 60);
            session.save(person);

            session.getTransaction().commit();

            System.out.println(person.getId());
        } finally {
            sessionFactory.close();
        }
    }
}
