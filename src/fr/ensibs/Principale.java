package fr.ensibs;

import fr.ensibs.services.UserServiceImpl;

import javax.xml.ws.Endpoint;

public class Principale {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9991/ws/userservice", new UserServiceImpl());
    }
}
