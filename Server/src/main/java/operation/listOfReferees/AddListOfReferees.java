package operation.listOfReferees;

import java.util.List;

import abst.operation.GenericOperation;
import controller.Controller;
import domain.GenericEntity;
import domain.ListOfReferees;
import repository.db.impl.RepositoryDBGeneric;

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
        repository.add((ListOfReferees)param);
    }
    
}