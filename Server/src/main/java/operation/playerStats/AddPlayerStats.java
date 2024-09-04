package operation.playerStats;

import abst.operation.GenericOperation;
import domain.PlayerStatistic;


/**
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