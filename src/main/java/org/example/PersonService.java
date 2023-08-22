package org.example;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    public Person createUser(String login, String nickname) {
        Person person = new Person();
        person.setLogin(login);
        person.setNickname(nickname);
        return person;
    }

    public Person createFakeUser() {

        Faker faker = new Faker();
        String login = faker.name().username();
        String nickname = faker.name().username();
        String firstName = faker.name().firstName();
        String lastName = faker.name().firstName();
        String middleName = faker.name().firstName();
        Person person = new Person();
        person.setLogin(login);
        person.setNickname(nickname);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMiddleName(middleName);
        return person;
    }

    public List<Person> getFilteredFakeUsers() {
        List<Person> fakePersons = new ArrayList<>();
        List<Person> filteredFakePersons = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            Person fakePerson = createFakeUser();


            fakePersons.add(fakePerson);

        }

        for (Person filtered : fakePersons) {
            checkLoginNaming(filtered, filteredFakePersons);
        }

        System.out.println(filteredFakePersons);
        return fakePersons;
    }

    private void checkLoginNaming(Person filtered, List<Person> filteredFakePersons) {
        if (filtered.getLogin().charAt(0) == 'x'
                || filtered.getNickname().charAt(0) == 'n') {
            filteredFakePersons.add(filtered);
        }
    }

    public void insertPersons() {
        List<Person> fakeUsers = getFilteredFakeUsers();
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "postgres");
            Statement statement = connection.createStatement();
            for (Person insert : fakeUsers) {
                statement.executeUpdate("INSERT INTO persons (first_name, last_name, middle_name)" +
                        " VALUES ('" + insert.getFirstName() + "','" + insert.getLastName() + "','" + insert.getMiddleName() + "');");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}