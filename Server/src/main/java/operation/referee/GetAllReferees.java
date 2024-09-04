package operation.referee;

import abst.operation.GenericOperation;
import domain.Referee;
import java.util.List;

/**
 *
 * @author Radin
 */
public class GetAllReferees extends GenericOperation{
    List<Referee> referees;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        referees = repository.getAll((Referee) param);
    }
    
    public List<Referee> getReferees() {
        return referees;
    }
}
