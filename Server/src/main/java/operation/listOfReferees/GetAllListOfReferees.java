package operation.listOfReferees;

import abst.operation.GenericOperation;
import domain.ListOfReferees;
import java.util.List;

/**
 *
 * @author Radin
 */
public class GetAllListOfReferees extends GenericOperation{

    List<ListOfReferees> list;
    
    @Override
    protected void preconditions(Object param) throws Exception {    
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.getAll((ListOfReferees) param);
    }

    public List<ListOfReferees> getList() {
        return list;
    }
    
    
}