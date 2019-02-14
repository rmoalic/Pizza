package fr.ensibs.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * The payement service for our pizza place thing
 */
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
@WebService(name = "PayementService", targetNamespace="Pizza")
public interface PayementService {
    /**
     * Retrieve the total amount left to pay
     * @param uid session token
     * @return the total to pay in €
     */
    @WebMethod(operationName = "getTotal")
    int getTotal(@WebParam(name="customerUID") String uid);

    /**
     * Mark all the pizzas as payed
     * @param uid session token
     * @return true
     */
    @WebMethod(operationName = "payTotal")
    boolean payTotal(@WebParam(name="customerUID") String uid);
}
