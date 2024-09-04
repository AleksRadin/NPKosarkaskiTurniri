package operation.playerStats;

import abst.operation.GenericOperation;
import domain.PlayerStatistic;
import java.util.List;

/**
 *
 * @author Radin
 */
public class GetAllPlayersStats extends GenericOperation{
    List<PlayerStatistic> playersStats;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        playersStats = repository.getAll((PlayerStatistic) param);
    }

    public List<PlayerStatistic> getPlayersStats() {
        return playersStats;
    }

}