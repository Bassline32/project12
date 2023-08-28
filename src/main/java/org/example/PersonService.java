package org.example;

import com.github.javafaker.Faker;

import java.sql.*;
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
                insertPerson(insert, statement);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void insertPerson(Person insert, Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO persons (first_name, last_name, middle_name)" +
                " VALUES ('" + insert.getFirstName() + "','" + insert.getLastName() + "','" + insert.getMiddleName() + "');");
    }

    public List<Person> getAllPersons(Statement statement) {
        List<Person> personList = new ArrayList<>();
        try {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM persons ");
            while (resultSet.next()) {
                Person basePerson = new Person();
                basePerson.setMiddleName(resultSet.getString("middle_name"));
                basePerson.setFirstName(resultSet.getString("first_name"));
                basePerson.setLastName(resultSet.getString("last_name"));
                personList.add(basePerson);
            }
            statement.close();
            resultSet.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return personList;

    }

    public Person getByMiddleName(PreparedStatement statement, String lastName) {
        Person middlePerson = new Person();
        try {
            statement.setString(1, lastName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                middlePerson.setMiddleName(resultSet.getString("middle_name"));
                middlePerson.setFirstName(resultSet.getString("first_name"));
                middlePerson.setLastName(resultSet.getString("last_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return middlePerson;
    }
    public Person getByFirstName(PreparedStatement statement, String lastName) {
        Person firstPerson = new Person();
        try {
            statement.setString(1, lastName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                firstPerson.setMiddleName(resultSet.getString("middle_name"));
                firstPerson.setFirstName(resultSet.getString("first_name"));
                firstPerson.setLastName(resultSet.getString("last_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return firstPerson;
    }

    public Person getByLastName(PreparedStatement statement, String lastName) {
        Person lastPerson = new Person();
        try {
            statement.setString(1, lastName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                lastPerson.setMiddleName(resultSet.getString("middle_name"));
                lastPerson.setFirstName(resultSet.getString("first_name"));
                lastPerson.setLastName(resultSet.getString("last_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lastPerson;
    }

    public void checkPerson() {
        Faker dataFaker = new Faker();
        try {
            Person personFirstNme = getByFirstName(DatabaseUtils.getConnection().prepareStatement("SELECT * FROM persons WHERE first_name = ?"), dataFaker.name().firstName());
            Person personLastName = getByLastName(DatabaseUtils.getConnection().prepareStatement("SELECT * FROM persons WHERE last_name = ?"), dataFaker.name().lastName());
            Person personMiddleName = getByMiddleName(DatabaseUtils.getConnection().prepareStatement("SELECT * FROM persons WHERE middle_name = ?"), dataFaker.name().lastName());
            List<Person> persons = getAllPersons(DatabaseUtils.getConnection().createStatement());
            if (personFirstNme.getFirstName() != null&& personFirstNme.getLastName() != null&& personFirstNme.getMiddleName() != null){
                System.out.println(personFirstNme);
            }
            else {
                System.out.println(" не найдено по firstName.");
            }
            if (personLastName.getFirstName() != null&& personLastName.getLastName() != null&& personLastName.getMiddleName() != null){
                System.out.println(personLastName);
            }
            else {
                System.out.println(" не найдено по lastName. ");
            }
            if (personMiddleName.getFirstName() != null&& personMiddleName.getLastName() != null&& personMiddleName.getMiddleName() != null){
                System.out.println(personMiddleName);
            }
            else {
                System.out.println(" не найдено по middleName. ");
            }
            System.out.println(persons);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

}