package operation.teamStats;

import abst.operation.GenericOperation;
import domain.TeamStatistic;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da ažurira statistiku tima u bazi podataka.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju za ažuriranje objekta TeamStatistic u bazi podataka.
 * Metoda executeOperation koristi repository za ažuriranje objekta TeamStatistic u bazi podataka.
 * 
 * @author Radin
 */
public class EditTeamStats extends GenericOperation{
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((TeamStatistic) param);
    }
}
