package fr.ensibs.services;

import fr.ensibs.data.Commande;
import fr.ensibs.data.User;

import javax.jws.WebService;

/**
 * The payement service for our pizza place thing
 */
@WebService(endpointInterface="fr.ensibs.services.PayementService", serviceName="PayementService", portName="PayementPort")
public class PayementServiceImpl implements PayementService {
    private OrderServiceImpl osi;

    public PayementServiceImpl() {}

    /**
     * Constructor
     * @param osi the Order service
     */
    public PayementServiceImpl(OrderServiceImpl osi) {
        this.osi = osi;
    }

    @Override
    public int getTotal(String uid) {
        User user = this.osi.userService.findUserByUID(uid);
        if(user == null || user.getRole() != Roles.ADMIN)
            throw new NullPointerException("user not authorized");

        int sum = 0;
        for (Commande c : this.osi.getUserOrdersList(uid)) {
            if (!c.getPaid())
                sum += c.getPizza().getPrice();
        }

        return sum;
    }

    @Override
    public boolean payTotal(String uid) {
        User user = this.osi.userService.findUserByUID(uid);
        if(user == null || user.getRole() != Roles.ADMIN)
            throw new NullPointerException("user not authorized");
        
        for (Commande c : this.osi.getUserOrdersList(uid)) {
            c.setPaid(true);
        }

        return true;
    }
}
