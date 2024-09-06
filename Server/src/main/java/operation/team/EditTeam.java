package operation.team;

import abst.operation.GenericOperation;
import domain.Player;
import domain.Team;
import player.state.PlayerState;

/**
 * Predstavlja specifičnu operaciju koja ima za cilj da izmeni tim u bazi podataka, zajedno sa svim igračima koji pripadaju tom timu.
 * 
 * Ova klasa nasleđuje GenericOperation i implementira operaciju za izmenu tima i njegovih igrača u bazi podataka. 
 * Metoda executeOperation takođe obrađuje različite statusne promene igrača (dodati, izmenjeni, obrisani).
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
    	System.out.println(team.getId() + "bbbbb");
        repository.edit(team);
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
