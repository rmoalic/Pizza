package fr.ensibs.services;

import javax.jws.WebService;

/**
 * The payement service for our pizza place thing
 */
@WebService(name = "PayementService", targetNamespace="Pizza")
public interface PayementService {
    /**
     * Retrieve the total amount left to pay
     * @param uid session token
     * @return the total to pay in €
     */
    int getTotal(String uid);

    /**
     * Mark all the pizzas as payed
     * @param uid session token
     * @return true
     */
    boolean payTotal(String uid);
}
