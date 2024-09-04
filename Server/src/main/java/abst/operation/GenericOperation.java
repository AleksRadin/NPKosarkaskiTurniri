package abst.operation;

import repository.db.DbRepository;
import repository.db.impl.RepositoryDBGeneric;
import repository.inter.Repository;

/**
 *
 * @author Radin
 */
public abstract class GenericOperation {
    
    protected final Repository repository;

    public GenericOperation() {
        this.repository = new RepositoryDBGeneric();
    }
    
    public final void execute(Object param) throws Exception {
        try {
            preconditions(param);
            startTransaction();
            executeOperation(param);
            commitTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        } finally {
            disconnect();
        }
    }

    // Operation-specific method
    protected abstract void preconditions(Object param) throws Exception;

    private void startTransaction() throws Exception {
        ((DbRepository) repository).connect();
    }

    // Operation-specific method
    protected abstract void executeOperation(Object param) throws Exception;

    private void commitTransaction() throws Exception {
        ((DbRepository) repository).commit();
    }

    private void rollbackTransaction() throws Exception {
        ((DbRepository) repository).rollback();
    }

    private void disconnect() throws Exception {
        ((DbRepository) repository).disconnect();
    }
    
    
}
