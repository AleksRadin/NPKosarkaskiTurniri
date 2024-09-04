package operation.user;

import abst.operation.GenericOperation;
import domain.User;
import java.util.List;

/**
 *
 * @author Radin
 */
public class GetAllUsers extends GenericOperation{
    List<User> users;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        users = repository.getAll((User) param);
    }
    
    public List<User> getUsers() {
        return users;
    }
}
