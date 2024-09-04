package operation.teamStats;

import abst.operation.GenericOperation;
import domain.TeamStatistic;

/**
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