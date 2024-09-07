package operation.user;

import abst.operation.GenericOperation;
import domain.User;
import java.util.List;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da dohvati sve korisnike iz baze podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju za dobijanje svih objekata User iz baze podataka.
 * Metoda executeOperation koristi repository za dobijanje svih objekata User i čuva ih u privatnom atributu users.
 * 
 * @author Radin
 */
public class GetAllUsers extends GenericOperation{
	/**
     * Lista koja čuva dobijene korisnike.
     */
    List<User> users;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        users = repository.getAll((User) param);
    }
    
    /**
     * Vraća listu svih korisnika dobijenih iz baze podataka.
     * 
     * @return Lista objekata tipa User koja sadrži sve korisnike.
     */
    public List<User> getUsers() {
        return users;
    }
}
