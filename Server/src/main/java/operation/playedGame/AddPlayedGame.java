package operation.playedGame;

import abst.operation.GenericOperation;
import domain.PlayedGame;

/**
 *
 * @author Radin
 */
public class AddPlayedGame extends GenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((PlayedGame) param);
    }
    
}