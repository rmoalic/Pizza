package fr.ensibs.data;

public class Commande {
	
	private int id;
	private User user;
    private Pizza pizza;
    private boolean paid;
    
    private static int nb = 0;
    
    public Commande(User user, Pizza pizza) {
    	this.id = nb;
    	nb++;
    	this.user = user;
    	this.pizza = pizza;
    	this.paid = false;
    }
    
    public int getId() {
    	return this.id;
    }
    
    public User getUser() {
    	return this.user;
    }
    
    public Pizza getPizza() {
    	return this.pizza;
    }
    
    public boolean getStatus() {
    	return this.paid;
    }

}
