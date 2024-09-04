package operation.team;

import abst.operation.GenericOperation;
import domain.Player;
import domain.Team;

/**
 *
 * @author Radin
 */
public class AddTeam extends GenericOperation{
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
         try {
            Team team = (Team) param;
            repository.add(team);
             for (Player player : team.getPlayers()) {
                 player.setTeam(team);
                 repository.add(player);
             }
        } catch (Exception e) {
        }
    }
}