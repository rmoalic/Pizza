package fr.ensibs.services;

import java.util.ArrayList;
import javax.jws.WebService;

import fr.ensibs.data.Commande;
import fr.ensibs.data.Pizza;
import fr.ensibs.data.User;

/**
 * Represents the order web service.
 */
@WebService(endpointInterface="fr.ensibs.services.OrderService", serviceName="OrderService", portName="OrderPort")
public class OrderServiceImpl implements OrderService {
	
	UserServiceImpl userService;
	public  static OrderServiceImpl instance;
	
	private ArrayList<Pizza> pizzas = new ArrayList<>();
	private ArrayList<Commande> orders = new ArrayList<>();

	public OrderServiceImpl() {
		OrderServiceImpl.instance = this;
		this.userService = UserServiceImpl.instance;
	}

	/**
	 * Construct the order service
	 * @param userService the user service
	 */
	public OrderServiceImpl(UserServiceImpl userService) {
		OrderServiceImpl.instance = this;
		this.userService = userService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean order(String userUid, int pizzaId) {
		User user = userService.findUserByUID(userUid);
		if(user == null || user.getRole() != Roles.CUSTOMER)
			throw new NullPointerException("user not authorized");
		Pizza pizza = this.findPizzaById(pizzaId);
		Commande order = new Commande(user, pizza);
		return this.orders.add(order);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addPizza(String userUid, String name, int price) {
		User user = userService.findUserByUID(userUid);
		if(user == null || user.getRole() != Roles.ADMIN)
			throw new NullPointerException("user not authorized");
		else if (name.isEmpty())
			throw new NullPointerException("name is empty");
		else if (price < 0)
			throw new NullPointerException("price is negative");
		Pizza pizza = new Pizza(name, price);
		return this.pizzas.add(pizza);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<Pizza> getPizzasList() {
		return this.pizzas;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<Commande> getUserOrdersList(String userUid) {
		User user = userService.findUserByUID(userUid);
		if(user == null || user.getRole() != Roles.CUSTOMER)
			throw new NullPointerException("user not authorized");
		ArrayList<Commande> list = new ArrayList<>();
		for(Commande order : this.orders)
			if(order.getUser().getId() == user.getId())
				list.add(order);
		return list;
	}

	/**
     * Get the pizza corresponding to the id.
     * @param id the pizza id
     * @return the corresponding pizza
     */
	Pizza findPizzaById(int id) {
		for(Pizza pizza : this.pizzas)
			if(pizza.getId() == id)
				return pizza;
		throw new NullPointerException("no pizza with this id");
	}

}
