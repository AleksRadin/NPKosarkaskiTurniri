package operation.coach;

import abst.operation.GenericOperation;
import domain.Coach;

/**
 *
 * @author Radin
 */
public class EditCoach extends GenericOperation{
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Coach) param);
    }
}
