package fr.ensibs.data;

import fr.ensibs.services.Roles;

import java.util.UUID;

public class User {
    private int id;
    private String name;
    private String password;
    private Roles role;
    private UUID uid;

    private static int nb = 0;

    public User(String name, String password, Roles role) {
        id = nb;
        nb++;

        this.name = name;
        this.password = password;
        this.role = role;
    }

    public boolean checkUid(UUID uid) throws Exception {
        if (this.uid == null)
            throw new Exception("User not logged in");
        return this.uid.equals(uid);
    }

    public void disconnect() {
        this.uid = null;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public void setUid() {
        this.uid = UUID.randomUUID();
    }

    public UUID getUid() {
        return this.uid;
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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
