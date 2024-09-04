package operation.game;

import abst.operation.GenericOperation;
import domain.Game;
import java.util.List;

/**
 *
 * @author Radin
 */
public class GetAllGames extends GenericOperation{
    List<Game> games;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        games = repository.getAll((Game) param);
    }

    public List<Game> getGames() {
        return games;
    }
}