package org.example;

public class Person {
    private String login;
    private String nickname;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

