package com.zafar.springCourse;

import com.zafar.springCourse.model.Passport;
import com.zafar.springCourse.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();



            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
