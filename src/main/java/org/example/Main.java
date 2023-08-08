package org.example;

public class Main {
    public static void main(String[] args) {
        ConsoleService console = new ConsoleService();
        PersonService consolePerson = new PersonService();

        String nicknameInput = console.getNicknameInput();
        String loginInput = console.getLoginInput();

        Person consolePersonUser = consolePerson.createUser(loginInput, nicknameInput);
        System.out.println(consolePersonUser.toString());

    }

}