package operation.game;

import abst.operation.GenericOperation;
import domain.Game;
import java.util.List;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da dobije sve igre iz baze podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju dobijanja svih igara iz baze podataka.
 * 
 * @author Radin
 */
public class GetAllGames extends GenericOperation{
	/**
     * Lista igara dobijena iz baze podataka.
     */
    List<Game> games;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        games = repository.getAll((Game) param);
    }

    /**
     * Vraća listu svih igara dobijenih iz baze podataka.
     * 
     * @return Lista igara kao objekti tipa Game.
     */
    public List<Game> getGames() {
        return games;
    }
}