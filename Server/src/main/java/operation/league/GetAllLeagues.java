package operation.league;

import abst.operation.GenericOperation;
import domain.League;
import java.util.List;

/**
 *
 * @author Radin
 */
public class GetAllLeagues extends GenericOperation{
    List<League> leagues;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        leagues = repository.getAll((League) param);
    }

    public List<League> getLeagues() {
        return leagues;
    }
}