package operation.team;

import abst.operation.GenericOperation;
import domain.Team;
import java.util.List;

/**
 *
 * @author Radin
 */
public class GetAllTeams extends GenericOperation{
    List<Team> teams;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        teams = repository.getAll((Team) param);
    }
    
    public List<Team> getTeams() {
        return teams;
    }    
}
