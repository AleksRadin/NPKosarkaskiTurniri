package operation.playerStats;

import abst.operation.GenericOperation;
import domain.PlayerStatistic;


/**
 * Predstavlja specifičnu operaciju koja ima za cilj da sačuva statistiku igrača u bazi podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju za dodavanje statistike igrača u bazu podataka.
 * 
 * @author Radin
 */
public class AddPlayerStats extends GenericOperation{
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((PlayerStatistic) param);
    }
}