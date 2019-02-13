package fr.ensibs.services;

import fr.ensibs.data.User;

import javax.jws.WebService;
import java.util.*;

@WebService(endpointInterface="fr.ensibs.services.UserService", serviceName="UserService", portName="UserPort")
public class UserServiceImpl implements UserService {
    private HashMap<Integer, User> users;

    public UserServiceImpl() {
        this.users = new HashMap<>();
    }

    @Override
    public boolean register(String username, String password, Roles role) throws Exception {
        User u = findUser(username);
        if (u != null)
            throw new Exception("User already exist");

        User usr = new User(username, password, role);
        this.users.put(usr.getId(), usr);

        return true;
    }

    @Override
    public String login(String username, String password) throws Exception {
        User u = findUser(username);

        if (u != null && u.verifyPassword(password)) {
            u.setUid();
        } else {
            throw new Exception("User/Password incorrect");
        }

        return u.getUid().toString();
    }

    @Override
    public List<User> getUsersList(String uid) throws Exception {
        User u = findUserByUID(uid);
        if (u != null && u.getRole() == Roles.ADMIN)
            return new ArrayList<>(this.users.values());
        else
            throw new Exception("Not and admin");
    }

    @Override
    public boolean deleteUser(String uid, int id) throws Exception {
        User u = findUserByUID(uid);
        if (u != null && u.getRole() == Roles.ADMIN) {
            User us = this.users.remove(id);
            return us != null;
        } else {
            throw new Exception("Not and admin");
        }
    }

    @Override
    public boolean disconnect(String uid) {
        User u = findUserByUID(uid);
        if (u == null)
            return false;
        u.disconnect();
        return true;
    }

    private User findUser(String username) {
        User user = null;
        Optional<User> any = this.users.values()
                .stream()
                .filter(u -> u.getName().equals(username))
                .findAny();

        if (any.isPresent()) {
            user = any.get();
        }

        return user;
    }

    private User findUserByUID(String uid) {
        User user = null;
        Optional<User> any = this.users.values()
                .stream()
                .filter(u -> u.getUid().equals(UUID.fromString(uid)))
                .findAny();

        if (any.isPresent()) {
            user = any.get();
        }

        return user;
    }
}