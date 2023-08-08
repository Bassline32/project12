package org.example;

import java.util.Scanner;

public class ConsoleService {
    public void getUserData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ник игрока: ");
        String nickname = scanner.nextLine();
        System.out.print("Введите логин игрока: ");
        String login = scanner.nextLine();
        System.out.println("Ник игрока: " + nickname);
        System.out.println("Логин игрока: " + login);

    }

    public String getLoginInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин игрока ");
        String login = scanner.nextLine();
        return login;
    }

    public String getNicknameInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ник игрока: ");
        String nickname = scanner.nextLine();
        return nickname;
    }
}



