package fr.ensibs.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a pizza.
 */
@XmlRootElement
public class Pizza {
	
	private int id;
    private String name;
    private int price;
    
    private static int nb = 0;
    
    private Pizza() {}
    
    /**
     * Construct a pizza.
     * @param name the pizza name
     * @param price the pizza price
     */
    public Pizza(String name, int price) {
    	this.id = nb;
    	nb++;
    	this.name = name;
    	this.price = price;
    }
    
    /**
     * Get the pizza id.
     * @return the pizza id
     */
    @XmlElement(name="id")
    public int getId() {
    	return this.id;
    }
    
    /**
     * Get the pizza name.
     * @return the pizza name
     */
    @XmlElement(name="name")
    public String getName() {
    	return this.name;
    }
    
    /**
     * Get the pizza price.
     * @return the pizza price
     */
    @XmlElement(name="price")
    public int getPrice() {
    	return this.price;
    }

}
