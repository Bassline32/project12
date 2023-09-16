package org.example;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HebirnateUtil {
    private static final SessionFactory sessionFactory;

    static {
        Configuration configurationPerson = new Configuration();
        configurationPerson.configure("hibernate.cfg.xml");
        configurationPerson.addAnnotatedClass(Person.class);
        sessionFactory = configurationPerson.buildSessionFactory();

    }

    public void savePerson(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    public void savePersons(List<Person> persons) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (Person person : persons) {
            session.save(person);
        }
        transaction.commit();
        session.close();
    }

    public void updatePerson(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();
        session.close();
    }

    public void updatePersons(List<Person> persons) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (Person person : persons) {
            session.update(person);
        }
        transaction.commit();
        session.close();
    }

    public Person getPersonById(Long id) {
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

    public List<Person> getAllPersons() {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("select * from persons");
        List<Person> persons = query.list();
        session.close();
        return persons;
    }

    public List<Person> getByMiddleName(String middleName) {
        List<Person> persons = null;
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Person where middleName=:middleName");
            query.setParameter("middleName", middleName);
            persons = query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return persons;
    }
    public List<Person> getByFirstName(String firstName) {
        List<Person> persons = null;
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Person where firstName=:firstName");
            query.setParameter("firstName", firstName);
            persons = query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return persons;
    }
    public List<Person> getByLastName(String lindgren) {
        List<Person> persons = null;
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Person where lastName=:lastName");
            query.setParameter("lastName", lastName);
            persons = query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return persons;
    }

}
