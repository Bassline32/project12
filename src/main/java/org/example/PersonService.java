package org.example;

import com.github.javafaker.Faker;

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
        String nickname = faker.name().firstName();
        Person person = new Person();
        person.setLogin(login);
        person.setNickname(nickname);
        return person;
    }
}