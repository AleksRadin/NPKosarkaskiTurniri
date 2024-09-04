package operation.listOfReferees;

import abst.operation.GenericOperation;
import domain.ListOfReferees;

/**
 *
 * @author Radin
 */
public class AddListOfReferees extends GenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((ListOfReferees) param);
    }
    
}