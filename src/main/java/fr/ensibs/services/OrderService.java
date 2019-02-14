package fr.ensibs.services;

import java.util.List;

import javax.jws.WebService;

import fr.ensibs.data.Commande;
import fr.ensibs.data.Pizza;
import fr.ensibs.data.User;

/**
 * Represents the order web service.
 */
@WebService(name = "OrderService", targetNamespace="Pizza")
public interface OrderService {
	
	/**
	 * Make a pizza order for a user.
	 * @param userUid the user token
	 * @param pizzaId the pizza id
	 * @return true if the order was made, false otherwise
	 */
	boolean order(String userUid, int pizzaId);
	
	/**
	 * Add a pizza to the list.
	 * @param userUid the user token
	 * @param name the pizza name
	 * @param price the pizza price
	 * @return true if the pizza was added, false otherwise
	 */
	boolean addPizza(String userUid, String name, int price);
	
	/**
	 * Get the pizzas list.
	 * @return the pizza list
	 */
	List<Pizza> getPizzasList();
	
	/**
	 * Get the orders list for a user.
	 * @param userUid the user token
	 * @return the orders list
	 */
    List<Commande> getUserOrdersList(String userUid);

}