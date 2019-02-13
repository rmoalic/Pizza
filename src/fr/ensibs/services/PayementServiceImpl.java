package fr.ensibs.services;

import fr.ensibs.data.Commande;
import fr.ensibs.data.User;

import javax.jws.WebService;

@WebService(endpointInterface="fr.ensibs.services.PayementService", serviceName="PayementService", portName="PayementPort")
public class PayementServiceImpl implements PayementService {
    private OrderServiceImpl osi;


    public PayementServiceImpl(OrderServiceImpl osi) {
        this.osi = osi;
    }

    @Override
    public int getTotal(String uid) {
        int sum = 0;
        for (Commande c : this.osi.getUserOrdersList(uid)) {
            if (!c.getPaid())
                sum += c.getPizza().getPrice();
        }

        return sum;
    }

    @Override
    public boolean payTotal(String uid) {
        for (Commande c : this.osi.getUserOrdersList(uid)) {
            c.setPaid(true);
        }

        return true;
    }
}
