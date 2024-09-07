package operation.player;

import abst.operation.GenericOperation;
import domain.Player;
import java.util.List;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da dobije sve igrače iz baze podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju za preuzimanje liste svih igrača iz baze podataka.
 * 
 * @author Radin
 */
public class GetAllPlayers extends GenericOperation{
	/**
     * Lista igrača preuzetih iz baze podataka.
     */
    List<Player> players;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        players = repository.getAll((Player) param);
    }

    /**
     * Vraća listu svih igrača preuzetih iz baze podataka.
     * 
     * @return Lista objekata tipa Player koji predstavljaju sve igrače.
     */
    public List<Player> getPlayers() {
        return players;
    }
}