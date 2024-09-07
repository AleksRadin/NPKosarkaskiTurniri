package operation.team;

import abst.operation.GenericOperation;
import domain.Team;
import java.util.List;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da dobije sve timove iz baze podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju za preuzimanje svih timova iz baze podataka.
 * Metoda executeOperation koristi repository za preuzimanje podataka o timovima, dok se metoda getTeams
 * koristi za vraćanje rezultata.
 * 
 * @author Radin
 * @since 1.0
 */
public class GetAllTeams extends GenericOperation{
	/**
     * Lista timova koja se koristi za skladištenje rezultata operacije preuzimanja timova iz baze podataka.
     */
    List<Team> teams;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        teams = repository.getAll((Team) param);
    }
    
    /**
     * Vraća listu svih timova preuzetih iz baze podataka.
     * 
     * @return Lista timova.
     */
    public List<Team> getTeams() {
        return teams;
    }    
}
