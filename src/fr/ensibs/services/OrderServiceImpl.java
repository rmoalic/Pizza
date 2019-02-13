package fr.ensibs.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import fr.ensibs.data.Commande;
import fr.ensibs.data.Pizza;
import fr.ensibs.data.User;

/**
 * {@inheritDoc}
 */
@WebService(endpointInterface="fr.ensibs.services.OrderService", serviceName="OrderService", portName="OrderPort")
public class OrderServiceImpl implements OrderService {
	
	List<Pizza> pizzas = new ArrayList<>();
	List<Commande> orders = new ArrayList<>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean order(User user, Pizza pizza) {
		if (user == null)
			throw new NullPointerException("User is null");
		else if (pizza == null)
			throw new NullPointerException("Pizza is null");
		Commande order = new Commande(user, pizza);
		return this.orders.add(order);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addPizza(String name, int price) {
		if (name.isEmpty())
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
	public List<Pizza> getPizzasList() {
		return this.pizzas;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Commande> getUserOrdersList(User user) {
		List<Commande> list = new ArrayList<>();
		for(Commande order : this.orders)
			if(order.getUser() == user)
				list.add(order);
		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Pizza findPizzaById(int id) {
		for(Pizza pizza : this.pizzas)
			if(pizza.getId() == id)
				return pizza;
		throw new NullPointerException("no pizza with this id");
	}

}
