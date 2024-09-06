package operation.playedGame;

import abst.operation.GenericOperation;
import domain.PlayedGame;
import java.util.List;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da dobije sve odigrane utakmice iz baze podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju za preuzimanje liste svih odigranih utakmica iz baze podataka.
 * 
 * @author Radin
 */
public class GetAllPlayedGames extends GenericOperation{
	/**
     * Lista odigranih utakmica preuzetih iz baze podataka.
     */
    List<PlayedGame> playedGames;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        playedGames = repository.getAll((PlayedGame) param);
    }

    /**
     * Vraća listu svih odigranih utakmica preuzetih iz baze podataka.
     * 
     * @return Lista objekata tipa PlayedGame koji predstavljaju sve odigrane utakmice.
     */
    public List<PlayedGame> getPlayedGames() {
        return playedGames;
    }
}