package operation.league;

import abst.operation.GenericOperation;
import domain.League;
import java.util.List;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da dobije sve lige iz baze podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju dobijanja svih liga iz baze podataka.
 * 
 * @author Radin
 */
public class GetAllLeagues extends GenericOperation{
	/**
     * Lista liga dobijena iz baze podataka.
     */
    List<League> leagues;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        leagues = repository.getAll((League) param);
    }

    /**
     * Vraća listu svih liga dobijenih iz baze podataka.
     * 
     * @return Lista liga kao objekti tipa League.
     */
    public List<League> getLeagues() {
        return leagues;
    }
}