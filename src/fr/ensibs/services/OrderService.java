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
	 * @param user the user who made the order
	 * @param pizza the ordered pizza
	 * @return true if the order was made, false otherwise
	 */
	boolean order(String userUid, int pizzaId);
	
	/**
	 * Add a pizza to the list.
	 * @param name the pizza name
	 * @param price the pizza price
	 * @return true if the pizza was added, false otherwise
	 */
	boolean addPizza(String name, int price);
	
	/**
	 * Get the pizzas list.
	 * @return the pizza list
	 */
	List<Pizza> getPizzasList();
	
	/**
	 * Get the orders list for a user.
	 * @param user the user
	 * @return the orders list
	 */
    List<Commande> getUserOrdersList(int userId);
    
    /**
     * Get the pizza corresponding to the id.
     * @param id the pizza id
     * @return the corresponding pizza
     */
    Pizza findPizzaById(int id);

}
