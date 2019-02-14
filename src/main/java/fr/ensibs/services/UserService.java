package fr.ensibs.services;

import fr.ensibs.data.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

/**
 * A service to manage users for our pizza place thing
 */
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
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
    @WebMethod(operationName = "register")
    boolean register(@WebParam(name="userName") String username, @WebParam(name="password") String password, @WebParam(name="role") Roles role) throws Exception;

    /**
     * Log a new user in. A token will be generated.
     * A login will overwrite previous session token
     * @param username the name of the user
     * @param password the password of the user
     * @return the session token
     * @throws Exception if the user cannot log in
     */
    @WebMethod(operationName = "login")
    String login(@WebParam(name="userName") String username, @WebParam(name="password") String password) throws Exception;

    /**
     * (Admin only) List all users. (name, role and id)
     * @param uid session token
     * @return user list (names, roles and id)
     * @throws Exception if the user is not and admin
     */
    @WebMethod(operationName = "getUsersList")
    ArrayList<User> getUsersList(@WebParam(name="adminUID") String uid) throws Exception;

    /**
     * Delete a user.
     * @param uid session token
     * @param id user to be deleted (get if from getUsersList())
     * @return true if the user was deleted
     * @throws Exception if the user cannot be deleted
     */
    @WebMethod(operationName = "deleteUser")
    boolean deleteUser(@WebParam(name="adminUID") String uid, @WebParam(name="userID")int id) throws Exception;

    /**
     * Disconnect the user
     * @param uid session token
     * @return true if the user was disconnected
     */
    @WebMethod(operationName = "disconnect")
    boolean disconnect(@WebParam(name="UID") String uid);
}
