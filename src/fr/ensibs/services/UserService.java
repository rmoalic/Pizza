package fr.ensibs.services;

import fr.ensibs.data.User;

import java.util.List;

public interface UserService {
    boolean register(String username, String password, Roles role);
    String login(String username, String password);

    List<User> getUsersList();

}
