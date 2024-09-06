package operation.team;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Player;
import domain.Team;
import controller.Controller;

public class AddTeamTest {

    @Test
    void testExecuteOperation() throws Exception {
        Player player1 = new Player(1L, "LeBron", "James", null, null, 206, 113, null, null);
        Player player2 = new Player(2L, "Anthony", "Davis", null, null, 208, 115, null, null);

        Team team = new Team(1L, "Lakers", "Los Angeles", "USA", 1947);
        team.getPlayers().add(player1);
        team.getPlayers().add(player2);

        AddTeam addTeamOperation = new AddTeam();
        addTeamOperation.executeOperation(team);

        List<Team> allTeams = Controller.getInstance().getAllTeams(new Team());
        List<Player> allPlayers = Controller.getInstance().getAllPlayers(new Player());


        boolean containsTeam = false;
        for (Team t : allTeams) {
            if (t.getId().equals(team.getId())) {
                containsTeam = true;
                break;
            }
        }


        boolean containsPlayer1 = false;
        boolean containsPlayer2 = false;
        for (Player p : allPlayers) {
            if (p.getId().equals(player1.getId())) {
                containsPlayer1 = true;
            }
            if (p.getId().equals(player2.getId())) {
                containsPlayer2 = true;
            }
        }

        assertTrue(containsTeam, "The added team should be present in the list.");
        assertTrue(containsPlayer1, "The added player1 should be present in the list.");
        assertTrue(containsPlayer2, "The added player2 should be present in the list.");
    }
}
