package operation.team;

import abst.operation.GenericOperation;
import domain.Player;
import domain.Team;
import player.state.PlayerState;

/**
 *
 * @author Radin
 */
public class EditTeam extends GenericOperation{
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Team team = (Team) param;
        repository.edit(team);
//        for (Player player : team.getPlayers()) {
//            if(player.getState().equals(PlayerState.EDITED)){
//                repository.edit(player);
//            }
//        }

        for (Player player : team.getPlayers()) {
            switch (player.getState()) {
                case DELETED:
                    repository.delete(player);  
                    break;
                case ADDED:
                    repository.add(player);     
                    break;
                case EDITED:
                    repository.edit(player);    
                    break;
                default:
                    
                    break;
            }
        }
    }
}
