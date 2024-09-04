package operation.player;

import abst.operation.GenericOperation;
import domain.Player;
import java.util.List;

/**
 *
 * @author Radin
 */
public class GetAllPlayers extends GenericOperation{
    List<Player> players;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        players = repository.getAll((Player) param);
    }

    public List<Player> getPlayers() {
        return players;
    }
}