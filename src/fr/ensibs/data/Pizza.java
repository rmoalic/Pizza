package fr.ensibs.data;

public class Pizza {
	
	private int id;
    private String name;
    private int price;
    
    private static int nb = 0;
    
    public Pizza(String name, int price) {
    	this.id = nb;
    	nb++;
    	this.name = name;
    	this.price = price;
    }
    
    public int getId() {
    	return this.id;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public int getPrice() {
    	return this.price;
    }

}
