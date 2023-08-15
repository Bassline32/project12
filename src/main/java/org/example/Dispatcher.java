package org.example;

import com.github.javafaker.Faker;

public class Dispatcher {

    public void invoke() {
        ConsoleService console = new ConsoleService();
        PersonService consolePerson = new PersonService();
        Faker faker = new Faker();

        Person fakeUser = consolePerson.createFakeUser();
        System.out.println(fakeUser);

        String fact = faker.chuckNorris().fact();
        System.out.println(fact);

        String nicknameInput = console.getNicknameInput();
        String loginInput = console.getLoginInput();

        Person consolePersonUser = consolePerson.createUser(loginInput, nicknameInput);
        System.out.println(consolePersonUser.toString());
    }
}
