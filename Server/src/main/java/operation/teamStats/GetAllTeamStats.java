package operation.teamStats;

import abst.operation.GenericOperation;
import domain.TeamStatistic;
import java.util.List;

/**
 *
 * @author Radin
 */
public class GetAllTeamStats extends GenericOperation {
    List<TeamStatistic> teamStats;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        teamStats = repository.getAll((TeamStatistic) param);
    }
    
    public List<TeamStatistic> getTeamStats() {
        return teamStats;
    }  
}
