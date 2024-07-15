package com.zafar.springCourse;

import com.zafar.springCourse.model.Director;
import com.zafar.springCourse.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Director director = new Director("Charlie", 30);

            director.addMovie(new Movie("Yoo", 1980));
            director.addMovie(new Movie("Yoo 2", 1989));
            director.addMovie(new Movie("Yoo 3", 1999));

            session.save(director);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
