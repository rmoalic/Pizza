package fr.ensibs.services;

import fr.ensibs.data.User;

import javax.jws.WebService;
import java.util.List;

/**
 * A service to manage users for our pizza place thing
 */
@WebService(name = "UserService", targetNamespace="Pizza")
public interface UserService {
    /**
     * Register a new user
     * @param username the name of the user
     * @param password the password for the user (no restrictions)
     * @param role Admin or Customer
     * @return true if the user is registered
     * @throws Exception if the user cannot be registered
     */
    boolean register(String username, String password, Roles role) throws Exception;

    /**
     * Log a new user in. A token will be generated.
     * A login will overwrite previous session token
     * @param username the name of the user
     * @param password the password of the user
     * @return the session token
     * @throws Exception if the user cannot log in
     */
    String login(String username, String password) throws Exception;

    /**
     * (Admin only) List all users. (name, role and id)
     * @param uid session token
     * @return user list (names, roles and id)
     * @throws Exception if the user is not and admin
     */
    List<User> getUsersList(String uid) throws Exception;

    /**
     * Delete a user.
     * @param uid session token
     * @param id user to be deleted (get if from getUsersList())
     * @return true if the user was deleted
     * @throws Exception if the user cannot be deleted
     */
    boolean deleteUser(String uid, int id) throws Exception;

    /**
     * Disconnect the user
     * @param uid session token
     * @return true if the user was disconnected
     */
    boolean disconnect(String uid);
}
