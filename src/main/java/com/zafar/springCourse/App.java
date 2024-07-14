package com.zafar.springCourse;

import com.zafar.springCourse.model.Item;
import com.zafar.springCourse.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // SQL
            Person person = new Person("Test Person", 30);
            Item item = new Item("Item from Hibernate 2", person);

            // Hibernate Cache
            person.setItems(new ArrayList<>(Collections.singletonList(item)));

            session.save(person);
            session.save(item);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
