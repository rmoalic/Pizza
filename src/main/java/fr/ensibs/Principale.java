package fr.ensibs;

import fr.ensibs.services.OrderServiceImpl;
import fr.ensibs.services.PayementServiceImpl;
import fr.ensibs.services.UserServiceImpl;

import javax.xml.ws.Endpoint;

public class Principale {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl(userService);
        Endpoint.publish("http://localhost:9991/ws/userservice", userService);
        Endpoint.publish("http://localhost:9991/ws/orderservice", orderService);
        Endpoint.publish("http://localhost:9991/ws/payementservice", new PayementServiceImpl(orderService));

    }
}
