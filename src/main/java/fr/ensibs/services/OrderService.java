package fr.ensibs.services;

import java.util.ArrayList;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import fr.ensibs.data.Commande;
import fr.ensibs.data.Pizza;

/**
 * Represents the order web service.
 */
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
@WebService(name = "OrderService", targetNamespace="Pizza")
public interface OrderService {
	
	/**
	 * Make a pizza order for a user.
	 * @param userUid the user token
	 * @param pizzaId the pizza id
	 * @return true if the order was made, false otherwise
	 */
	boolean order(@WebParam(name="customerUID") String userUid, @WebParam(name="pizzaID") int pizzaId);
	
	/**
	 * Add a pizza to the list.
	 * @param userUid the user token
	 * @param name the pizza name
	 * @param price the pizza price
	 * @return true if the pizza was added, false otherwise
	 */
	boolean addPizza(@WebParam(name="adminUID") String userUid, @WebParam(name="pizzaName") String name, @WebParam(name="pizzaPrice") int price);
	
	/**
	 * Get the pizzas list.
	 * @return the pizza list
	 */
	ArrayList<Pizza> getPizzasList();
	
	/**
	 * Get the orders list for a user.
	 * @param userUid the user token
	 * @return the orders list
	 */
    ArrayList<Commande> getUserOrdersList(@WebParam(name="customerUID") String userUid);

}
