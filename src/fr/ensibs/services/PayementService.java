package fr.ensibs.services;

import javax.jws.WebService;

@WebService(name = "PayementService", targetNamespace="Pizza")
public interface PayementService {
    int getTotal(String uid);
    boolean payTotal(String uid);
}
