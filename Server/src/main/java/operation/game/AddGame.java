package operation.game;

import abst.operation.GenericOperation;
import domain.Game;
import domain.GenericEntity;

/**
 *
 * @author Radin
 */
public class AddGame extends GenericOperation{
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
         repository.add((Game) param);
    }
}