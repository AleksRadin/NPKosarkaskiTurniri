package operation.teamStats;

import abst.operation.GenericOperation;
import domain.TeamStatistic;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da sačuva statistiku tima u bazi podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju za dodavanje statistike tima u bazu podataka.
 * Metoda executeOperation koristi repository za dodavanje objekta TeamStatistic u bazu podataka.
 * 
 * @author Radin
 */
public class AddTeamStats extends GenericOperation{
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
         repository.add((TeamStatistic) param);
    }
}