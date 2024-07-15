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



//            #2
//            Director director = session.get(Director.class, 3);
//            List<Movie> movies = director.getMovies();
//            for (Movie movie: movies) {
//                System.out.println(movie.toString());
//            }



//            #3
//            Movie movie = session.get(Movie.class, 4);
//            Director director = movie.getDirector();
//            System.out.println(director.toString());



//            #4
//            Director director = session.get(Director.class, "1");
//            Movie movie = new Movie("Django Unchained", 2016, director);
//            director.getMovies().add(movie);
//
//            session.save(movie);



//            #5
//            Director director = new Director("Qwerty", 19);
//            Movie movie = new Movie("Adventure Time", 2010, director);
//
//            director.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.save(director);
//            session.save(movie);



//            #6
//            Movie movie = session.get(Movie.class, 13);
//            Director director = session.get(Director.class, 1);
//            movie.setDirector(director);
//
//            session.save(movie);
            


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
