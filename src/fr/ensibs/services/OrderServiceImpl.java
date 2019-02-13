package fr.ensibs.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import fr.ensibs.data.Commande;
import fr.ensibs.data.Pizza;
import fr.ensibs.data.User;

@WebService(endpointInterface="fr.ensibs.services.OrderService", serviceName="OrderService", portName="OrderPort")
public class OrderServiceImpl implements OrderService {
	
	List<Pizza> pizzas = new ArrayList<>();
	List<Commande> orders = new ArrayList<>();

	@Override
	public boolean order(User user, Pizza pizza) {
		if (user == null)
			throw new NullPointerException("Person is null");
		else if (pizza == null)
			throw new NullPointerException("Pizza is null");
		Commande order = new Commande(user, pizza);
		return this.orders.add(order);
	}

	@Override
	public List<Pizza> getPizzasList() {
		return this.pizzas;
	}

	@Override
	public List<Commande> getUserOrdersList(User user) {
		List<Commande> list = new ArrayList<>();
		for(Commande order : this.orders)
			if(order.getUser() == user)
				list.add(order);
		return list;
	}

}
