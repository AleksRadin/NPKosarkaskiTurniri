package operation.team;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Player;
import domain.Team;
import controller.Controller;

public class AddTeamTest {

    @Test
    void testExecuteOperation() throws Exception {
        Player player1 = new Player(1L, "LeBron", "James", LocalDate.of(2000, 2, 1), "CENTAR", 206, 113, null, null);
        Player player2 = new Player(2L, "Anthony", "Davis", LocalDate.of(1993, 3, 11), "SMALLFORWARD", 208, 115, null, null);

        Team team = new Team(1L, "Lakers", "Los Angeles", "USA", 1947);
        team.getPlayers().add(player1);
        team.getPlayers().add(player2);
        player1.setTeam(team);
        player2.setTeam(team);

        AddTeam addTeamOperation = new AddTeam();
        addTeamOperation.executeOperation(team);

        List<Team> allTeams = Controller.getInstance().getAllTeams(new Team());
        List<Player> allPlayers = Controller.getInstance().getAllPlayers(new Player());

        assertTrue(allTeams.contains(team), "The added team should be present in the list.");
        assertTrue(allPlayers.contains(player1), "The added player1 should be present in the list.");
        assertTrue(allPlayers.contains(player2), "The added player2 should be present in the list.");
    
    }
}
