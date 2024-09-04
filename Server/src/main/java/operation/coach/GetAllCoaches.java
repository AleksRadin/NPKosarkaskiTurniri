package operation.coach;

import abst.operation.GenericOperation;
import domain.Coach;
import java.util.List;

/**
 *
 * @author Radin
 */
public class GetAllCoaches extends GenericOperation{
    private List<Coach> coaches;

    @Override
    protected void preconditions(Object param) throws Exception {
        // Implement any preconditions for getting all coaches if needed
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        coaches = repository.getAll((Coach) param);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}