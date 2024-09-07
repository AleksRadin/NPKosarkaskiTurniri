package operation.team;

import abst.operation.GenericOperation;
import domain.Player;
import domain.Team;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da doda tim u bazu podataka, zajedno sa svim igračima koji pripadaju tom timu.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju za dodavanje tima i njegovih igrača u bazu podataka.
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