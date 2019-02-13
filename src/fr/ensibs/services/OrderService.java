package fr.ensibs.services;

import java.util.List;

import javax.jws.WebService;

import fr.ensibs.data.Commande;
import fr.ensibs.data.Pizza;
import fr.ensibs.data.User;

@WebService(name = "OrderService", targetNamespace="Pizza")
public interface OrderService {
	
	boolean order(User user, Pizza pizza);
	
	List<Pizza> getPizzasList();
	
    List<Commande> getUserOrdersList(User user);

}
