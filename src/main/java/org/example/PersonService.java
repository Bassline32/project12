package org.example;

public class PersonService {
    Person createUser(String login, String nickname){
        Person person = new Person();
        person.setLogin(login);
        person.setNickname(nickname);
        return person;
    }
}
