package org.example;

public class PersonService {
    Person createUser(String login, String nickname){
        Person person = new Person();
        person.login = login;
        person.nickname = nickname;
        return person;
    }
}
