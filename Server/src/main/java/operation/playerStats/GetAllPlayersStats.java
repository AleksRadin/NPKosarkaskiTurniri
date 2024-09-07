package operation.playerStats;

import abst.operation.GenericOperation;
import domain.PlayerStatistic;
import java.util.List;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da preuzme sve statistike igrača iz baze podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju za preuzimanje svih statistika igrača iz baze podataka.
 * 
 * @author Radin
 */
public class GetAllPlayersStats extends GenericOperation{
	/** Lista koja sadrži sve statistike igrača preuzete iz baze podataka. */
    List<PlayerStatistic> playersStats;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        playersStats = repository.getAll((PlayerStatistic) param);
    }

    /**
     * Vraća listu svih statistika igrača preuzetih iz baze podataka.
     * 
     * @return Lista statistika igrača.
     */
    public List<PlayerStatistic> getPlayersStats() {
        return playersStats;
    }

}