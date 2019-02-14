package fr.ensibs.data;

import fr.ensibs.services.Roles;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;

/**
 * An user of our pizza place !
 */
@XmlRootElement
public class User {
    private int id;
    private String name;
    private String password;
    private Roles role;
    private UUID uid;

    private static int nb = 0;

    private User() {}

    /**
     * Constructor
     * @param name username
     * @param password user password
     * @param role user role
     */
    public User(String name, String password, Roles role) {
        id = nb;
        nb++;

        this.name = name;
        this.password = password;
        this.role = role;
    }

    /**
     * Disconnect the user.
     */
    public void disconnect() {
        this.uid = null;
    }

    /**
     * Connect the user with a new random token.
     */
    public void setUid() {
        this.uid = UUID.randomUUID();
    }

    /**
     * Get the current login token.
     * @return the login token
     */
    @XmlTransient
    public UUID getUid() {
        return this.uid;
    }

    /**
     * Get the user identifier. Unique to an User instance
     * @return the identifier
     */
    @XmlElement(name="id")
    public int getId() {
        return id;
    }

    /**
     * Get the user name
     * @return user name
     */
    @XmlElement(name="name")
    public String getName() {
        return name;
    }

    /**
     * Change the user name
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Check if the password is correct
     * @param password the password to check against
     * @return true if the user password and the password are equals
     */
    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Change the user password
     * @param password new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get user role
     * @return the role
     */
    @XmlElement(name="role")
    public Roles getRole() {
        return role;
    }

    /**
     * Change user role
     * @param role new role
     */
    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.getName() + " > " + this.getRole();
    }
}
