package fr.ensibs.data;

public class User {
    private int id;
    private String name;
    private String password;

    private static int nb = 0;

    public User(String name, String password) {
        id = nb;
        nb++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
