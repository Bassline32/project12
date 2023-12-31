package org.example;

import com.github.javafaker.Faker;
import org.example.entity.Person;
import org.example.service.ConsoleService;

public class Dispatcher {


    public void invoke() {
        ConsoleService console = new ConsoleService();
        PersonService personService = new PersonService();
        Faker faker = new Faker();
        if (false) {
            Person fakeUser = personService.createFakeUser();
            System.out.println(fakeUser);

            String fact = faker.chuckNorris().fact();
            System.out.println(fact);

            personService.getFilteredFakeUsers();

            String nicknameInput = console.getNicknameInput();
            String loginInput = console.getLoginInput();

            Person consolePersonUser = personService.createUser(loginInput, nicknameInput);
            System.out.println(consolePersonUser.toString());
            personService.insertPersons();

        }
        personService.checkPerson();
        HebirnateUtil hebirnateUtil = new HebirnateUtil();
        System.out.println(hebirnateUtil.getAllPersons());
        System.out.println(hebirnateUtil.getByMiddleName("Benito"));
        System.out.println(hebirnateUtil.getByFirstName("Lucina"));
        System.out.println(hebirnateUtil.getByLastName("Lindgren"));
    }
}
