package fr.ensibs.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents an order.
 */
@XmlRootElement
public class Commande {
	
	private int id;
	private User user;
    private Pizza pizza;
    private boolean paid;
    
    private static int nb = 0;
    
    private Commande() {}
    
    /**
     * Construct an order.
     * @param user the user who made the order
     * @param pizza the ordered pizza
     */
    public Commande(User user, Pizza pizza) {
    	this.id = nb;
    	nb++;
    	this.user = user;
    	this.pizza = pizza;
    	this.paid = false;
    }
    
    /**
     * Get the order id.
     * @return the order id
     */
    @XmlElement(name="id")
    public int getId() {
    	return this.id;
    }
    
    /**
     * Get the user who made the order.
     * @return the user
     */
    @XmlTransient
    public User getUser() {
    	return this.user;
    }
    
    /**
     * Get the ordered pizza.
     * @return the ordered pizza
     */
    @XmlElement(name="pizza")
    public Pizza getPizza() {
    	return this.pizza;
    }
    
    /**
     * Get the order paiement status.
     * @return true if the order was paid, false otherwise
     */
    @XmlElement(name="paid")
    public boolean getStatus() {
    	return this.paid;
    }

}
