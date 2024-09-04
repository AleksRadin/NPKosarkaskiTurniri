package operation.playedGame;

import abst.operation.GenericOperation;
import domain.PlayedGame;
import java.util.List;

/**
 *
 * @author Radin
 */
public class GetAllPlayedGames extends GenericOperation{
    List<PlayedGame> playedGames;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        playedGames = repository.getAll((PlayedGame) param);
    }

    public List<PlayedGame> getPlayedGames() {
        return playedGames;
    }
}