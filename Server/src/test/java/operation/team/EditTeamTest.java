package operation.team;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Player;
import domain.Team;
import player.state.PlayerState;
import controller.Controller;

public class EditTeamTest {

    @Test
    void testExecuteOperation() throws Exception {

        List<Team> allTeams = Controller.getInstance().getAllTeams(new Team());
        List<Player> allPlayers = Controller.getInstance().getAllPlayers(new Player());

 
        Team teamToEdit = allTeams.get(0);


        List<Player> teamPlayers = new ArrayList<>();
        for (Player player : allPlayers) {
            if (player.getTeam().getId().equals(teamToEdit.getId())) {
                teamPlayers.add(player);
            }
        }


        for (Player player : teamPlayers) {
            player.setState(PlayerState.UNCHANGED);
        }


        if (!teamPlayers.isEmpty()) {
        	
        	
        	teamToEdit.setPlayers(teamPlayers);
        	teamToEdit.getPlayers().get(0).setFirstname("Marko");
        	teamToEdit.getPlayers().get(0).setHeight(2.10);
        	teamToEdit.getPlayers().get(0).setState(PlayerState.EDITED);


            Player newPlayer = new Player(1L, "New Player", "New LastName", LocalDate.of(2001, 1, 1), "GUARD", 180, 75, PlayerState.ADDED);
            newPlayer.setTeam(teamToEdit);
            
            teamToEdit.getPlayers().add(newPlayer);
            
            teamToEdit.getPlayers().get(2).setState(PlayerState.DELETED);
            Player deletedPlayer = teamToEdit.getPlayers().get(1);

            
            EditTeam editTeamOperation = new EditTeam();
            editTeamOperation.executeOperation(teamToEdit);


            List<Team> updatedTeams = Controller.getInstance().getAllTeams(new Team());
            List<Player> updatedPlayers = Controller.getInstance().getAllPlayers(new Player());
            
            boolean containsUpdatedTeam = updatedTeams.contains(teamToEdit);
            boolean containsNewPlayer = updatedPlayers.contains(newPlayer);
            boolean containsEditedPlayer = updatedPlayers.contains(teamToEdit.getPlayers().get(0));
            boolean containsDeletedPlayer = false;
            
            for (Player player : updatedPlayers) {
				if(player.getId().equals(deletedPlayer.getId())) {
					containsDeletedPlayer = true;
				}
			}

            assertTrue(containsUpdatedTeam, "The updated team should be present in the list.");
            assertTrue(containsNewPlayer, "The new player should be present in the list.");
            assertTrue(containsEditedPlayer, "The edited player should be present in the list.");
            assertTrue(containsDeletedPlayer, "The player marked for deletion should not be present in the list.");
        }
    }
}
