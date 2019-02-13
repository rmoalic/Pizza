package fr.ensibs.services;

import fr.ensibs.data.User;

import javax.jws.WebService;
import java.util.List;

@WebService(name = "UserService", targetNamespace="Pizza")
public interface UserService {
    boolean register(String username, String password, Roles role) throws Exception;
    String login(String username, String password) throws Exception;

    List<User> getUsersList(String uid) throws Exception;

    boolean deleteUser(String uid, int id) throws Exception;

    boolean disconnect(String uid);
}
