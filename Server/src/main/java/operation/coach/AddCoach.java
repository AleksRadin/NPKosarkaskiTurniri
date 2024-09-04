package operation.coach;

import abst.operation.GenericOperation;
import domain.Coach;

/**
 *
 * @author Radin
 */
public class AddCoach extends GenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Coach) param);
    }
    
}