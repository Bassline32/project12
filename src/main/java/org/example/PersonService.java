package org.example;

import com.github.javafaker.Faker;

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
        Person person = new Person();
        person.setLogin(login);
        person.setNickname(nickname);
        return person;
    }

    public void getFilteredFakeUsers() {
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
    }

    private void checkLoginNaming(Person filtered, List<Person> filteredFakePersons) {
        if (filtered.getLogin().charAt(0) == 'x'
                || filtered.getNickname().charAt(0) == 'n') {
            filteredFakePersons.add(filtered);
        }
    }
}