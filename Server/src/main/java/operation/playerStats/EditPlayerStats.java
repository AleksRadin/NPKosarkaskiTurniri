package operation.playerStats;

import abst.operation.GenericOperation;
import domain.PlayerStatistic;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da izmeni statistiku igrača u bazi podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju za ažuriranje statistike igrača u bazi podataka.
 * 
 * @author Radin
 */
public class EditPlayerStats extends GenericOperation{
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((PlayerStatistic) param);
    }
}