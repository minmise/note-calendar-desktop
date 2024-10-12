package org.application.notecalendardesktop.client;

public class User {

    private final String login;
    private final Long id;

    public User(String login, Long id) {
        this.login = login;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public Long getId() {
        return id;
    }

}
